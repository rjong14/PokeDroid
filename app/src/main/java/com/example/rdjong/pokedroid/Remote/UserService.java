package com.example.rdjong.pokedroid.Remote;

import com.example.rdjong.pokedroid.Model.PutUser;
import com.example.rdjong.pokedroid.Model.PutUserEmail;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.Model.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by rdjong on 2-11-16.
 */
public interface UserService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);

    @PUT("users/{id}")
    Call<User> putUser(@Path("id") String id, @Body PutUser putuser);

    //@Headers("Content-Type: application/x-www-form-urlencoded")
    @PUT("users/{id}")
    Call<User> putUserEmail(@Path("id") String id, @Body PutUserEmail putuseremail);

//    @POST("users")
//    Call<User> postUser(@Body User user);
}
