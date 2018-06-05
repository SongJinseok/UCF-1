package com.kwon.ucf.notice_board;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kwon.ucf.R;

/**
 * Created by song on 2018-06-05.
 */

class ListItem extends LinearLayout {

    TextView text_Comment;
    TextView text_Day;

    public ListItem(Context context){
        super(context);
        init(context);
    }

    public void init(Context context){
        LayoutInflater myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myInflater.inflate(R.layout.list_item, this, true);

        text_Comment = (TextView) findViewById(R.id.text_comment);
        text_Day = (TextView) findViewById(R.id.text_day);

    }

    public void setFirstItem(String item) {text_Comment.setText(item);}

    public void setSecondItem(String item) {text_Day.setText(item);}
}