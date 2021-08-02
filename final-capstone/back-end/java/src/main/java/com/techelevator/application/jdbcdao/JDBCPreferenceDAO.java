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
        String newPreferenceStmt = "insert into preferences (cuisine_style_1, cuisine_style_2, cuisine_style_3, " +
                                   "price_point, vegan, vegetarian, gluten_free values (?, ?, ?, ?, ?, ?)";
        theDatabase.update(newPreferenceStmt, userPreference.getCuisineStyle1(), userPreference.getCuisineStyle2(),
                           userPreference.getCuisineStyle3(), userPreference.getPricePoint(), userPreference.isVegan(),
                            userPreference.isVegetarian(), userPreference.isGlutenFree());

        userPreference.setPreferenceId(getNextId());

        return userPreference;
    };

    public Preference viewPreferences(User currentUser) { // edit String and queryForRowSet param when JC updates DB
        String sqlSearch = "select * from preferences where ";
        Preference userPreference = new Preference();

        SqlRowSet result = theDatabase.queryForRowSet(sqlSearch, currentUser);

        if (result.next()) {
            userPreference = mapToPreference(result);
        }
        return userPreference;
    };

    public Preference updatePreferences(Preference updatedPreference) {
        String sqlUpdateStmt = "update preferences set cuisine_style_1 = ?, cuisine_style_2 = ?, cuisine_style_3 = ?, "
                               + "price_point = ?, vegan = ?, vegetarian = ?, gluten_free = ? where preference_id = ?";
        theDatabase.update(sqlUpdateStmt, updatedPreference.getCuisineStyle1(),
                           updatedPreference.getCuisineStyle2(),updatedPreference.getCuisineStyle3(),
                           updatedPreference.getPricePoint(), updatedPreference.isVegan(),
                           updatedPreference.isVegetarian(), updatedPreference.isGlutenFree(),
                           updatedPreference.getPreferenceId());

        return updatedPreference;
    };

    public void deletePreferences(Preference preferenceToDelete) {
        String sqlDeleteStmt = "delete from preferences where preference_id = ? ";
        theDatabase.update(sqlDeleteStmt, preferenceToDelete.getPreferenceId());
    };


    // helper methods

    private Preference mapToPreference(SqlRowSet row) {
        Preference newPreference = new Preference();
        newPreference.setPreferenceId(row.getLong("preference_id"));
        newPreference.setCuisineStyle1(row.getString("cuisine_style_1"));
        newPreference.setCuisineStyle2(row.getString("cuisine_style_2"));
        newPreference.setCuisineStyle3(row.getString("cuisine_style_3"));
        newPreference.setPricePoint(row.getString("price_point"));

        if (!row.getBoolean("vegan")) {
            newPreference.setVegan(false);
        } else {
            newPreference.setVegan(row.getBoolean("vegan"));
        }

        if (!row.getBoolean("vegetarian")) {
            newPreference.setVegetarian(false);
        } else {
            newPreference.setVegetarian(row.getBoolean("vegetarian"));
        }

        if (!row.getBoolean("gluten_free")) {
            newPreference.setGlutenFree(false);
        } else {
            newPreference.setGlutenFree(row.getBoolean("gluten_free"));
        }

        return newPreference;
    }

    private long getNextId() {
        SqlRowSet nextId = theDatabase.queryForRowSet("select nextval('preferences_preference_id_seq')");

        if (nextId.next()) {
            return nextId.getLong(1);
        } else {
            throw new RuntimeException("No new preferences set");
        }
    }

}
