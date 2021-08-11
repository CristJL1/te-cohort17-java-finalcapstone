<template>
<div>
    <h1>Preferences</h1>

    <p>{{CurrentUserCuisine1}}</p>
    <p>{{CurrentUserCuisine2}}</p>
    <p>{{CurrentUserCuisine3}}</p>
    <p>{{this.$store.state.preference.pricePoint}}</p>
    <p>{{this.$store.state.preference.dietaryRestrictions}}</p>
 
    
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
    }
  }, // end of data
  created() {
    let id1 = this.$store.state.preference.cuisineStyle1
    let id2 = this.$store.state.preference.cuisineStyle2
    let id3 = this.$store.state.preference.cuisineStyle3
    
    this.CurrentUserCuisine1 = this.$store.state.cuisines.find(cuisine => cuisine.key === id1).name
    this.CurrentUserCuisine2 = this.$store.state.cuisines.find(cuisine => cuisine.key === id2).name
    this.CurrentUserCuisine3 = this.$store.state.cuisines.find(cuisine => cuisine.key === id3).name
  }
}
</script>

