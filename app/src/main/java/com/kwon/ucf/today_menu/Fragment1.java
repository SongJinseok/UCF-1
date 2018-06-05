package com.kwon.ucf.today_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kwon.ucf.R;
import com.kwon.ucf.application.ApplicationController;
import com.kwon.ucf.detail.DetailActivity;
import com.kwon.ucf.network.NetworkService;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//오늘메뉴

public class Fragment1 extends Fragment {

    ArrayList<MenuData> mData;
    LinearLayoutManager mLayoutManager;
    MenuAdapter menuAdapter;
    RecyclerView recyclerView;

    NetworkService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView .setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        menuAdapter = new MenuAdapter(mData, clickEvent);
        recyclerView.setAdapter(menuAdapter);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate,endDate)
                .datesNumberOnScreen(7)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do
            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView, int dx, int dy) {
                super.onCalendarScroll(calendarView, dx, dy);
                //do
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset(){
        mData = new ArrayList<>();

        service = ApplicationController.getInstance().getNetworkService();
        service.getMenu().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if(response.code()==200){
                    JsonArray arr = response.body();
                    for(int i = 0; i<arr.size(); i++){
                        JsonObject item = arr.get(i).getAsJsonObject();
                        float total = item.get("totalRating").getAsFloat();
                        int count = item.get("count").getAsInt();
                        float res = count / total;
                        mData.add(new MenuData(item.get("foodname").getAsString(), item.get("price").getAsString(), item.get("corner").getAsString(), res, R.drawable.ic_launcher_foreground));
                    }
                    menuAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildAdapterPosition(v);
            String str = mData.get(itemPosition).getName();
//            Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("foodname",str);
            Fragment1.this.startActivity(intent);
        }
    };
}
