package com.itgds.khadametdz.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itgds.khadametdz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentFoodRestroMenu extends Fragment {
    private Activity activity;
    private Context context;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<ModelFoodMenu>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_foo_restro_menu, container, false);
        activity = getActivity();
        context = getContext();
        // get the listview
        expListView = view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(context, listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(context, listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(context, listDataHeader.get(groupPosition)
                        + " : "
                        + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getMenuFoodName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }



    private class ModelFoodMenu {
        private String menuFoodName;
        private String menuFoodDescription;
        private int menuFoodPrice;
        private String menuFoodImage;

        public ModelFoodMenu(String menuFoodName, String menuFoodDescription, int menuFoodPrice, String menuFoodImage) {
            this.menuFoodName = menuFoodName;
            this.menuFoodDescription = menuFoodDescription;
            this.menuFoodPrice = menuFoodPrice;
            this.menuFoodImage = menuFoodImage;
        }

        public String getMenuFoodName() {
            return menuFoodName;
        }

        public void setMenuFoodName(String menuFoodName) {
            this.menuFoodName = menuFoodName;
        }

        public String getMenuFoodDescription() {
            return menuFoodDescription;
        }

        public void setMenuFoodDescription(String menuFoodDescription) {
            this.menuFoodDescription = menuFoodDescription;
        }

        public int getMenuFoodPrice() {
            return menuFoodPrice;
        }

        public void setMenuFoodPrice(int menuFoodPrice) {
            this.menuFoodPrice = menuFoodPrice;
        }

        public String getMenuFoodImage() {
            return menuFoodImage;
        }

        public void setMenuFoodImage(String menuFoodImage) {
            this.menuFoodImage = menuFoodImage;
        }
    }


    public class ExpandableListAdapter extends BaseExpandableListAdapter {
        private Context _context;
        private List<String> _listDataHeader;
        private HashMap<String, List<ModelFoodMenu>> _listDataChild;

        public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<ModelFoodMenu>> listChildData) {
            this._context = context;
            this._listDataHeader = listDataHeader;
            this._listDataChild = listChildData;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon).getMenuFoodName();
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            final String childText = (String) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.test_item, null);
            }

            TextView txtListChild = convertView.findViewById(R.id.id_menu_food_name);

            txtListChild.setText(childText);
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.test_head, null);
            }

            TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
            lblListHeader.setText(headerTitle);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Coffee");
        listDataHeader.add("Pizza");
        listDataHeader.add("Non Veg");

        // Adding child data
        List<ModelFoodMenu> coffeeList = new ArrayList<>();
        coffeeList.add(new ModelFoodMenu("Latte","Italian Coffee",50,""));
        coffeeList.add(new ModelFoodMenu("Cappuccino","French Coffee",80,""));
        coffeeList.add(new ModelFoodMenu("Espresso","US Coffee",100,""));
        coffeeList.add(new ModelFoodMenu("Flat White","US Coffee",30,""));

        List<ModelFoodMenu> pizzaList = new ArrayList<>();
        pizzaList.add(new ModelFoodMenu("Cheese Burst","Italian",250,""));
        pizzaList.add(new ModelFoodMenu("Non Veg Chicken","Italian",300,""));
        pizzaList.add(new ModelFoodMenu("Olive Pizza","Italian",350,""));
        pizzaList.add(new ModelFoodMenu("Thin Crust Pizza","Italian",200,""));
        pizzaList.add(new ModelFoodMenu("Mushroom Pizza","Italian",400,""));
        pizzaList.add(new ModelFoodMenu("Chill Pizza","Italian",300,""));

        List<ModelFoodMenu> rollList = new ArrayList<>();
        rollList.add(new ModelFoodMenu("Veg Roll","Italian",50,""));
        rollList.add(new ModelFoodMenu("Egg Roll","Italian",80,""));
        rollList.add(new ModelFoodMenu("Non Veg Roll","Italian",100,""));


        listDataChild.put(listDataHeader.get(0), coffeeList); // Header, Child data
        listDataChild.put(listDataHeader.get(1), pizzaList);
        listDataChild.put(listDataHeader.get(2), rollList);
    }
}