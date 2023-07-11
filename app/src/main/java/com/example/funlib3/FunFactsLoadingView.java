package com.example.funlib3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunFactsLoadingView extends LinearLayout {

    private TextView textView;

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable funFactRunnable = new Runnable() {
        @Override
        public void run() {
            fetchFunFact();
            handler.postDelayed(this, 15000);
        }
    };

    public FunFactsLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FunFactsLoadingView,
                0, 0);
        Drawable backgroundDrawable;

        try {
            backgroundDrawable = a.getDrawable(R.styleable.FunFactsLoadingView_backgroundImage);

        } finally {
            a.recycle();
        }

        setBackground(backgroundDrawable);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            inflate(context, R.layout.view_loading_land, this);
        } else {
            inflate(context, R.layout.view_loading, this);
        }

        textView = findViewById(R.id.funFactTextView);

        // These lines should be here, after the textView is initialized.
        float fontSize = a.getDimension(R.styleable.FunFactsLoadingView_customFontSize, 15); // Default size is 15sp
        textView.setTextSize(fontSize);

        int fontStyle = a.getInt(R.styleable.FunFactsLoadingView_customFontStyle, 0); // Default style is normal
        textView.setTypeface(null, fontStyle);

        String fontFamily = a.getString(R.styleable.FunFactsLoadingView_customFontFamily); // Default is null
        if (fontFamily != null) {
            Typeface typeface = Typeface.create(fontFamily, Typeface.NORMAL);
            textView.setTypeface(typeface);
        }

        handler.post(funFactRunnable);
    }

    public void setBackgroundImage(Drawable image) {
        setBackground(image);
    }

    public void setFontSize(float size) {
        textView.setTextSize(size);
    }

    public void setFontStyle(int style) {
        textView.setTypeface(textView.getTypeface(), style);
    }

    public void setFontFamily(Typeface family) {
        textView.setTypeface(family);
    }




    private void fetchFunFact() {
        FunFactsApi api = RetrofitService.buildService(FunFactsApi.class);
        api.getRandomFunFact().enqueue(new Callback<FunFact>() {
            @Override
            public void onResponse(Call<FunFact> call, Response<FunFact> response) {
                if (response.body() != null) {
                    textView.setText(response.body().getFact());
                } else {
                    textView.setText("Loading...");
                }
            }

            @Override
            public void onFailure(Call<FunFact> call, Throwable t) {
                textView.setText("Failed to load fun fact.");
            }
        });
    }

    // Make sure to remove the callbacks when the view is detached
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(funFactRunnable);
    }
}

