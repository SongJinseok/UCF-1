package com.kwon.ucf.detail;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kwon.ucf.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tv_my_score;
    TextView tv_my_review;
    RatingBar ratingBar;
    TextView tv_date;
    TextInputEditText text;
    ImageView imageView2;

    public ViewHolder(View itemView) {
        super(itemView);
        tv_my_score = (TextView) itemView.findViewById(R.id.tv_my_score);
        tv_my_review = (TextView) itemView.findViewById(R.id.tv_my_review);
        tv_date = (TextView) itemView.findViewById(R.id.tv_date);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar2);
        text = (TextInputEditText) itemView.findViewById(R.id.text_input);
        imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
    }
}
