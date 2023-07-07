package com.example.funlib3;

import com.google.gson.annotations.SerializedName;

public class FunFact {

    @SerializedName("_id")
    private final String id;

    @SerializedName("category")
    private final String category;

    @SerializedName("fact")
    private final String fact;

    public FunFact(String id, String category, String fact) {
        this.id = id;
        this.category = category;
        this.fact = fact;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getFact() {
        return fact;
    }
}
