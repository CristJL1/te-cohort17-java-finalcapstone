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
  name: 'profile'
  
}
</script>

