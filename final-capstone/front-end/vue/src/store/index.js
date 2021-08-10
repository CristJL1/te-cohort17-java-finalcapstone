import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));


if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    restaurants: [],
    currentRestaurant: {},
    restaurantId: 0,
    likedRestaurant: {},
    profile:{},     // Hold the current users profile data
    preference:{},   // Hold current users preference data
    restaurantDTO: {
      restaurantToAdd: {
       restaurantId: Number,
       locationId: Number,
       restaurantName: '',
       description: '',
       imageLink: '',
       restaurantPhone: '',
       restaurantWebsite: '',
       priceRange: '',
       cuisineTypes:[],
       address: '',
       lat: '',
       lon: '',
     },
     currentProfile: {
         userId: '',   // - this.$store.state.profile.userId
         firstName: '', // - this.$store.state.profile.firstName
         lastName: '', // - this.$store.state.profile.lastName
         dateOfBirth: '',  // - this.$store.state.profile.dateOfBirth
         email: '',  //	- this.$store.state.profile.email
         zipCode: '',   // - this.$store.state.profile.zipcode
     },
     isLiked : Boolean
 }
  },

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_RESTAURANTS(state, data) { 
      let filterData = []
            for(let i=0; i<data.data.length; i++) {
              let restaurant = data.data[i]
                if("name" in restaurant && 
                  "address" in restaurant && 
                  "cuisine" in restaurant && 
                  "website" in restaurant && 
                  "price" in restaurant &&
                  "price_level" in restaurant &&
                  "phone" in restaurant &&
                  "photo" in restaurant) {
                    if("images" in restaurant.photo) {
                    filterData.push(data.data[i])
                    }
                }
              }
      state.restaurants = filterData;
      state.currentRestaurant = filterData[0];
    },
    
    SET_PREFERENCE_DATA(state, preference) { 
      state.preference = preference;
    },
    SET_PROFILE_DATA(state, profile) {
      state.profile = profile;
      state.restaurantDTO.profile = profile;
    },

    UPDATE_TO_NEXT_RESTAURANT(state, nextRestaurantId) {
      state.currentRestaurant = this.state.restaurants[nextRestaurantId]
      state.restaurantId = nextRestaurantId
    },
    
    LIKE_RESTAURANT(state, currentRestaurant) {
      state.likedRestaurant = currentRestaurant
      state.restaurantDTO.isLiked = true
    },

    SET_RESTAURANTDTO(state, restaurant) {
      state.restaurantDTO.restaurantToAdd.restaurantName = restaurant.name
      state.restaurantDTO.restaurantToAdd.locationId = restaurant.location_id
      state.restaurantDTO.restaurantToAdd.description = restaurant.description
      state.restaurantDTO.restaurantToAdd.imageLink = restaurant.photo.images.medium.url
      state.restaurantDTO.restaurantToAdd.restaurantPhone = restaurant.phone
      state.restaurantDTO.restaurantToAdd.restaurantWebsite = restaurant.website
      state.restaurantDTO.restaurantToAdd.priceRange = restaurant.price_level

      restaurant.cuisine.forEach(cuisine => {
        state.restaurantDTO.cuisineTypes.push(cuisine)
      })

      state.restaurantDTO.restaurantToAdd.address = restaurant.address
      state.restaurantDTO.restaurantToAdd.lat = restaurant.latitude
      state.restaurantDTO.restaurantToAdd.lon = restaurant.longitude
    }

  }
})
