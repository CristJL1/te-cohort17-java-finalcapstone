package com.techelevator.application.model;

import org.springframework.security.core.userdetails.User;

public class RestaurantDTO {
    private Restaurant restaurantToAdd;
    private Profile currentProfile;
    private boolean isLiked;

    public Restaurant getRestaurantToAdd() {
        return restaurantToAdd;
    }

    public void setRestaurantToAdd(Restaurant restaurantToAdd) {
        this.restaurantToAdd = restaurantToAdd;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "restaurantToAdd=" + restaurantToAdd +
                ", currentProfile=" + currentProfile +
                ", isLiked=" + isLiked +
                '}';
    }
}