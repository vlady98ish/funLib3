package com.example.funlib3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FunFactsApi {

    @GET("random")
    Call<FunFact> getRandomFunFact();

}

