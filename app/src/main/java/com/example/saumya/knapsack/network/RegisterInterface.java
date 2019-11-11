package com.example.saumya.knapsack.network;

import com.example.saumya.knapsack.pojo.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterInterface {
    @POST("LoginController/Login")
    Call<Register> createUser(@Body Register register);
}
