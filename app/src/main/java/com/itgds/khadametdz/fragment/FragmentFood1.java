package com.itgds.khadametdz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itgds.khadametdz.FoodMain;
import com.itgds.khadametdz.R;
import com.itgds.khadametdz.adapter.RecyclerAdapterFood;
import com.itgds.khadametdz.adapter.RecyclerAdapterFoodRestro;
import com.itgds.khadametdz.interfaces.OnRestroClick;
import com.itgds.khadametdz.model.FoodListModel;
import com.itgds.khadametdz.model.ModelRestro;

import java.util.ArrayList;

public class FragmentFood1 extends Fragment implements OnRestroClick {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_1, container, false);

        RecyclerView recyclerViewPopular = view.findViewById(R.id.id_food_news_recycler_view);
        RecyclerAdapterFood mAdapterPopular = new RecyclerAdapterFood(getFoodList());
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPopular.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPopular.setAdapter(mAdapterPopular);


        RecyclerView rvRestro = view.findViewById(R.id.id_food_rstro_recycler_view);
        RecyclerAdapterFoodRestro recyclerAdapterFoodRestro = new RecyclerAdapterFoodRestro(getRestroData(), this);
        rvRestro.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvRestro.setItemAnimator(new DefaultItemAnimator());
        rvRestro.setAdapter(recyclerAdapterFoodRestro);
        return view;
    }


    private ArrayList<FoodListModel> getFoodList() {
        ArrayList<FoodListModel> arrayList = new ArrayList<>();
        arrayList.add(new FoodListModel("Kabab"));
        arrayList.add(new FoodListModel("Pizza"));
        arrayList.add(new FoodListModel("Sweet"));
        arrayList.add(new FoodListModel("Toffee"));
        arrayList.add(new FoodListModel("Coffee"));
        arrayList.add(new FoodListModel("Biscuit"));
        arrayList.add(new FoodListModel("Kabab"));
        arrayList.add(new FoodListModel("Kabab"));
        arrayList.add(new FoodListModel("Kabab"));
        arrayList.add(new FoodListModel("Kabab"));
        return arrayList;
    }

    private ArrayList<ModelRestro> getRestroData() {
        ArrayList<ModelRestro> arrayList = new ArrayList<>();
        arrayList.add(new ModelRestro("1", "image", "Mc Donalds", "Fast Food", "Yes", "Yes", "30 - 40 min", "9AM - 8PM", "4", 4, "10 review"));
        arrayList.add(new ModelRestro("2", "image", "KFC", "Chicken", "No", "Yes", "30 min", "10AM - 7PM", "3", 3, "23 review"));
        arrayList.add(new ModelRestro("3", "image", "Dominos", "Fast Food", "Yes", "Yes", "10 min", "7AM - 9PM", "5", 5, "1 review"));
        arrayList.add(new ModelRestro("4", "image", "Pizza Hut", "Fast Food", "No", "Yes", "20 - 50 min", "5AM - 6PM", "1", 1, "55 review"));


        return arrayList;
    }

    @Override
    public void onClickOfResto(String restroId) {
        Intent intent = new Intent(getActivity(), FoodMain.class);
        startActivity(intent);
    }
}
