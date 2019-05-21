package com.itgds.khadametdz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.fragment.FragmentFood1;
import com.itgds.khadametdz.fragment.FragmentFood2;
import com.itgds.khadametdz.fragment.FragmentFood3;
import com.itgds.khadametdz.fragment.FragmentFood4;

public class ActivityRestrount extends AppCompatActivity {
    private ActionBar toolbar;
    private String pageNameString = "FragPage";
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro);
        toolbar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_food_main));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new FragmentFood1());
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_food_main:
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_food_main));
                    loadFragment(new FragmentFood1());
                    pageNameString = "FragInfoPage";
                    return true;
                case R.id.bottom_nav_food_order:
                    loadFragment(new FragmentFood2());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_food_order));
                    pageNameString = "FragOrderPage";
                    return true;
                case R.id.bottom_nav_food_pickup:
                    loadFragment(new FragmentFood3());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_food_pick_up));
                    pageNameString = "FragPickUpPage";
                    return true;
                case R.id.bottom_nav_food_help:
                    loadFragment(new FragmentFood4());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_food_help));
                    pageNameString = "FragHelpPage";
                    return true;
            }
            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (pageNameString.equals("FragInfoPage")) {
                    finish();
                } else {
                    pageNameString = "FragInfoPage";
                    navigation.setSelectedItemId(R.id.bottom_nav_food_main);
                }
                return true;
            case R.id.ic_main_trip:
                Intent intentTrip=new Intent(ActivityRestrount.this,SplashScreenBus.class);
                startActivity(intentTrip);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (pageNameString.equals("FragInfoPage")) {
            super.onBackPressed();
        } else {
            navigation.setSelectedItemId(R.id.bottom_nav_food_main);
            pageNameString = "FragInfoPage";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }
}