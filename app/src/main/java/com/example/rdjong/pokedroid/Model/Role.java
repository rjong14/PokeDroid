package com.example.rdjong.pokedroid.Model;

/**
 * Created by rdjong on 25-10-16.
 */
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;


    public Role() {
    }

    public Role(String id, String name, Integer v) {
        this.id = id;
        this.name = name;
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }


    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "";
    }

}
