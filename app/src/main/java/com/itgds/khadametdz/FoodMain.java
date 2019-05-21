package com.itgds.khadametdz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.itgds.khadametdz.fragment.FragmentFoodRestroMenu;
import com.itgds.khadametdz.fragment.FragmentFoodRestroInfo;
import com.itgds.khadametdz.fragment.FragmentFoodRestroReview;

public class FoodMain extends AppCompatActivity implements View.OnClickListener {
    private CardView mainRestroButtonMenu, mainRestroButtonInfo, mainRestroButtonReview;
    private View mainIndicatorMenu, mainIndicatorInfo, mainIndicatorReview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_food);
        mainIndicatorInfo = findViewById(R.id.id_food_restro_indicator_info);
        mainIndicatorMenu = findViewById(R.id.id_food_restro_indicator_menu);
        mainIndicatorReview = findViewById(R.id.id_food_restro_indicator_review);
        mainRestroButtonInfo = findViewById(R.id.id_food_restro_button_info);
        mainRestroButtonMenu = findViewById(R.id.id_food_restro_button_menu);
        mainRestroButtonReview = findViewById(R.id.id_food_restro_button_review);
        mainRestroButtonInfo.setOnClickListener(this);
        mainRestroButtonMenu.setOnClickListener(this);
        mainRestroButtonReview.setOnClickListener(this);
        loadFragment(new FragmentFoodRestroMenu());
        mainIndicatorMenu.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_selected));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_food_restro_button_info:
                mainIndicatorInfo.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_selected));
                mainIndicatorMenu.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));
                mainIndicatorReview.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));

                loadFragment(new FragmentFoodRestroInfo());
                break;
            case R.id.id_food_restro_button_menu:
                mainIndicatorMenu.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_selected));
                mainIndicatorInfo.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));
                mainIndicatorReview.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));

                loadFragment(new FragmentFoodRestroMenu());
                break;
            case R.id.id_food_restro_button_review:
                mainIndicatorReview.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_selected));
                mainIndicatorMenu.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));
                mainIndicatorInfo.setBackgroundColor(getResources().getColor(R.color.color_indicator_color_unselected));
                loadFragment(new FragmentFoodRestroReview());
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}