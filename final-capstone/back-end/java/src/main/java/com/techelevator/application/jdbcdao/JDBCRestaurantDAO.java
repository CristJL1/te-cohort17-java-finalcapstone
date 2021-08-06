package com.techelevator.application.jdbcdao;

import com.techelevator.application.dao.RestaurantDAO;
import com.techelevator.application.model.Profile;
import com.techelevator.application.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JDBCRestaurantDAO implements RestaurantDAO {
    private JdbcTemplate theDatabase;
    public JDBCRestaurantDAO(DataSource theDataSource) {
        this.theDatabase = new JdbcTemplate(theDataSource);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurantToAdd) {
        // add logic to check if restaurant is already in restaurant list - check name and formatted
        String sqlInsert = "insert into restaurants (restaurant_id, restaurant_name, " +
                "restaurant_phone, restaurant_website, hours, price_range, price_range_num, " +
                "cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, " +
                "cuisine_type_6, cuisine_type_7, city, state, postal_code, street, formatted, lat, lon) " +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        theDatabase.update(sqlInsert, restaurantToAdd.getRestaurantId(), restaurantToAdd.getRestaurantName(),
                restaurantToAdd.getRestaurantPhone(), restaurantToAdd.getRestaurantWebsite(), restaurantToAdd.getHours(),
                restaurantToAdd.getPriceRange(), restaurantToAdd.getPriceRangeNum(), restaurantToAdd.getCuisineType1(),
                restaurantToAdd.getCuisineType2(), restaurantToAdd.getCuisineType3(), restaurantToAdd.getCuisineType4(),
                restaurantToAdd.getCuisineType5(), restaurantToAdd.getCuisineType6(), restaurantToAdd.getCuisineType7(),
                restaurantToAdd.getCity(), restaurantToAdd.getState(), restaurantToAdd.getPostal_code(),
                restaurantToAdd.getStreet(), restaurantToAdd.getFormatted(), restaurantToAdd.getLat(),
                restaurantToAdd.getLon());

        return restaurantToAdd;
    }

    @Override // need to check in DBV
    public Restaurant addRestaurantToUserList(Restaurant restaurantToAdd, User currentUser, boolean isLiked) {
        //Add user_id from user, restaurant_id from restaurant and whether user liked it or not
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

    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToUpdate) {
        String updateSql = "update restaurants set restaurant_name= ?, restaurant_phone =?, restaurant_website =?, " +
                "hours = ?, price_range = ?, price_range_num = ?, cuisine_type_1 = ?, cuisine_type_2 = ?, " +
                "cuisine_type_3 = ?, cuisine_type_4 = ?, cuisine_type_5 = ?, cuisine_type_6 = ?, cuisine_type_7 = ?, " +
                "city = ?, state = ?, postal_code = ?, street = ?, formatted = ?, lat = ?, lon = ? where restaurant_id = ?";

        theDatabase.update(updateSql, restaurantToUpdate.getRestaurantName(),
                restaurantToUpdate.getRestaurantPhone(), restaurantToUpdate.getRestaurantWebsite(),
                restaurantToUpdate.getHours(), restaurantToUpdate.getPriceRange(), restaurantToUpdate.getPriceRangeNum(),
                restaurantToUpdate.getCuisineType1(), restaurantToUpdate.getCuisineType2(),
                restaurantToUpdate.getCuisineType3(), restaurantToUpdate.getCuisineType4(),
                restaurantToUpdate.getCuisineType5(), restaurantToUpdate.getCuisineType6(),
                restaurantToUpdate.getCuisineType7(), restaurantToUpdate.getCity(), restaurantToUpdate.getState(),
                restaurantToUpdate.getPostal_code(), restaurantToUpdate.getStreet(), restaurantToUpdate.getFormatted(),
                restaurantToUpdate.getLat(), restaurantToUpdate.getLon(), restaurantToUpdate.getRestaurantId());

        return restaurantToUpdate;
    }

    @Override
    public void deleteRestaurant(Long id) {
        String deleteSql = "delete from restaurants where restaurant_id = ?";

        theDatabase.update(deleteSql, id);
    }

// helper methods

    private Restaurant mapToRestaurant (SqlRowSet row) {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setRestaurantId(row.getLong("restaurant_id"));
        newRestaurant.setRestaurantName(row.getString("restaurant_name"));
        newRestaurant.setRestaurantPhone(row.getString("restaurant_phone"));
        newRestaurant.setRestaurantWebsite(row.getString("restaurant_website"));
        newRestaurant.setHours(row.getString("hours"));
        newRestaurant.setPriceRange(row.getString("price_range"));
        newRestaurant.setPriceRangeNum(row.getInt("price_range_num"));
        newRestaurant.setCuisineType1(row.getString("cuisine_type_1"));
        newRestaurant.setCuisineType2(row.getString("cuisine_type_2"));
        newRestaurant.setCuisineType3(row.getString("cuisine_type_3"));
        newRestaurant.setCuisineType4(row.getString("cuisine_type_4"));
        newRestaurant.setCuisineType5(row.getString("cuisine_type_5"));
        newRestaurant.setCuisineType6(row.getString("cuisine_type_6"));
        newRestaurant.setCuisineType7(row.getString("cuisine_type_7"));
        newRestaurant.setCity(row.getString("city"));
        newRestaurant.setState(row.getString("state"));
        newRestaurant.setPostal_code(row.getInt("postal_code"));
        newRestaurant.setStreet(row.getString("street"));
        newRestaurant.setFormatted(row.getString("formatted"));
        newRestaurant.setLat(row.getDouble("lat"));
        newRestaurant.setLon(row.getDouble("lon"));

        return newRestaurant;
    }
}
