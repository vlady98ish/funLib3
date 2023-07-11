package com.example.funlib3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
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
    // Declare TextView and Handler
    private TextView textView;

    private Handler handler = new Handler(Looper.getMainLooper());

    // Runnable to fetch fun facts every 15 seconds
    private Runnable funFactRunnable = new Runnable() {
        @Override
        public void run() {
            fetchFunFact();
            handler.postDelayed(this, 15000);
        }
    };

    // Constructor
    public FunFactsLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Obtain styled attributes from theme
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FunFactsLoadingView,
                0, 0);
        Drawable backgroundDrawable;
        float fontSize;
        int fontStyle;
        int textColor;
        String fontFamily;
        try {
            // Get attribute values
            backgroundDrawable = a.getDrawable(R.styleable.FunFactsLoadingView_backgroundImage);
            fontSize = a.getDimension(R.styleable.FunFactsLoadingView_customFontSize, 15);
            fontStyle = a.getInt(R.styleable.FunFactsLoadingView_customFontStyle, 0);
            fontFamily = a.getString(R.styleable.FunFactsLoadingView_customFontFamily);
            textColor = a.getColor(R.styleable.FunFactsLoadingView_customTextColor, Color.BLACK);
        } finally {
            // Recycle the TypedArray to free up heap space
            a.recycle();
        }
        // Set background image
        setBackground(backgroundDrawable);

        // Check screen orientation
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Inflate layout for landscape orientation
            inflate(context, R.layout.view_loading_land, this);
        } else {
            // Inflate layout for portrait orientation
            inflate(context, R.layout.view_loading, this);
        }
        // Get the TextView
        textView = findViewById(R.id.funFactTextView);

        // Set text view properties
        textView.setTextSize(fontSize);
        textView.setTypeface(null, fontStyle);
        textView.setTextColor(textColor);


        // Set font family if it's specified
        if (fontFamily != null) {
            Typeface typeface = Typeface.create(fontFamily, Typeface.NORMAL);
            textView.setTypeface(typeface);
        }

        // Start fetching fun facts
        handler.post(funFactRunnable);
    }


    // Setter methods for the view properties
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

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }



    // Method to fetch a fun fact from the API
    private void fetchFunFact() {
        FunFactsApi api = RetrofitService.buildService(FunFactsApi.class);
        api.getRandomFunFact().enqueue(new Callback<FunFact>() {
            @Override
            public void onResponse(Call<FunFact> call, Response<FunFact> response) {
                if (response.body() != null) {
                    // Display the fun fact
                    textView.setText(response.body().getFact());
                } else {
                    // Display loading message
                    textView.setText("Loading...");
                }
            }

            @Override
            public void onFailure(Call<FunFact> call, Throwable t) {
                // Display error message
                textView.setText("Failed to load fun fact.");
            }
        });
    }

    // Remove the callbacks when the view is detached
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(funFactRunnable);
    }
}

