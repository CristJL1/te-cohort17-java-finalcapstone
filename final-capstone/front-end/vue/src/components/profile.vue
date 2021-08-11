<template>
<div>
    <h1>Preferences</h1>

    <p>{{this.$store.state.preference.cuisineStyle1}}</p>
    <p>{{this.$store.state.preference.cuisineStyle2}}</p>
    <p>{{this.$store.state.preference.cuisineStyle3}}</p>
    <p>{{this.$store.state.preference.pricePoint}}</p>
    <p>{{this.$store.state.preference.dietaryRestrictions}}</p>
 
    
    <button v-on:click.prevent="editProfile">Edit Profile</button>
 
    
  


</div>

</template>

<script>
export default {
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
    
    this.CurrentUserCuisine1 = this.$store.state.cuisines.find(cuisineId => cuisineId === id1)
    this.CurrentUserCuisine2 = this.$store.state.cuisines.find(cuisineId => cuisineId === id2)
    this.CurrentUserCuisine3 = this.$store.state.cuisines.find(cuisineId => cuisineId === id3)
  }
}
</script>

