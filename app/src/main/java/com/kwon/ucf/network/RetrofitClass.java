package com.kwon.ucf.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by song on 2018-06-06.
 */

public class RetrofitClass { //걍 귀찮으니 이거써

    private NetworkService mRetro;

    private String baseUrl = "http://13.124.254.99:1327";

    public RetrofitClass() {
        mRetro = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build().create(NetworkService.class);
    }

    public NetworkService getRetroService() {
        return mRetro;
    }

}
