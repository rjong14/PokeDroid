package com.example.rdjong.pokedroid.Remote;

import com.example.rdjong.pokedroid.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by rdjong on 2-11-16.
 */
public interface UserService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);

    @POST("users")
    Call<User> putUser(@Body User user);

    @POST("users")
    Call<User> postUser(@Body User user);
}
