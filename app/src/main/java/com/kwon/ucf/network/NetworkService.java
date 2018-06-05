package com.kwon.ucf.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkService {
    @GET("/menu")
    Call<JsonArray> getMenu();

    @GET("/review/{foodname}")
    Call<JsonArray> getDetail(@Path("foodname") String name);
}
