package com.example.rdjong.pokedroid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rdjong on 10-11-16.
 */

public class PutUserEmail {
    @SerializedName("email")
    @Expose
    private String email;

    public PutUserEmail() {
    }

    public PutUserEmail(String email) {

        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "";
    }
}
