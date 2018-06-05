package com.kwon.ucf.notice_board;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by song on 2018-06-05.
 */

public class boardAdapter extends BaseAdapter {

    private ArrayList<String[]> data = new ArrayList(); //스트링 배열로 받잖아 ㅇㅇ????이해? 넵

    boardAdapter(ArrayList data) {
        this.data = data; //
    }

    public ArrayList getData() {
        return data;
    }

    @Override
    public int getCount(){
        return data.size();
    } // 서버의 comment 갯수 해야됨. 서버의 ㄱ

    @Override
    public Object getItem(int position){ //
        return data.get(position); //니가 원하는건 최신날짜가 제일 위로 오는거지 그럼 데이터 받아서 어레이이스트에 넣을때 그 정렬
    } // 최신 날짜일수록 위로 오게 하려면. //

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ListItem listItem = new ListItem(parent.getContext());
        listItem.setFirstItem(data.get(position)[0]); // 그럼 겟해서 가져온것도 스트링 배열이겠지 넵 이제 이해? 근데 포지션이 그건 니가 알아서 잘 정해줘야ㅈ 포지션 0에는 뭘넣게다 1에는 뭘넣겠다
        listItem.setSecondItem(data.get(position)[1]);
        return listItem;
    }
}
//