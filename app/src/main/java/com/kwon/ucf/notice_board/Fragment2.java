package com.kwon.ucf.notice_board;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kwon.ucf.R;

//게시판

public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment2, container, false);


        //리스트뷰 생성
        ListView listView = (ListView) v.findViewById(R.id.listView);
        boardAdapter adapter = new boardAdapter();
        listView.setAdapter(adapter);
        //


        return v;




    }



}
