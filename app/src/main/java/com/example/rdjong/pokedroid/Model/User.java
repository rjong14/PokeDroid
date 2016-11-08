package com.example.rdjong.pokedroid.Model;

/**
 * Created by rdjong on 25-10-16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class User {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("pokemon")
    @Expose
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();
    @SerializedName("local")
    @Expose
    private Local local;

    public User() {
    }

    public User(String id, String role, Integer v, List<Pokemon> pokemon, Local local) {
        this.id = id;
        this.role = role;
        this.v = v;
        this.pokemon = pokemon;
        this.local = local;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "";
    }

}
