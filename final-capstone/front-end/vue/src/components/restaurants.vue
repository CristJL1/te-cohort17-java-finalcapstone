<template>
    <div class="restaurants text-center">
        
        <div class="restaurantCard">
           <h1> Mangiamo </h1>
           <h3>{{this.$store.state.restaurants.data[restaurantId].name}} </h3>
           <p>{{this.$store.state.restaurants.data[restaurantId].description}}</p>
           <p>{{this.$store.state.restaurants.data[restaurantId].address}}</p>
           <p>Cuisine Type: {{this.$store.state.restaurants.data[restaurantId].cuisine[0].name}}</p>
           <p>Go to Website: 
               <a v-bind:href="this.$store.state.restaurants.data[restaurantId].website"
               target="_blank">
               {{this.$store.state.restaurants.data[restaurantId].website}}
               </a>
            </p>
            <p>Price: {{this.$store.state.restaurants.data[restaurantId].price_level}} ({{this.$store.state.restaurants.data[restaurantId].price}}) </p>

           <!--<p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[0].name}}</p>
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
           restaurantId: 0,     
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
   },
   computed: { 
       
    }, 
   methods: { 
       cycleRestaurant() {
           let currentRestaurant = this.$store.state.restaurants.data
           this.restaurantId++
       }
   }
} // end of export default
</script>


<style scoped>

.restaurants {
   
        display: grid;
        grid-template-columns: 1fr 3fr 1fr;
        height: 100%;
        grid-template-areas:
            ". restaurantCard ."
    }

.restaurantCard {
    grid-area: restaurantCard;
    background-color: rgba(190, 186, 186, 0.911);
    border-color: rgba(92, 92, 92, 0.842);
    border-style: outset;
    border-width: medium;
    border-radius: 10px;
    padding: 5%;
    margin: 10%;
}

.text-center {
    text-align: center;
    font-family: Monospace, Cursive, Sans-serif;
    }

h1{
    text-align: center;
    color: rgb(204, 10, 10);
}




</style>