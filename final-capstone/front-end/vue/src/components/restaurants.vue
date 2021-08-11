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

            <div class="descriptionGrid">
            <button type="button" id="description" class="collapsible" v-on:click.prevent="collapse">See Description</button>
                <div class="content">
                    <p v-if="canDisplayDescription()">Description: {{this.$store.state.currentRestaurant.description}}</p>
                    <p v-else>No Description Listed</p>
                </div>
            </div>

           <buttons/>
            
        </div>
    </div>    


</template>


<script>
import applicationServices from "../services/ApplicationServices"
import axios from "axios";
import buttons from "../components/buttons.vue"

export default {
   name: 'restaurants',
   components: {
       buttons
   },

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
            'x-rapidapi-key': '14a46059f3msh988e7d991f2e1b8p1364a6jsn76d4c5b639c7',
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

       canDisplayDescription() {
           let description = this.$store.state.currentRestaurant.description
           if(description != null) {
               if(description != '') {
                   return true
               }
           }
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

        collapse() {
            const coll = document.getElementsByClassName("collapsible");

            for (let i = 0; i < coll.length; i++) {
                coll[i].addEventListener("click", function() {
                    this.classList.toggle("active");
                    let content = this.nextElementSibling;
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                    content.style.display = "block";
                    }
                });
            }
        }
   } // end of Methods
} // end of export default

</script>


<style scoped>



button {
    
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
    grid-template-rows: 75px .3fr .005fr .005fr;
    height: 100%;
    grid-template-areas:
    "h1 h1"
    "restaurantDetails imageGrid"
    " btn btn"
    " descriptionGrid descriptionGrid"
    
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


.collapsible {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 10px;
  width: 100%;
  border: 2px solid black;
  outline: none;
  font-size: 15px;
  margin-top: 20px;
}

.active, .collapsible:hover {
  background-color: rgb(184, 184, 184);
}



.descriptionGrid {
    display: grid;
    grid-template-rows: 1fr 3fr;
    height: 100%;
    grid-template-areas:
    "description"
    "content" 
}

#description {
grid-area: description;
}

.content {
  grid-area: content;  
  padding: 0 18px;
  display: none;
  overflow: scroll;
  background-color: #f1f1f16b;
  height: auto;
}
</style>