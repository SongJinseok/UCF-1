package com.kwon.ucf.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kwon.ucf.R;
import com.kwon.ucf.application.ApplicationController;
import com.kwon.ucf.network.NetworkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DetailData> mData = new ArrayList<>();
    LinearLayoutManager mLayoutManager;
    DetailAdapter adapter;
    TextView title;
    String name;

    NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        name = intent.getStringExtra("foodname");

//        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        title = (TextView)findViewById(R.id.tv_foodname);
        title.setText(name);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new DetailAdapter(mData);
        recyclerView.setAdapter(adapter);

        service = ApplicationController.getInstance().getNetworkService();

        service.getDetail(name).enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if(response.code() == 200) {
                    JsonArray array = response.body();
                    for(int i = 0; i<array.size(); i++){
                        JsonObject item = array.get(i).getAsJsonObject();
                        String image = "";
                        try{
                            image = item.get("img").getAsString();
                        } catch (UnsupportedOperationException e){
                            image = "";
                        } finally {
                            mData.add(new DetailData(3, item.get("comment").getAsString(), item.get("date").getAsString(), "나의 평점", "나의 리뷰", R.drawable.ic_launcher_background));
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
