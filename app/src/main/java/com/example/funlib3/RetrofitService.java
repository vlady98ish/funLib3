package com.example.funlib3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://fun-facts-api.onrender.com/facts/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <T> T buildService(Class<T> service) {
        return retrofit.create(service);
    }
}