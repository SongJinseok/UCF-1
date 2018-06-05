package com.kwon.ucf.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kwon.ucf.R;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<ViewHolder>{
    ArrayList<DetailData> detailData;

    public DetailAdapter(ArrayList<DetailData> detailData) {
        this.detailData = detailData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_my_score.setText(detailData.get(position).myScore);
        holder.tv_date.setText(detailData.get(position).date);
        holder.tv_my_review.setText(detailData.get(position).myReview);
        holder.text.setText(detailData.get(position).comment);
        holder.imageView2.setImageResource(detailData.get(position).img);
        holder.ratingBar.setRating(detailData.get(position).personalRating);
    }

    @Override
    public int getItemCount() {
        return detailData == null ? 0 : detailData.size();
    }
}
