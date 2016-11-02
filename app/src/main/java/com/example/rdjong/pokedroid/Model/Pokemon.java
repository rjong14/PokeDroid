package com.example.rdjong.pokedroid.Model;

/**
 * Created by rdjong on 25-10-16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pokemon {

    @SerializedName("pokeid")
    @Expose
    private String pokeid;
    @SerializedName("caught_at")
    @Expose
    private String caughtAt;
    @SerializedName("_id")
    @Expose
    private String id;

    public Pokemon() {
    }

    public Pokemon(String pokeid, String caughtAt, String id) {
        this.pokeid = pokeid;
        this.caughtAt = caughtAt;
        this.id = id;
    }

    public String getPokeid() {
        return pokeid;
    }

    public void setPokeid(String pokeid) {
        this.pokeid = pokeid;
    }

    public String getCaughtAt() {
        return caughtAt;
    }

    public void setCaughtAt(String caughtAt) {
        this.caughtAt = caughtAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "{" +
                "pokeid: '" + pokeid + '\'' +
                ", caughtAt: '" + caughtAt + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
}
