package com.techelevator.application.dao;

import com.techelevator.application.model.Preference;
import com.techelevator.security.model.User;

public interface PreferenceDAO {

    Preference setPreferences(Preference userPreferences);

    Preference viewPreferences(long currentUserId);

    Preference updatePreferences(Preference updatedPreference);

    void deletePreferences(long currentUserId);

}
