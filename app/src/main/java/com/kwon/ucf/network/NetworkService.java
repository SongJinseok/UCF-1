package com.kwon.ucf.network;

import com.google.gson.JsonArray;

import junit.framework.Test;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetworkService {
    @GET("/menu")
    Call<JsonArray> getMenu();

    @GET("/board")
    Call<JsonArray> getComment(); // 코멘트 받기

    @FormUrlEncoded
    @POST("/board")
    Call<JsonArray> sendComment(@Field("comment") String comment); //저거 필드 안에 comment 만 서버랑 맞추면 됨 comment는 내가 임의로 쓴거

}

