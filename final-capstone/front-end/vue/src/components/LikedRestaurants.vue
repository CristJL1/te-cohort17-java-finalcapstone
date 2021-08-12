<template>
<div class="restaurants text-center">
<div class="restaurantCard">
    <h1 id="katiesFont"> Favorite Restaurants </h1>
    <div class="imageGrid"> 
        <img  v-bind:src="this.$store.state.favoritedRestaurant.imageLink" alt="Photo of the Restaurant" class="restaurantImg">
    </div>
        <div class="restaurantDetails">
                <h3>Restaurant Name:  <span>{{this.$store.state.favoritedRestaurant.name}} </span> </h3>
                <h5>Address: <span>{{this.$store.state.favoritedRestaurant.address}}</span></h5>
                <h4>Cuisine Type & Dietary Restrictions: </h4>
                <div class="typesGrid" >
                    <div class="types">
                        <h5 class="atype" v-for="cuisineObject in this.$store.state.favoritedRestaurant.cuisine"
                            v-bind:key="cuisineObject.id"><img src="../../public/Food_icon.png" id="foodIcon"> {{cuisineObject.name}} </h5>
                    </div>
                </div>    
                <p>Phone: {{this.$store.state.favoritedRestaurant.phone}}</p>
                <p v-if="canDisplayWebsite()">Visit: 
                    <a v-bind:href="this.$store.state.favoritedRestaurant.website" target="_blank">
                        {{this.$store.state.favoritedRestaurant.name}}'s website
                    </a>
                </p>
                <p v-else>Website Not Listed </p>
                <p>Price: {{this.$store.state.favoritedRestaurant.price_level}} 
                    ({{this.$store.state.favoritedRestaurant.price}}) 
                </p>
            </div>
        <div id="buttonFooter">
            <button id="nextButton" v-on:click.prevent="cycleRestaurants">Next</button>
        </div>

           <restaurant-details class="dana"/>
    </div>
</div>

</template>

<script>
import axios from 'axios';
import ApplicationServices from '../services/ApplicationServices';
import RestaurantDetails from './restaurantDetails.vue';

export default {
    name: 'liked-restaurant',
    components: {
        RestaurantDetails
    },
    data() {
        return {
        }
    },
    created() {
        // let preferences = this.$store.state.preference
        // let dietaryRestrictions = this.$store.state.preference.dietaryRestrictions
        // let usersCuisines = preferences.cuisineStyle1 + ", " + preferences.cuisineStyle2 + ", " + preferences.cuisineStyle3
        this.retrieveRestaurants()
            
    },
    methods : {
        retrieveRestaurants() {
            ApplicationServices
            .getLikedRestaurants(this.$store.state.user.id)
            .then(response => {
                this.$store.commit("SET_LIKED_RESTAURANTS", response.data);
                this.$store.commit("SET_FAVORITED_RESTAURANT", response.data[0]);
            })
            
        },
        canDisplayCuisine() {
           let cuisine = this.$store.state.favoritedRestaurant.cuisine
           if(cuisine != null) {
               if(cuisine.size >= 0) {
                   return true;
               }   
           }
           return false;
       },
       canDisplayWebsite() {
           let website = this.$store.state.favoritedRestaurant.website
           if(website != null && website != '') {
               return true;
           }
       },
       cycleRestaurants() {
      
          // this.$store.commit("SET_FAVORITED_RESTAURANT", restaurant)
       }
    }
}

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
    margin-top: 3%;

    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 75px .3fr .005fr .005fr;
    height: 100%;
    grid-template-areas:
    "h1 h1"
    "restaurantDetails imageGrid"
    "nextButton nextButton"
    "dana dana"    
}

.dana {
    grid-area: dana;
}

#buttonFooter {
    grid-area: nextButton;
}

#nextButton {
    width: 200px;
}

#restaurantDetailsComponent {
    grid-area: restaurant-details;
}
.restaurantDetails {
 /*   grid-area: restaurantDetails;
    background-color: rgba(190, 186, 186, 0.911);
    border-color: rgba(92, 92, 92, 0.842);
    border-style: outset;
    border-width: medium;
    border-radius: 10px;
    margin-top: 3%;

    display: grid;
    grid-template-columns: 1fr 2fr ;
    grid-template-rows: 75px .3fr .005fr .005fr;
    height: 100%;
    grid-template-areas:
    "h1 h1"
    "restaurantDetails imageGrid"
    "buttons buttons"
    "restaurant-details restaurant-details"  */
        grid-area: restaurantDetails;
    padding: 3%;
    display: inline-block;
    max-width: auto;    
}

#restaurantDetailsComponent {
    grid-area: restaurant-details;
}



.restaurantDetails {
    grid-area: restaurantDetails;
    padding: 3%;
    display: inline-block;
    max-width: auto;  
}



h1{
    grid-area: h1;
    text-align: center;
    color: rgb(204, 10, 10);
    margin: 0%;
    border: 5px ridge red;
}
h4{
    margin-top: 2%;
    margin-bottom: 0%;
}
.imageGrid {
    grid-area: imageGrid;
    height: auto;
}
.restaurantImg {
    object-fit: cover;
    width: 350px;
    height: 350px;
    margin: 10% 0% 10% 0%;
    
}
.text-center {
    text-align: center;
    font-family: Monospace, Cursive, Sans-serif;
    }
#katiesFont {
  font-family: 'Pacifico', cursive;
}
#foodIcon {
    height: 15px;
    width: 15px;
}
.typesGrid {
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    height: auto;
    grid-template-areas:
    ". types .";
}
.types {
    grid-area: types;
    text-align: left;
}
.atype {
    margin: 2%;
}

</style>