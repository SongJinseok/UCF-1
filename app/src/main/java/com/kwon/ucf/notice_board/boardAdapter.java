package com.kwon.ucf.notice_board;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by song on 2018-06-05.
 */

public class boardAdapter extends BaseAdapter {
    String[] arr = {"text1","text2","text3","text4","text5","text6","text7","text8","text9","text10","text11","text12"};
    String[] arr2 = {"2018/06/02","2018/06/03","2018/06/04","2018/06/05","2018/06/06","2018/06/07","2018/06/08","2018/06/09","2018/06/09","2018/06/09","2018/06/09","2018/06/09"};

    @Override
    public int getCount(){
        return arr.length;
    }

    @Override
    public Object getItem(int position){
        return arr[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ListItem listItem = new ListItem(parent.getContext());
        listItem.setFirstItem(arr[position]);
        listItem.setSecondItem(arr2[position]);
        return listItem;
    }
}