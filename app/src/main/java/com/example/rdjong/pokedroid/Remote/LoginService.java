package com.example.rdjong.pokedroid.Remote;

import com.example.rdjong.pokedroid.Model.Data;
import com.example.rdjong.pokedroid.Model.Me;
import com.example.rdjong.pokedroid.Model.Token;
import com.example.rdjong.pokedroid.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rdjong on 26-10-16.
 */
public interface LoginService {
    @POST("token")
    Call<Token> createMe(@Body Me me);
}

