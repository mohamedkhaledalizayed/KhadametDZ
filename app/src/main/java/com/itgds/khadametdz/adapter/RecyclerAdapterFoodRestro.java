package com.itgds.khadametdz.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.interfaces.OnRestroClick;
import com.itgds.khadametdz.model.ModelRestro;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapterFoodRestro extends RecyclerView.Adapter<RecyclerAdapterFoodRestro.MyViewHolder> {
    private ArrayList<ModelRestro>arrayList;
    private OnRestroClick onRestroClick;

    public RecyclerAdapterFoodRestro(ArrayList<ModelRestro> arrayList,OnRestroClick onRestroClick) {
        this.arrayList=arrayList;
        this.onRestroClick=onRestroClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_food_restront, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ModelRestro modelRestro=arrayList.get(i);
        Picasso.get().load(modelRestro.getRestroImage()).error(R.drawable.ic_food_default).into(myViewHolder.retroImage);
        myViewHolder.restroStars.setRating(modelRestro.getRestroStars());
        myViewHolder.restroName.setText(modelRestro.getRestroName());
        myViewHolder.restroCategory.setText(modelRestro.getRestroCategory());
        myViewHolder.restroOrder.setText(modelRestro.getRestroOrder());
        myViewHolder.restroDelivery.setText(modelRestro.getRestroDelivery());
        myViewHolder.restroDeliveryTiming.setText(modelRestro.getRestroDeliveryTime());
        myViewHolder.restroTiming.setText(modelRestro.getRestroTiming());
        myViewHolder.restroRating.setText(modelRestro.getRestroRating());
        myViewHolder.restroReview.setText(modelRestro.getRestroReview());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView retroImage;
        RatingBar restroStars;
        TextView restroName,restroCategory,restroOrder,restroDelivery,restroDeliveryTiming,restroTiming,restroRating,restroReview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            retroImage=itemView.findViewById(R.id.id_food_restro_image);
            restroStars=itemView.findViewById(R.id.id_food_restro_stars);
            restroName=itemView.findViewById(R.id.id_food_restro_name);
            restroCategory=itemView.findViewById(R.id.id_food_restro_category);
            restroOrder=itemView.findViewById(R.id.id_food_restro_order);
            restroDelivery=itemView.findViewById(R.id.id_food_restro_delivery);
            restroDeliveryTiming=itemView.findViewById(R.id.id_food_restro_delivery_timing);
            restroTiming=itemView.findViewById(R.id.id_food_restro_timing);
            restroRating=itemView.findViewById(R.id.id_food_restro_rating);
            restroReview=itemView.findViewById(R.id.id_food_restro_review);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
           onRestroClick.onClickOfResto(arrayList.get(position).getRestroId());
        }
    }
}
