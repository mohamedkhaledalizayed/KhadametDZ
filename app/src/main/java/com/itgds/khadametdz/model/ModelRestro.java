package com.itgds.khadametdz.model;

public class ModelRestro {
    private String restroId;
    private String restroImage;
    private String restroName;
    private String restroCategory;
    private String restroOrder;
    private String restroDelivery;
    private String restroDeliveryTime;
    private String restroTiming;
    private String restroRating;
    private int restroStars;
    private String restroReview;

    public ModelRestro(String restroId, String restroImage, String restroName, String restroCategory, String restroOrder, String restroDelivery, String restroDeliveryTime, String restroTiming, String restroRating, int restroStars, String restroReview) {
        this.restroId = restroId;
        this.restroImage = restroImage;
        this.restroName = restroName;
        this.restroCategory = restroCategory;
        this.restroOrder = restroOrder;
        this.restroDelivery = restroDelivery;
        this.restroDeliveryTime = restroDeliveryTime;
        this.restroTiming = restroTiming;
        this.restroRating = restroRating;
        this.restroStars = restroStars;
        this.restroReview = restroReview;
    }


    public String getRestroId() {
        return restroId;
    }

    public void setRestroId(String restroId) {
        this.restroId = restroId;
    }

    public String getRestroImage() {
        return restroImage;
    }

    public void setRestroImage(String restroImage) {
        this.restroImage = restroImage;
    }

    public String getRestroName() {
        return restroName;
    }

    public void setRestroName(String restroName) {
        this.restroName = restroName;
    }

    public String getRestroCategory() {
        return restroCategory;
    }

    public void setRestroCategory(String restroCategory) {
        this.restroCategory = restroCategory;
    }

    public String getRestroOrder() {
        return restroOrder;
    }

    public void setRestroOrder(String restroOrder) {
        this.restroOrder = restroOrder;
    }

    public String getRestroDelivery() {
        return restroDelivery;
    }

    public void setRestroDelivery(String restroDelivery) {
        this.restroDelivery = restroDelivery;
    }

    public String getRestroDeliveryTime() {
        return restroDeliveryTime;
    }

    public void setRestroDeliveryTime(String restroDeliveryTime) {
        this.restroDeliveryTime = restroDeliveryTime;
    }

    public String getRestroTiming() {
        return restroTiming;
    }

    public void setRestroTiming(String restroTiming) {
        this.restroTiming = restroTiming;
    }

    public String getRestroRating() {
        return restroRating;
    }

    public void setRestroRating(String restroRating) {
        this.restroRating = restroRating;
    }

    public int getRestroStars() {
        return restroStars;
    }

    public void setRestroStars(int restroStars) {
        this.restroStars = restroStars;
    }

    public String getRestroReview() {
        return restroReview;
    }

    public void setRestroReview(String restroReview) {
        this.restroReview = restroReview;
    }
}
