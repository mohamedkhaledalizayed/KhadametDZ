package com.itgds.khadametdz.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itgds.khadametdz.model.FoodListModel;
import com.itgds.khadametdz.R;

import java.util.ArrayList;

public class RecyclerAdapterFood extends RecyclerView.Adapter<RecyclerAdapterFood.MyViewHolder> {
    private ArrayList<FoodListModel> foodList;

    public RecyclerAdapterFood(ArrayList<FoodListModel> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_card, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        FoodListModel foodListModel = foodList.get(i);
        myViewHolder.mainText.setText(foodListModel.getMainName());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage;
        TextView mainText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.id_card_image_food);
            mainText = itemView.findViewById(R.id.id_card_text_food);
        }
    }
}