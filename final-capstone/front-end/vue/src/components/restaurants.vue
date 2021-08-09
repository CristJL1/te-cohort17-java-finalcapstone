<template>
    <div class="restaurants text-center">
        
        <div class="restaurantCard">
           <h1 id="katiesFont"> Mangiamo </h1>

           <h3>{{this.$store.state.currentRestaurant.name}} </h3>

           <p>{{this.$store.state.currentRestaurant.description}}</p>
           <p>{{this.$store.state.currentRestaurant.address}}</p>
           <p v-if="canDisplayCuisine()" 
           >Cuisine Type: {{this.$store.state.currentRestaurant.cuisine[0].name}}
           </p>
           <p v-else 
           >Cuisine Type: not listed
           </p>
           <p v-if="canDisplayWebsite()"
           >Visit: 
               <a v-bind:href="this.$store.state.currentRestaurant.website"
               target="_blank">
               {{this.$store.state.currentRestaurant.name}}'s website
               </a>
            </p>
            <p v-else>Website Not Listed </p>
            <p>Price: {{this.$store.state.currentRestaurant.price_level}} 
                ({{this.$store.state.currentRestaurant.price}}) </p>

           <!--<p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[0].name}}</p>
           <p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[1].name}}</p>
           <p>{{this.$store.state.restaurants.data[currentRestaurant].cuisine[2].name}}</p>
           -->
           <button v-on:click.prevent="cycleRestaurant; pushToDatabase;">I Like this Restaurant</button>
           <button v-on:click.prevent="cycleRestaurant">I Dislike this Restaurant</button>
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
           //restaurantId: 0,     
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
           // let currentRestaurant = this.$store.state.restaurants.data
           let updatedId = this.$store.state.restaurantId + 1;
           this.$store.commit("UPDATE_TO_NEXT_RESTAURANT", updatedId)
           // this.restaurantId++
       },

       pushToDatabase() {
           // Updating a liked restaurant to the data store
           let currentRestaurant = this.$store.state.restaurants.data[this.$store.state.restaurantId]
           this.$store.commit("LIKE_RESTAURANT", currentRestaurant)
           // Still need to call the service to push to database
       },
       canDisplayCuisine() {
           let cuisine = this.$store.state.currentRestaurant.cuisine
           if(cuisine != null) {
               if(cuisine.size > 0) {
                   return true;
               }   
           }
           return false;
       },

       canDisplayWebsite() {
           let website = this.$store.state.currentRestaurant.website
           if(website != null && website != '') {
               return true;
           }
       }
   }
} // end of export default
</script>


<style scoped>

button {
    margin: 2%;
}

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

#katiesFont {
  font-family: 'Pacifico', cursive;
}




</style>