package com.example.rdjong.pokedroid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rdjong on 10-11-16.
 */

public class PutUserPwd {
    @SerializedName("password")
    @Expose
    private String password;

    public PutUserPwd() {
    }

    public PutUserPwd(String password, String email) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "";
    }
}
