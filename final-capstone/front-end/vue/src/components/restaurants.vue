<template>
    <div class="restaurants text-center">
        
        <div class="restaurantCard">
            <h1 id="katiesFont"> Mangiamo </h1>

            <div class="imageGrid">
            <img  v-bind:src="this.$store.state.currentRestaurant.photo.images.large.url" alt="Photo of the Restaurant" class="restaurantImg">
            </div>

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

            <button type="button" class="description">See Description</button>
                <p class="description" id="description">Description: {{this.$store.state.currentRestaurant.description}}</p>
        
            

           
            <div class="buttonFooter">
                <button v-on:click.prevent="pushToDatabase(); cycleRestaurant()">I Like this Restaurant</button>
                <button v-on:click.prevent="cycleRestaurant">I Dislike this Restaurant</button>
            </div>
        </div>
    </div>    


</template>


<script>
import applicationServices from "../services/ApplicationServices"
import axios from "axios";


export default {
   name: 'restaurants',
   data() {
       return {
           //restaurantId: 0,     
           filteredRestaurants: [], // Holds our Restaurants filtered by Preferences
           trueFalse: false
       }
   }, 
   created() {
        let preferences = this.$store.state.preference
        let dietaryRestrictions = this.$store.state.preference.dietaryRestrictions
        let usersCuisines = preferences.cuisineStyle1 + ", " + preferences.cuisineStyle2 + ", " + preferences.cuisineStyle3
        const options = {
        method: 'GET',
        url: 'https://travel-advisor.p.rapidapi.com/restaurants/list-by-latlng',
        params: {
            latitude: '41.49932',
            longitude: '-81.694361',
            limit: '100',
            currency: 'USD',
            combined_food: usersCuisines,
            distance: '20',
            dietary_restrictions: dietaryRestrictions,
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
           let currentRestaurant = this.$store.state.restaurants[this.$store.state.restaurantId]
           this.$store.commit("LIKE_RESTAURANT", currentRestaurant)
           // Still need to call the service to push to database
           // Pass to the Database with our liked Restaurant
           this.$store.commit("SET_RESTAURANTDTO", currentRestaurant)
           applicationServices
           .addLikedRestaurant(this.$store.state.restaurantDTO)
           .then(response => {

           }) 

       },
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
       },

   }

} // end of export default
</script>


<style scoped>

button {
    margin: 2%;
    border-radius: 12px;
    background-color: white;
    color: black;
    transition-duration: 0.6s;
    cursor: pointer
    
}

button:hover {
  background-color: #e7e7e7;
  color: black;
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
    margin-top: 3%;

    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 75px .3fr .1fr .005fr;
    height: 100%;
    grid-template-areas:
    "h1 h1"
    "restaurantDetails imageGrid"
    " description description"
    " btn btn"
}

.description {
    grid-area: description;
    
}

#description {
    padding: 0 18px;
    display: none;
    overflow: hidden;
    background-color: #f1f1f1;
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

.collapsible {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  border: none;
  outline: none;
  font-size: 15px;
}

</style>