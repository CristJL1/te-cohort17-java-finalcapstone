package com.techelevator.application.jdbcdao;

import com.techelevator.application.model.Preference;
import com.techelevator.security.model.User;

public class JDBCPreferenceDAO {

    public Preference setPreferences(String cuisine1, String cuisine2, String cuisine3, String pricePoint, boolean vegan,
                              boolean vegetarian, boolean glutenFree) {
        // Placeholder until SQL written
        Preference newPreference = new Preference();
        return newPreference;
    };

    public Preference viewPreferences(User currentUser) {
        // Placeholder until SQL written
        Preference newPreference = new Preference();
        return newPreference;
    };

    public Preference updatePreferences(User currentUser, String cuisine1, String cuisine2, String cuisine3, String pricePoint, boolean vegan,
                                 boolean vegetarian, boolean glutenFree) {
        // Placeholder until SQL written
        Preference newPreference = new Preference();
        return newPreference;
    };

    public void deletePreferences() {

    };

}
