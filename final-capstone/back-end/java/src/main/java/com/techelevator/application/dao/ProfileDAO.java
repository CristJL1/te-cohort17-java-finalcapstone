package com.techelevator.application.dao;

import com.techelevator.application.model.Profile;
import com.techelevator.security.model.User;

import java.sql.Date;

public interface ProfileDAO {

   Profile setProfile(String firstName, String lastName, Date dateOfBirth, String email, int zipCode);

   Profile viewProfile(User currentUser);

   Profile updateProfile();  // determine parameters

   void deleteProfile(User currentUser);
}
