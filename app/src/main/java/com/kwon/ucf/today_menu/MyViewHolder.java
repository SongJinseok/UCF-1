package com.kwon.ucf.today_menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kwon.ucf.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv_menu;
    TextView tv_price;
    TextView tv_corner;
    RatingBar ratingBar;
    ImageView imageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv_menu = (TextView)itemView.findViewById(R.id.tv_menu);
        tv_price = (TextView)itemView.findViewById(R.id.tv_price);
        tv_corner = (TextView)itemView.findViewById(R.id.tv_corner);
        ratingBar = (RatingBar)itemView.findViewById(R.id.ratingBar);
        imageView = (ImageView)itemView.findViewById(R.id.imageView);
    }
}
