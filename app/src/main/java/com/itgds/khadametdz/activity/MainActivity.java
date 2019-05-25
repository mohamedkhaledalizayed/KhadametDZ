package com.itgds.khadametdz.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.itgds.khadametdz.Constants;
import com.itgds.khadametdz.LocationUsefulFunction;
import com.itgds.khadametdz.R;
import com.itgds.khadametdz.adapter.RecyclerAdapterMainList;
import com.itgds.khadametdz.model.ModelMainCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Menu menu;
    private static final int REQUEST_LOCATION_CODE = 101;
    private Context context;
    private RecyclerView mainCategoryRecycler;
    private RecyclerAdapterMainList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mainCategoryRecycler = findViewById(R.id.id_main_recycler_list);
        mAdapter = new RecyclerAdapterMainList(getCategoryArrayList(), MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 4);
        mainCategoryRecycler.setLayoutManager(mLayoutManager);
        mainCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        mainCategoryRecycler.setAdapter(mAdapter);

    }


    private void getLocationFromGPS() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
            }
        }


        ArrayList<String> arrayList = LocationUsefulFunction.getCountry(this);
        if (arrayList.get(0).equals(Constants.ERROR_IN_GETTING_LOCATION)) {
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_main_toolbar_icon_location_off));
        } else {
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_main_toolbar_icon_location_on));
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_main, menu);
        getLocationFromGPS();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ic_main_profile) {
            onClickOfProfile();
            return true;
        } else if (id == R.id.ic_main_location) {
            dialogOnLocationClick();
            return true;
        } else if (id == R.id.ic_main_help) {
            Intent intentHelp = new Intent(MainActivity.this, ActivityHelp.class);
            startActivity(intentHelp);
            return true;
        } else if (id == R.id.ic_main_view_standard) {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 4);
            mainCategoryRecycler.setLayoutManager(mLayoutManager);
            mainCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
            mainCategoryRecycler.setAdapter(mAdapter);
            return true;

        } else if (id == R.id.ic_main_view_large) {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
            mainCategoryRecycler.setLayoutManager(mLayoutManager);
            mainCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
            mainCategoryRecycler.setAdapter(mAdapter);
            return true;
        } else if (id == R.id.ic_main_language) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this,ProfileActivity.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<ModelMainCategory> getCategoryArrayList() {
        ArrayList<ModelMainCategory> arrayList = new ArrayList<>();
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_bus_between_city), R.drawable.ic_main_bus_between_city));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_bus_within_city), R.drawable.ic_main_bus_within_city));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_hotel), R.drawable.ic_main_hotel));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_restaurant), R.drawable.ic_main_resturant));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_car_rental), R.drawable.ic_main_car_rental));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_repairing), R.drawable.ic_main_repair));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_hand_man_power), R.drawable.ic_main_hand_power));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_hospital), R.drawable.ic_main_hospital));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_transport_goods), R.drawable.ic_main_transport));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_car_repair), R.drawable.ic_main_car_repair));
        arrayList.add(new ModelMainCategory(getResources().getString(R.string.ic_main_category_list_taxi), R.drawable.ic_main_taxi));
        return arrayList;
    }

    private void onClickOfProfile() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.zz);


        dialog.findViewById(R.id.id_dialog_profile_button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void dialogOnLocationClick() {
        ArrayList<String> arrayList = LocationUsefulFunction.getCountry(this);

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_location);

        TextView textState = dialog.findViewById(R.id.id_dialog_location_state);
        TextView textCountry = dialog.findViewById(R.id.id_dialog_location_country);
        if (arrayList.get(0).equals(Constants.ERROR_IN_GETTING_LOCATION)) {
            textState.setText("Open Location");
            textCountry.setText("From Setting");
        } else {
            textState.setText(arrayList.get(1));
            textCountry.setText(arrayList.get(0));
        }
        Button dialogButton = dialog.findViewById(R.id.id_dialog_button_close);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
