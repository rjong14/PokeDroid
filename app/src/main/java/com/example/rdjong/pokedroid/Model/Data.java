package com.example.rdjong.pokedroid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rdjong on 28-10-16.
 */
public class Data {

    @SerializedName("Token")
    @Expose
    private Token token;

    public Data(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
