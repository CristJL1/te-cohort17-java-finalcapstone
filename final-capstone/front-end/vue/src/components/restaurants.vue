<template>
    <div class="restaurants">
        <h2> Restaurant Tinder </h2>
        <div class="restaurantCard">
           <h3>{{this.$store.state.restaurants.data[currentRestaurant].name}} </h3>
           <!--<p>{{this.$store.state.restaurants.data[currentRestaurant].address}}</p>
           <p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[0].name}}</p>
           <p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[1].name}}</p>
           <p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[2].name}}</p>
           -->
           <button v-on:click.prevent="cycleRestaurant">I Like this Restaurant</button>
           <!--
           <img 
           v-if="" - CHECK TO SEE IF A PICTURE EXISTS
           v-bind:src="apiRestaurants.data[currentRestaurant].photo.images.large.url"/>
           -->
        </div>
    </div>    


</template>


<script>
import ApplicationServices from '../services/ApplicationServices.js'
import axios from "axios";


export default {

   name: 'restaurants',
   data() {
       return {
           currentRestaurant: 0,     
           filteredRestaurants: [], // Holds our Restaurants filtered by Preferences
          
       }
   }, 
   created() {
        const options = {
        method: 'GET',
        url: 'https://travel-advisor.p.rapidapi.com/restaurants/list-by-latlng',
        params: {
            latitude: '41.49932',
            longitude: '-81.694361',
            limit: '100',
            currency: 'USD',
            distance: '2',
            lunit: 'km',
            lang: 'en_US'
            },
        headers: {
            'x-rapidapi-key': 'e6c2c2c125msh616ece324f702d5p18a5b7jsn6f5f714dfcb2',
            'x-rapidapi-host': 'travel-advisor.p.rapidapi.com'
  }
};
        
axios.request(options)
.then( (response) => {
	this.$store.commit("SET_RESTAURANTS", response.data)
});


       // Instantiate the Documenu API with Key
       /* const Documenu = require('documenu')
        Documenu.configure('e2992117f97c5ba5fea8074bed9851e6')

        ApplicationServices
            .getProfileById(this.$store.state.user.id)
            .then(res => {
              this.$store.commit("SET_PROFILE_DATA", res.data);
              ApplicationServices
              .getPreferenceById(this.$store.state.user.id)
              .then(res => {
                this.$store.commit("SET_PREFERENCE_DATA", res.data); 
                // Create zipCode Variable to hold our current user's zipCode
                let zipCode = this.$store.state.profile.zipCode
                // Call API to get Restaurants by zipCode    
                Documenu.Restaurants.getByZipCode(zipCode)
                .then(response => {
                this.apiRestaurants = response.data
                }); 
              })
            }) */
   },
   computed: { 
       
    }, 
   methods: { 
       cycleRestaurant() {
            this.currentRestaurant++
       }
   }
} // end of export default
</script>


<style scoped>

.restaurantCard {
    background-color: white;
}

</style>