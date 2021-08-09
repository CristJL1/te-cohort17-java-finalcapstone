package com.techelevator.application.jdbcdao;

import com.techelevator.application.dao.PreferenceDAO;
import com.techelevator.application.model.Preference;
import com.techelevator.security.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JDBCPreferenceDAO implements PreferenceDAO {
    private JdbcTemplate theDatabase;
    public JDBCPreferenceDAO(DataSource theDataSource) {
        this.theDatabase = new JdbcTemplate(theDataSource);
    }

    public Preference setPreferences(Preference userPreference) {
        String newPreferenceStmt = "insert into preferences (user_id, cuisine_style_1, cuisine_style_2, cuisine_style_3, " +
                                   "price_point, vegan, vegetarian, gluten_free) values (?, ?, ?, ?, ?, ?, ?, ?)";
        theDatabase.update(newPreferenceStmt, userPreference.getUserId(), userPreference.getCuisineStyle1(), userPreference.getCuisineStyle2(),
                           userPreference.getCuisineStyle3(), userPreference.getPricePoint(), userPreference.getVegan(),
                            userPreference.getVegetarian(), userPreference.getGlutenFree());

        return userPreference;
    };

    public Preference viewPreferences(long currentUserId) {
        String sqlSearch = "select * from preferences where user_id = ?";
        Preference userPreference = new Preference();

        SqlRowSet result = theDatabase.queryForRowSet(sqlSearch, currentUserId);

        if (result.next()) {
            userPreference = mapToPreference(result);
        }
        return userPreference;
    };

    public Preference updatePreferences(Preference updatedPreference) {
        String sqlUpdateStmt = "update preferences set cuisine_style_1 = ?, cuisine_style_2 = ?, cuisine_style_3 = ?, "
                               + "price_point = ?, vegan = ?, vegetarian = ?, gluten_free = ? where user_id = ?";
        theDatabase.update(sqlUpdateStmt, updatedPreference.getCuisineStyle1(),
                           updatedPreference.getCuisineStyle2(),updatedPreference.getCuisineStyle3(),
                           updatedPreference.getPricePoint(), updatedPreference.getVegan(),
                           updatedPreference.getVegetarian(), updatedPreference.getGlutenFree(),
                           updatedPreference.getUserId());

        return updatedPreference;
    };

    public void deletePreferences(long currentUserId) {
        String sqlDeleteStmt = "delete from preferences where user_id = ? ";
        theDatabase.update(sqlDeleteStmt, currentUserId);
    };


    // helper methods

    private Preference mapToPreference(SqlRowSet row) {
        Preference newPreference = new Preference();
        newPreference.setUserId(row.getLong("user_id"));
        newPreference.setCuisineStyle1(row.getString("cuisine_style_1"));
        newPreference.setCuisineStyle2(row.getString("cuisine_style_2"));
        newPreference.setCuisineStyle3(row.getString("cuisine_style_3"));
        newPreference.setPricePoint(row.getString("price_point"));

        if (row.getString("vegan") != null) {
            newPreference.setVegan(row.getString("vegan"));
        }

        if (row.getString("vegetarian") != null) {
            newPreference.setVegetarian(row.getString("vegetarian"));
        }

        if (row.getString("gluten_free") != null) {
            newPreference.setGlutenFree(row.getString("gluten_free"));
        }

        return newPreference;
    }

}
