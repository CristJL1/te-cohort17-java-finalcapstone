<template>
    <div> 
        <img  v-bind:src="this.$store.state.currentRestaurant.photo.images.large.url" alt="Photo of the Restaurant" class="restaurantImg">

        <div class="restaurantDetails">
                <h3>Restaurant Name:  <span>{{this.$store.state.currentRestaurant.name}} </span> </h3>
                <h5>Address: <span>{{this.$store.state.currentRestaurant.address}}</span></h5>
                <h4>Cuisine Type & Dietary Restrictions: </h4>
                <div class="typesGrid" >
                    <div class="types">
                        <h5 class="atype" v-for="cuisineObject in this.$store.state.currentRestaurant.cuisine"
                            v-bind:key="cuisineObject.id"><img src="../../public/Food_icon.png" id="foodIcon"> {{cuisineObject.name}} </h5>
                    </div>
                </div>    
                <p>Phone: {{this.$store.state.currentRestaurant.phone}}</p>
                <p v-if="canDisplayWebsite()">Visit: 
                    <a v-bind:href="this.$store.state.currentRestaurant.website" target="_blank">
                        {{this.$store.state.currentRestaurant.name}}'s website
                    </a>
                </p>
                <p v-else>Website Not Listed </p>
                <p>Price: {{this.$store.state.currentRestaurant.price_level}} 
                    ({{this.$store.state.currentRestaurant.price}}) 
                </p>
            </div>
        <!-- Display restaurant name -->
        <!-- Display restaurant address -->
        <!-- Display restaurant name -->
    </div>
</template>

<script>
import axios from "axios";
import ApplicationServices from '../services/ApplicationServices';

export default {
    name: 'liked-restaurant',
    data() {
        return {

        }
    },
    created() {
        let preferences = this.$store.state.preference
        let dietaryRestrictions = this.$store.state.preference.dietaryRestrictions
        let usersCuisines = preferences.cuisineStyle1 + ", " + preferences.cuisineStyle2 + ", " + preferences.cuisineStyle3
        const options = 
            ApplicationServices
            .getLikedRestaurants(this.$store.state.user.id)
    },
    methods : {
        canDisplayCuisine() {
           let cuisine = this.$store.state.currentRestaurant.cuisine
           if(cuisine != null) {
               if(cuisine.size >= 0) {
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
}

</script>

<style scoped> 

</style>