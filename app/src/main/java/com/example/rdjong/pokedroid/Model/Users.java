package com.example.rdjong.pokedroid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rdjong on 7-11-16.
 */

public class Users {

    @SerializedName("users")
    @Expose
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
