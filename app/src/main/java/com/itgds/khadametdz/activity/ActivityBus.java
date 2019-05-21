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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.fragment.FragmentBus3;
import com.itgds.khadametdz.fragment.FragmentBus1;
import com.itgds.khadametdz.fragment.FragmentBus2;
import com.itgds.khadametdz.fragment.FragmentBus4;

public class ActivityBus extends AppCompatActivity {
    private ActionBar toolbar;
    private String pageNameString = "FragInfoPage";
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bus);
        toolbar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_bus_reservation));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new FragmentBus1());
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_bus_reservation:
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_bus_reservation));
                    loadFragment(new FragmentBus1());
                    pageNameString = "FragReservationPage";
                    return true;
                case R.id.bottom_nav_bus_ticket:
                    loadFragment(new FragmentBus2());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_bus_ticket));
                    pageNameString = "FragTicketPage";
                    return true;
                case R.id.bottom_nav_bus_info:
                    loadFragment(new FragmentBus3());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_bus_info));
                    pageNameString = "FragInfoPage";
                    return true;
                case R.id.bottom_nav_bus_help:
                    loadFragment(new FragmentBus4());
                    toolbar.setTitle(getResources().getString(R.string.ic_bottom_nav_bus_help));
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
                if (pageNameString.equals("FragReservationPage")) {
                    finish();
                } else {
                    pageNameString = "FragReservationPage";
                    navigation.setSelectedItemId(R.id.bottom_nav_bus_reservation);
                }
                return true;
            case R.id.ic_main_restro:
                Intent intentRestro=new Intent(ActivityBus.this,SplashScreenRestro.class);
                startActivity(intentRestro);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (pageNameString.equals("FragReservationPage")) {
            super.onBackPressed();
        } else {
            navigation.setSelectedItemId(R.id.bottom_nav_bus_reservation);
            pageNameString = "FragReservationPage";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }

}