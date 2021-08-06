package com.techelevator.application.model;

import org.springframework.security.core.userdetails.User;

public class RestaurantDTO {
    private Restaurant restaurantToAdd;
    private User       currentUser;
    private boolean    isLiked;

    public Restaurant getRestaurantToAdd() {
        return restaurantToAdd;
    }

    public void setRestaurantToAdd(Restaurant restaurantToAdd) {
        this.restaurantToAdd = restaurantToAdd;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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
                ", currentUser=" + currentUser +
                ", isLiked=" + isLiked +
                '}';
    }
}
