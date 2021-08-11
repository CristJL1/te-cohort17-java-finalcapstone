<template>
<div>
    <h1>Preferences</h1>

    <p>{{CurrentUserCuisine1}}</p>
    <p>{{CurrentUserCuisine2}}</p>
    <p>{{CurrentUserCuisine3}}</p>
    <p>{{this.$store.state.preference.pricePoint}}</p>
    <p>{{dietaryRestrictions}}</p>
 
    
    <button v-on:click.prevent="editProfile">Edit Profile</button>
 
    <h2> Liked Restaurants </h2> 
    <liked-restaurants/>
    
  


</div>

</template>

<script>
import LikedRestaurants from './LikedRestaurants.vue'

export default {
  components: { LikedRestaurants },
  name: 'profile',
  data () {
    return {
      CurrentUserCuisine1: '',
      CurrentUserCuisine2: '',
      CurrentUserCuisine3: '',
      restriction1: '',
      restriction2: '',
      restriction3: '',
      dietaryRestrictions: ''
    }
  }, // end of data
  created() {
    let id1 = this.$store.state.preference.cuisineStyle1
    let id2 = this.$store.state.preference.cuisineStyle2
    let id3 = this.$store.state.preference.cuisineStyle3
    let restrictions = this.$store.state.preference.dietaryRestrictions.split(",")
    
    this.CurrentUserCuisine1 = this.$store.state.cuisines.find(cuisine => cuisine.key === id1).name
    this.CurrentUserCuisine2 = this.$store.state.cuisines.find(cuisine => cuisine.key === id2).name
    this.CurrentUserCuisine3 = this.$store.state.cuisines.find(cuisine => cuisine.key === id3).name

    if (restrictions[0] !== 0) {
      this.restriction1 = this.$store.state.cuisines.find(cuisine => cuisine.key === restrictions[0]).name
      this.dietaryRestrictions = this.restriction1
    }
    if (restrictions[1] !== 0) {
      this.restriction2 = this.$store.state.cuisines.find(cuisine => cuisine.key === restrictions[1]).name
      this.dietaryRestrictions = this.restriction1 + " and " + this.restriction2
    }

    if (restrictions[2] !== 0) {
      this.restriction3 = this.$store.state.cuisines.find(cuisine => cuisine.key === restrictions[2]).name
      this.dietaryRestrictions = this.restriction1 + ", " + this.restriction2 + ", and " + this.restriction3
    }
  }
}
</script>

