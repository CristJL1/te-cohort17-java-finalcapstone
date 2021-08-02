package com.techelevator.application.dao;

import com.techelevator.application.model.Preference;
import com.techelevator.security.model.User;

public interface PreferenceDAO {

    Preference setPreferences(String cuisine1, String cuisine2, String cuisine3, String pricePoint, boolean vegan,
                              boolean vegetarian, boolean glutenFree);

    Preference viewPreferences(User currentUser);

    Preference updatePreferences(User currentUser, String cuisine1, String cuisine2, String cuisine3, String pricePoint, boolean vegan,
                                 boolean vegetarian, boolean glutenFree);

    void deletePreferences();

}
