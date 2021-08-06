<template>
    <div class="restaurants">
    
    </div>    


</template>


<script>
import ApplicationServices from '../services/ApplicationServices.js'
const Documenu = require('documenu')
Documenu.configure('e2992117f97c5ba5fea8074bed9851e6')

export default {
   name: 'restaurants',
   data() {
       return {
           apiRestaurants: []

       }
   }, 
   created() {
       // Instantiate the Documenu API with Key
        const Documenu = require('documenu')
        Documenu.configure('e2992117f97c5ba5fea8074bed9851e6')

       ApplicationServices
            .getProfileById(this.$store.state.user.id)
            .then(res => {
              this.$store.commit("SET_PROFILE_DATA", res.data);
              ApplicationServices
              .getPreferenceById(this.$store.state.user.id)
              .then(res => {
                this.$store.commit("SET_PREFERENCE_DATA", res.data); 
                // Create zipCode Variable to hold our current user's zipCode
                let zipCode = this.$store.state.profile.zipCode
                // Call API to get Restaurants by zipCode    
                Documenu.Restaurants.getByZipCode(zipCode)
                .then(response=> {
                this.apiRestaurants = response.data
                }); 
              })
            }) 
   },

   methods: { }
} // end of export default
</script>


<style scoped>

</style>