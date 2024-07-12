package com.example.funlib3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunFactsLoadingView extends LinearLayout {

    public FunFactsLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FunFactsLoadingView);
        Drawable backgroundImage = typedArray.getDrawable(R.styleable.FunFactsLoadingView_backgroundImage);
        typedArray.recycle();

        if (backgroundImage != null) {
            setBackground(backgroundImage);
        }

        inflate(context, R.layout.view_loading, this);

        final TextView textView = findViewById(R.id.funFactTextView);
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

    public void setBackgroundImage(Drawable backgroundImage) {
        this.setBackground(backgroundImage);
    }

    public void setBackgroundImageResource(int resId) {
        this.setBackgroundResource(resId);
    }
}

