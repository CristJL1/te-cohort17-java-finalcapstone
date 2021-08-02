package com.techelevator.application.dao;

import com.techelevator.application.model.Profile;
import com.techelevator.security.model.User;

import java.sql.Date;

public interface ProfileDAO {

   Profile setProfile(Profile userProfile);

   Profile viewProfile(User currentUser);

   Profile updateProfile(Profile updatedProfile);  // determine parameters

   void deleteProfile(User currentUser);
}
