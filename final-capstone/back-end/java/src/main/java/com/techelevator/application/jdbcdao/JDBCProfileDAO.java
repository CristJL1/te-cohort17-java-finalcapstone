package com.techelevator.application.jdbcdao;

import com.techelevator.application.dao.ProfileDAO;
import com.techelevator.application.model.Profile;
import com.techelevator.security.model.User;

import java.sql.Date;

public class JDBCProfileDAO implements ProfileDAO {

    public Profile setProfile(String firstName, String lastName, Date dateOfBirth, String email, int zipCode) {
        //placeholder profile until database set
        Profile newProfile = new Profile();
        return newProfile;
    }

    public Profile viewProfile(User currentUser) {
        //placeholder profile until database set
        Profile newProfile = new Profile();
        return newProfile;
    }

    public Profile updateProfile() { // determine parameters
        //placeholder profile until database set
        Profile newProfile = new Profile();
        return newProfile;
    }

    public void deleteProfile(User currentUser) {

    }
}
