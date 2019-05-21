package com.itgds.khadametdz.fragment;

import android.app.Activity;
import android.content.Context;
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
import android.widget.RatingBar;
import android.widget.TextView;

import com.itgds.khadametdz.R;

import java.util.ArrayList;

public class FragmentFoodRestroReview extends Fragment {
    private Activity activity;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_review, container, false);
        activity = getActivity();
        context = getContext();
        RecyclerView mainRecyclerView = view.findViewById(R.id.id_food_review_recycler_view);


        FoodAdapter mAdapter = new FoodAdapter(getAllMenuData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        mainRecyclerView.setLayoutManager(mLayoutManager);
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mainRecyclerView.setAdapter(mAdapter);
        return view;
    }


    public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
        private ArrayList<ReviewFoodItem> arrayList;

        public FoodAdapter(ArrayList<ReviewFoodItem> allMenuData) {
            this.arrayList = allMenuData;
        }


        @NonNull
        @Override
        public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_food_review, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder myViewHolder, int position) {
            ReviewFoodItem reviewFoodItem = arrayList.get(position);
            myViewHolder.reviewFoodDate.setText(reviewFoodItem.getReviewFoodDate());
            myViewHolder.reviewFoodDescription.setText(reviewFoodItem.getReviewContent());
            myViewHolder.reviewFoodName.setText(reviewFoodItem.getReviewFoodName());
            myViewHolder.ratingRatingBar.setRating(Float.parseFloat(reviewFoodItem.reviewRatingStar));

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView reviewFoodName, reviewFoodDescription, reviewFoodDate;
            RatingBar ratingRatingBar;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                reviewFoodName = itemView.findViewById(R.id.id_food_review_name);
                reviewFoodDescription = itemView.findViewById(R.id.id_food_review_content);
                reviewFoodDate = itemView.findViewById(R.id.id_food_review_date);
                ratingRatingBar = itemView.findViewById(R.id.id_food_review_rating);
            }
        }
    }


    private ArrayList<ReviewFoodItem> getAllMenuData() {
        ArrayList<ReviewFoodItem> arrayList = new ArrayList<>();
        arrayList.add(new ReviewFoodItem("Praveen", "20 Dec 2018", "2", "No. As soon as you renew new Plan, it will be activated immediately and you will loose balance validity"));
        arrayList.add(new ReviewFoodItem("Honey", "10 Jan 2018", "5", "No. As soon as you renew new Plan."));
        arrayList.add(new ReviewFoodItem("Bill", "05 Feb 2015", "2", "The new recharge will work after expiry of your current plan. I did one time. For example my current plan expiry is on 14th October 2018, but I recharged on October 9th, I got this SMS confirmation from Airtel"));
        arrayList.add(new ReviewFoodItem("Shawn", "24 Mar 2018", "1", "I did one time. For example my current plan expiry is on 14th October 2018, but I recharged on October 9th, I got this SMS confirmation from Airtel"));
        arrayList.add(new ReviewFoodItem("Michael", "18 April 2017", "4", "I did one time. For example my current plan expiry is on 14th October 2018, but I recharged on October 9th, I got this SMS confirmation from Airtel"));
        arrayList.add(new ReviewFoodItem("Eminem", "21 May 2017", "3", "For example my current plan expiry is on 14th October 2018, but I recharged on October 9th, I got this SMS confirmation from Airtel"));
        arrayList.add(new ReviewFoodItem("Dr. Dre", "26 Aug 2018", "1", "But I recharged on October 9th, I got this SMS confirmation from Airtel"));
        arrayList.add(new ReviewFoodItem("Asking Alexendria", "8 Aug 2017", "3", "For example my current plan expiry is on 14th October 2018, but I recharged on October 9th, I got this SMS confirmation from Airtel"));
        return arrayList;
    }

    private class ReviewFoodItem {
        private String reviewFoodName;
        private String reviewFoodDate;
        private String reviewRatingStar;
        private String reviewContent;

        public ReviewFoodItem(String reviewFoodName, String reviewFoodDate, String reviewRatingStar, String reviewContent) {
            this.reviewFoodName = reviewFoodName;
            this.reviewFoodDate = reviewFoodDate;
            this.reviewRatingStar = reviewRatingStar;
            this.reviewContent = reviewContent;
        }

        public String getReviewFoodName() {
            return reviewFoodName;
        }

        public void setReviewFoodName(String reviewFoodName) {
            this.reviewFoodName = reviewFoodName;
        }

        public String getReviewFoodDate() {
            return reviewFoodDate;
        }

        public void setReviewFoodDate(String reviewFoodDate) {
            this.reviewFoodDate = reviewFoodDate;
        }

        public String getReviewRatingStar() {
            return reviewRatingStar;
        }

        public void setReviewRatingStar(String reviewRatingStar) {
            this.reviewRatingStar = reviewRatingStar;
        }

        public String getReviewContent() {
            return reviewContent;
        }

        public void setReviewContent(String reviewContent) {
            this.reviewContent = reviewContent;
        }
    }
}


