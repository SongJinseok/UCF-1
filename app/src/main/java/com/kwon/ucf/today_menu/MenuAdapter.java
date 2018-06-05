package com.kwon.ucf.today_menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kwon.ucf.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<MenuData> menuData;

    public MenuAdapter(ArrayList<MenuData> menuData) {
        this.menuData = menuData;
    }

    public ArrayList<MenuData> getMenuData() {
        return menuData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_menu.setText(menuData.get(position).name);
        holder.tv_price.setText(menuData.get(position).price);
        holder.tv_corner.setText(menuData.get(position).corner);
        holder.imageView.setImageResource(menuData.get(position).hot);
        holder.ratingBar.setRating(menuData.get(position).score);
    }

    @Override
    public int getItemCount() {
        return menuData == null ? 0 : menuData.size();
    }
}
