package com.techelevator.application.dao;

import com.techelevator.application.model.Restaurant;
import org.springframework.security.core.userdetails.User;

public interface RestaurantDAO {
    Restaurant addRestaurant(Restaurant restaurantToAdd);

    Restaurant addRestaurantToUserList(Restaurant restaurantToAdd, User currentUser, boolean isLiked);

    Restaurant viewRestaurant(Long id);

    Restaurant updateRestaurant(Restaurant restaurantToUpdate);

    void deleteRestaurant(Long id);
}
