package com.itgds.khadametdz.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.databinding.ActivitiesItemLayoutBinding;

import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    public ActivitiesAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ActivitiesItemLayoutBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.activities_item_layout, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ActivitiesItemLayoutBinding binding;
        public MyViewHolder(ActivitiesItemLayoutBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }

}
