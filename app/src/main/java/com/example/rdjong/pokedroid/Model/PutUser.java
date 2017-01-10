package com.example.rdjong.pokedroid.Model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rdjong on 10-11-16.
 */

public class PutUser {
    @SerializedName("pwd")
    @Expose
    private String pwd;
    @Expose
    private String email;

    public PutUser() {
    }

    public PutUser(String email, String pwd) {
        Log.d("putuser constructor", email);
        this.pwd = pwd;
        this.email = email;
        Log.d("putuser constructor", this.email);
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String pwd) {
        this.pwd = pwd;
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
