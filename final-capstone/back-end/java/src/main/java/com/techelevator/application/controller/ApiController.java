/********************************************************************************************************************** 
* This will should contain Application API Controllers and related objects
**********************************************************************************************************************/

package com.techelevator.application.controller;
//import com.techelevator.security.dao;
//import com.sun.tools.javac.util.DefinedBy;
import com.techelevator.application.dao.PreferenceDAO;
import com.techelevator.application.dao.ProfileDAO;
import com.techelevator.application.dao.RestaurantDAO;
import com.techelevator.application.model.Preference;
import com.techelevator.application.model.Profile;
import com.techelevator.application.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.techelevator.security.dao.UserDAO;
import java.sql.Timestamp;
import com.techelevator.security.model.User;
@CrossOrigin
@RestController
public class ApiController {
    PreferenceDAO preferenceData;
    ProfileDAO profileData;
    UserDAO userData;
    RestaurantDAO restaurantData;
// Figure out API call for adding a restaurant to restaurant_profile table
/**********************************************************************************************************************
* Put your Application API Controllers here
**********************************************************************************************************************/
public ApiController(PreferenceDAO thePreference, ProfileDAO theProfile, UserDAO theUserData,
                     RestaurantDAO theRestaurantData) {
    preferenceData = thePreference;
    profileData = theProfile;
    userData = theUserData;
    restaurantData = theRestaurantData;
}

@ResponseStatus(HttpStatus.CREATED)
@RequestMapping(path = "/user", method = RequestMethod.POST)
public Profile createProfile(@RequestBody Profile userProfile) {
    logRequest("POST -- PROFILE");
    profileData.setProfile(userProfile);

    return userProfile;
}

@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
public Profile viewProfile(@PathVariable long id) {
    logRequest("GET -- PROFILE");
    return profileData.viewProfile(id);
}

@RequestMapping(path="/user", method = RequestMethod.PUT)
public Profile updateProfile(@RequestBody Profile updatedProfile) {
    logRequest("PUT -- PROFILE");

    return profileData.updateProfile(updatedProfile);
}

@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
public void deleteProfile(@PathVariable long id) {
    logRequest("DELETE -- PROFILE");
    profileData.deleteProfile(id);
}

@ResponseStatus(HttpStatus.CREATED)
@RequestMapping(path = "/user/preference", method = RequestMethod.POST)
public Preference createPreference(@RequestBody Preference userPreference) {
    logRequest("POST -- PREFERENCE");
    preferenceData.setPreferences(userPreference);

    return userPreference;
}

@RequestMapping(path="/user/{id}/preference", method = RequestMethod.GET)
public Preference viewPreferences(@PathVariable long id) {
    logRequest("GET -- PREFERENCE");
    return preferenceData.viewPreferences(id);
}

@RequestMapping(path = "/user/preference", method = RequestMethod.PUT)
public Preference updatedPreferences(@RequestBody Preference updatedPreferences) {
    logRequest("PUT -- PREFERENCES");
    return preferenceData.updatePreferences(updatedPreferences);
}

@RequestMapping(path = "/user/{id}/preference", method = RequestMethod.DELETE)
public void deletePreferences(@PathVariable long id) {
    logRequest("DELETE -- PREFERENCES");
    preferenceData.deletePreferences(id);
}

@RequestMapping(path = "/user/getuser/{username}", method = RequestMethod.GET)
public User getUser(@PathVariable String username) {
    logRequest("GET -- USER - " + username);
    User aUser = userData.findByUsername(username);
    logRequest("userId found: " + aUser.getId());
    return aUser;
}

@ResponseStatus(HttpStatus.CREATED)
@RequestMapping(path = "/restaurants", method = RequestMethod.POST)
public Restaurant addRestaurantToRestaurants(@RequestBody Restaurant restaurantToAdd) {
    logRequest("POST -- RESTAURANT");

    restaurantData.addRestaurant(restaurantToAdd);
    return restaurantToAdd;
}

@RequestMapping(path = "/restaurants/{id}", method = RequestMethod.GET)
public Restaurant getRestaurantById(@PathVariable long id) {
    logRequest("GET -- RESTAURANT");

    return restaurantData.viewRestaurant(id);
}

@RequestMapping(path = "/restaurants", method = RequestMethod.PUT)
public Restaurant updateRestaurant(@RequestBody Restaurant restaurantToUpdate) {
    logRequest("PUT -- RESTAURANT");

    return restaurantData.updateRestaurant(restaurantToUpdate);

}

@RequestMapping(path="/restaurants/{id}", method = RequestMethod.DELETE)
public void deleteRestaurant(@PathVariable long id) {
    restaurantData.deleteRestaurant(id);
}
	
	
	
/********************************************************************************************************************* 
* Use this method if you'd like to log calls to your controllers - these message can aid in your troubleshooting
* 
* To use it: logRequest("a message you want to appear after the timestamp in the server log")
* 
* There are examples in the AuthenicationController.java program in the com.techelevator.security.controller package
**********************************************************************************************************************/	
    static void logRequest(String message) {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	 
    	System.out.println(timestamp + " - " + message);
    }
}

