package com.techelevator.application.jdbcdao;

import com.techelevator.application.dao.RestaurantDAO;
import com.techelevator.application.model.Cuisine;
import com.techelevator.application.model.Profile;
import com.techelevator.application.model.Restaurant;
import com.techelevator.application.model.RestaurantDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCRestaurantDAO implements RestaurantDAO {
    private JdbcTemplate theDatabase;

    public JDBCRestaurantDAO(DataSource theDataSource) {
        this.theDatabase = new JdbcTemplate(theDataSource);
    }


    @Override
    public Restaurant addRestaurant(Restaurant restaurantToAdd) {
        // add logic to cycle through the List of cuisines, for any within the length of the array, assign it a value,
        //      maybe make List of variables to hold cuisine_style_num, default value of null (field nullable in DB)
        //      for loop that assigns, for length of cuisineList

        restaurantToAdd.setRestaurantId(getNextRestaurantId());

        if (viewRestaurant(restaurantToAdd.getRestaurantId()) != null) {
            String sqlInsert = "insert into restaurants (restaurant_id, location_id, restaurant_name, " +
                    "restaurant_phone, restaurant_website, price_range, cuisine_type_1, cuisine_type_2, " +
                    "cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7, " +
                    "address, lat, lon) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            String cuisine1 = null;
            String cuisine2 = null;
            String cuisine3 = null;
            String cuisine4 = null;
            String cuisine5 = null;
            String cuisine6 = null;
            String cuisine7 = null;

            List<String> cuisines = new ArrayList();

            cuisines.add(cuisine1);
            cuisines.add(cuisine2);
            cuisines.add(cuisine3);
            cuisines.add(cuisine4);
            cuisines.add(cuisine5);
            cuisines.add(cuisine6);
            cuisines.add(cuisine7);

            for (int i = 0; i < restaurantToAdd.getCuisineTypes().size(); i++) {
                cuisines.set(i, restaurantToAdd.getCuisineTypes().get(i).getName());
            }



            theDatabase.update(sqlInsert, restaurantToAdd.getRestaurantId(), restaurantToAdd.getLocationId(),
                    restaurantToAdd.getRestaurantName(), restaurantToAdd.getRestaurantPhone(),
                    restaurantToAdd.getRestaurantWebsite(), restaurantToAdd.getPriceRange(),
                    cuisine1, cuisine2, cuisine3, cuisine4, cuisine5, cuisine6, cuisine7,
                    restaurantToAdd.getAddress(), restaurantToAdd.getLat(),
                    restaurantToAdd.getLon());

        }
        return restaurantToAdd;
    }

    @Override
    public Restaurant viewRestaurant(Long id) {
        Restaurant aRestaurant = new Restaurant();
        String sqlQuery = "select * from restaurants where restaurant_id = ? ";
        SqlRowSet result = theDatabase.queryForRowSet(sqlQuery, id);

        if (result.next()) {
            aRestaurant = mapToRestaurant(result);
        }
        return aRestaurant;
    }

    //edit to match new database set up, use same logic that works for add restaurant 
    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToUpdate) {
        String updateSql = "update restaurants set restaurant_name= ?, restaurant_phone = ?, restaurant_website = ?, " +
                "price_range = ?, cuisine_type_1 = ?, cuisine_type_2 = ?, cuisine_type_3 = ?, cuisine_type_4 = ?, " +
                "cuisine_type_5 = ?, cuisine_type_6 = ?, cuisine_type_7 = ?, address = ?, lat = ?, lon = ? " +
                "where restaurant_id = ?";
        String cuisine1 = null;
        String cuisine2 = null;
        String cuisine3 = null;
        String cuisine4 = null;
        String cuisine5 = null;
        String cuisine6 = null;
        String cuisine7 = null;

        List<String> cuisines = new ArrayList();

        cuisines.add(cuisine1);
        cuisines.add(cuisine2);
        cuisines.add(cuisine3);
        cuisines.add(cuisine4);
        cuisines.add(cuisine5);
        cuisines.add(cuisine6);
        cuisines.add(cuisine7);

        for (int i = 0; i < restaurantToUpdate.getCuisineTypes().size(); i++) {
            cuisines.set(i, restaurantToUpdate.getCuisineTypes().get(i).getName());
        }

        theDatabase.update(updateSql, restaurantToUpdate.getRestaurantName(),
                restaurantToUpdate.getRestaurantPhone(), restaurantToUpdate.getRestaurantWebsite(),
                restaurantToUpdate.getPriceRange(), cuisine1, cuisine2, cuisine3, cuisine4, cuisine5, cuisine6,
                cuisine7, restaurantToUpdate.getAddress(),
                restaurantToUpdate.getLat(), restaurantToUpdate.getLon(), restaurantToUpdate.getRestaurantId());

        return restaurantToUpdate;
    }

    @Override
    public void deleteRestaurant(Long id) {
        String deleteSql = "delete from restaurants where restaurant_id = ?";

        theDatabase.update(deleteSql, id);
    }

    // are we planning to send each one at a time or a List all at once when they navigate somewhere else?
    @Override
    public RestaurantDTO addRestaurantToUserList(RestaurantDTO restaurantToAddToUserList) {

        String sqlInsert = "insert into restaurants_profile (restaurant_id, user_id, is_liked) values " +
                "(?, ?, ?)";

        theDatabase.update(sqlInsert, restaurantToAddToUserList.getRestaurantToAdd().getRestaurantId(),
                restaurantToAddToUserList.getCurrentProfile().getUserId(), restaurantToAddToUserList.isLiked());

        return restaurantToAddToUserList;
    }

    @Override
    public List<Restaurant> viewFavoritedRestaurants(RestaurantDTO restaurantToView) {
        List<Restaurant> favoritedList = new ArrayList();
        String sqlSearch = "select * from restaurants r inner join restaurants_profile rp on " +
                           "r.restaurant_id = rp.restaurant_id where is_liked = true and user_id = ?";
        SqlRowSet result = theDatabase.queryForRowSet(sqlSearch, restaurantToView.getCurrentProfile().getUserId());

        if (result.next()) {
            Restaurant likedRestaurant = mapToRestaurant(result);
            favoritedList.add(likedRestaurant);
        }
        return favoritedList;
    }

    @Override
    public RestaurantDTO updateIfRestaurantIsLiked(RestaurantDTO restaurantToUpdate) {
        String sqlUpdateStmt = "update restaurants_profile set is_liked = ? where restaurant_id = ? and user_id = ?";

        theDatabase.update(sqlUpdateStmt, restaurantToUpdate.isLiked(),
                           restaurantToUpdate.getRestaurantToAdd().getRestaurantId(),
                           restaurantToUpdate.getCurrentProfile().getUserId());

        return restaurantToUpdate;
    }

    @Override
    public void deleteRestaurantFromUsersList(RestaurantDTO restaurantToDelete) {
        String sqlDeleteStmt = "delete from restaurants_profile where restaurant_id = ? and user_id = ?";

        theDatabase.update(sqlDeleteStmt, restaurantToDelete.getRestaurantToAdd().getRestaurantId(),
                           restaurantToDelete.getCurrentProfile().getUserId());
    }


// helper methods

    private Restaurant mapToRestaurant (SqlRowSet row) {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setRestaurantId(row.getLong("restaurant_id"));
        newRestaurant.setLocationId(row.getLong("location_id"));
        newRestaurant.setRestaurantName(row.getString("restaurant_name"));
        newRestaurant.setRestaurantPhone(row.getString("restaurant_phone"));
        newRestaurant.setRestaurantWebsite(row.getString("restaurant_website"));
        newRestaurant.setPriceRange(row.getString("price_range"));

        List<Cuisine> cuisinesList = new ArrayList();
//        cuisinesList.add(row.getString("cuisine_type_1"));
//        newRestaurant.setCuisineType2(row.getString("cuisine_type_2"));
//        newRestaurant.setCuisineType3(row.getString("cuisine_type_3"));
//        newRestaurant.setCuisineType4(row.getString("cuisine_type_4"));
//        newRestaurant.setCuisineType5(row.getString("cuisine_type_5"));
//        newRestaurant.setCuisineType6(row.getString("cuisine_type_6"));
//        newRestaurant.setCuisineType7(row.getString("cuisine_type_7"));
        newRestaurant.setAddress(row.getString("address"));
        newRestaurant.setLat(row.getDouble("lat"));
        newRestaurant.setLon(row.getDouble("lon"));

        return newRestaurant;
    }

    private long getNextRestaurantId() {
        SqlRowSet nextId = theDatabase.queryForRowSet("select nextval('restaurants_restaurant_id_seq')");

        if (nextId.next()) {
            return  nextId.getLong(1);
        } else {
            throw new RuntimeException("There was no next Restaurant Id");
        }
    }


}
