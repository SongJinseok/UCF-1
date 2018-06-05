package com.kwon.ucf.application;

import android.app.Application;

import com.kwon.ucf.network.NetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationController extends Application {
    private static ApplicationController instance;

    private static String baseUrl = "http://13.124.254.99:1327";

    private NetworkService networkService;

    public static ApplicationController getInstance(){return instance;}

    public NetworkService getNetworkService() {
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
        buildService();
    }

    public void buildService(){
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }
}
