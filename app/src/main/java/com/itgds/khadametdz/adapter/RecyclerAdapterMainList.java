package com.itgds.khadametdz.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.activity.SplashScreenBus;
import com.itgds.khadametdz.activity.SplashScreenRestro;
import com.itgds.khadametdz.model.ModelMainCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapterMainList extends RecyclerView.Adapter<RecyclerAdapterMainList.MyViewHolder> {
    private ArrayList<ModelMainCategory> categoryArrayList;
    private Activity activity;

    public RecyclerAdapterMainList(ArrayList<ModelMainCategory> categoryArrayList, Activity activity) {
        this.categoryArrayList = categoryArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelMainCategory modelMainCategory = categoryArrayList.get(position);
        Picasso.get().load(modelMainCategory.getCategoryImage()).fit().into(holder.mainCategoryImage);
        holder.mainCategoryName.setText(modelMainCategory.getCategoryName());

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mainCategoryImage;
        TextView mainCategoryName;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mainCategoryImage = itemView.findViewById(R.id.id_main_recycler_list_image);
            mainCategoryName = itemView.findViewById(R.id.id_main_recycler_list_text);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            switch (position) {
                case 0:
                    Intent mainIntent = new Intent(activity, SplashScreenBus.class);
                    activity.startActivity(mainIntent);
                    break;
                case 3:
                    Intent mainFood = new Intent(activity, SplashScreenRestro.class);
                    activity.startActivity(mainFood);
                    break;
            }
        }
    }
}
