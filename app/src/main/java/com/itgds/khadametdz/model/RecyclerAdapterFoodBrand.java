package com.itgds.khadametdz.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itgds.khadametdz.R;

import java.util.ArrayList;

public class RecyclerAdapterFoodBrand extends RecyclerView.Adapter<RecyclerAdapterFoodBrand.MyViewHolder> {
    private ArrayList<FoodListModel> foodList;

    public RecyclerAdapterFoodBrand(ArrayList<FoodListModel> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_card_brand, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        FoodListModel foodListModel = foodList.get(i);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.id_main_image_brand);
        }
    }
}