<template>
<div class="restaurants text-center">
<div class="restaurantCard">
    <h1 id="katiesFont"> Favorite Restaurants </h1>
    <div class="imageGrid"> 
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

            <buttons id="buttonsComponent"/>

            <restaurant-details id="restaurantDetailsComponent"/> 
    </div>
</div>
</div>
</template>

<script>
import axios from 'axios';
import ApplicationServices from '../services/ApplicationServices';
import buttons from '../components/buttons.vue'
import RestaurantDetails from '../components/restaurantDetails.vue';

export default {
    name: 'liked-restaurant',
    components: {
        buttons,
        RestaurantDetails
    },
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
.restaurants {
        display: grid;
        grid-template-columns: 1fr 3fr 1fr;
        height: 100%;
        grid-template-areas:
            ". restaurantCard restaurantCard"
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
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 75px .3fr .005fr .005fr;
    height: 100%;
    grid-template-areas:
    "h1 h1"
    "restaurantDetails imageGrid"
    "buttons buttons"
    "restaurant-details restaurant-details"    
}

#buttonsComponent {
    grid-area: buttons;
}
#restaurantDetailsComponent {
    grid-area: restaurant-details;
}
.restaurantDetails {
    grid-area: restaurantDetails;
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
    "restaurant-details restaurant-details"    
}
#buttonsComponent {
    grid-area: buttons;
}

#restaurantDetailsComponent {
    grid-area: restaurant-details;
}


.descriptionGrid {
    grid-area: descriptionGrid;
    
}

.restaurantDetails {
    grid-area: restaurantDetails;
    padding: 3%;
    display: inline-block;
    max-width: auto;  
}

.buttonFooter {
    grid-area: btn;
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