<template>
<div>
    <label for="foodtype1">Preferred Types of Cuisine: </label>
      <br>
      <select name="foodtype1" class="foodtype" v-model="preferences.cuisineStyle1" >
        <option value="none" selected disabled hidden>
          Select an Option
        </option>  
        <option value="9908">American</option>
        <option value="10664">Greek</option>
        <option value="5379">Chinese</option>
        <option value="4617">Italian</option>
        <option value="10687">Middle Eastern</option>
        <option value="5110">Mexican</option>
        <option value="10641">Pizza</option>
        <option value="10642">Café</option>
        <option value="10345">Steak</option>
        <option value="10653">Sushi</option>
        <option value="10660">Thai</option>
      </select>
      <select name="foodtype2" class="foodtype" v-model="preferences.cuisineStyle2">
        <option value="none" selected disabled hidden>
          Select an Option
        </option>  
        <option value="9908">American</option>
        <option value="10664">Greek</option>
        <option value="5379">Chinese</option>
        <option value="4617">Italian</option>
        <option value="10687">Middle Eastern</option>
        <option value="5110">Mexican</option>
        <option value="10641">Pizza</option>
        <option value="10642">Café</option>
        <option value="10345">Steak</option>
        <option value="10653">Sushi</option>
        <option value="10660">Thai</option>
      </select>
      <select name="foodtype3" class="foodtype" v-model="preferences.cuisineStyle3">
        <option value="none" selected disabled hidden>
          Select an Option
        </option>  
        <option value="9908">American</option>
        <option value="10664">Greek</option>
        <option value="5379">Chinese</option>
        <option value="4617">Italian</option>
        <option value="10687">Middle Eastern</option>
        <option value="5110">Mexican</option>
        <option value="10641">Pizza</option>
        <option value="10642">Café</option>
        <option value="10345">Steak</option>
        <option value="10653">Sushi</option>
        <option value="10660">Thai</option>
      </select>
      <br>
      <br>
      <p> Dietary Restrictions: </p>
      <input type="checkbox" name="dietary1" value="10992" v-model="dietaryRestrictionsArray">
      <label class="dietarybox" for="dietary1"> Gluten Free</label>
      <input type="checkbox" name="dietary2" value="10697" v-model="dietaryRestrictionsArray">
      <label class="dietarybox" for="dietary2"> Vegan</label>
      <input type="checkbox" name="dietary3" value="10665" v-model="dietaryRestrictionsArray">
      <label class="dietarybox" for="dietary3"> Vegetarian</label>
      <br>
      <br>
      <!-- <p> Price: </p>
      <input type="radio" name="$" value="$" v-model="preferences.pricePoint">
      <label for="$"> $ </label>
      <input type="radio" name="$" value="$$" v-model="preferences.pricePoint">
      <label for="$"> $$ </label>
      <input type="radio" name="$" value="$$$" v-model="preferences.pricePoint">
      <label for="$"> $$$ </label>
      <input type="radio" name="$" value="$$$$" v-model="preferences.pricePoint">
      <label for="$"> $$$$ </label><br> -->
      <br>
      <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit"
      v-on:click.prevent="checkCheckBoxes(); submitUpdatedPreference">
        Save Changes
      </button>
</div>



</template>
<script>
import ApplicationServices from '../services/ApplicationServices'

export default {
  name: 'update-profile',
  data() {
    return {
      dietaryRestrictionsArray: [],
      preferences: {
        userId: "", /* figure how to current UserID passed in*/
        cuisineStyle1: '',
        cuisineStyle2: '',
        cuisineStyle3: '',
        dietaryRestrictions: ''
      }        
    }
  }, // End of Data

  methods: {
    checkCheckBoxes(event) {
        let restrictions = this.dietaryRestrictionsArray
        
        if(restrictions === null) {
           restrictions.push(0, 0, 0)
        }
        if(restrictions.length === 1) {
          restrictions.push(0, 0)
        }
        if(restrictions.length === 2) {
          restrictions.push(0)
        }
        this.preferences.dietaryRestrictions = restrictions.toString();
      },

     /*submitUpdatedPreference() {
        this.preferences.userId = this.$store.state.profile.userId
        this.$store.commit("CLEAR_RESTAURANT_DATA")
        this.$store.commit("CLEAR_RESTAURANT_ID")
        applicationServices
        .addPreferences
        .updatedPreferences(this.preferences)
        .then(response => {
          }, // End of addPreferences Sevice 
            applicationServices
            .getPreferenceById(this.$store.state.profile.userId)
            .then(response => {
              //call mutation to update preferences in data store
              this.$store.commit("FALSE_EDITING_PROFILE")
            })
         
    } // End of Submit Method */

  }// End of Method
} // End of Export

</script>



<style scoped>

</style>

