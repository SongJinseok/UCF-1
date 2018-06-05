package com.kwon.ucf.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/menu")
    Call<JsonArray> getMenu();
}
