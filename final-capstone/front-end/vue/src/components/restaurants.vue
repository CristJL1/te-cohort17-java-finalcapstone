<template>
    <div class="restaurants">
    
    </div>    


</template>


<script>
const Documenu = require('documenu')
Documenu.configure('e2992117f97c5ba5fea8074bed9851e6')

export default {
   name: 'restaurants',
   data() {
       return {

       }
   }, 
   created() {
      
           // Don't know if we need this line below
           /*let zipCode = this.$store.state.profile.zipCode
           let result = await Documenu.Restaurants.getRestaurantsByZipCode(zipCode); 
            
            Documenu.Restaurants.getRestaurantsByZipCode(zipCode)
            .then(response=> {
            this.$store.commit("SET_RESTAURANTS", response.data);
        }); */
      

   },

   methods: { }
} // end of export default
</script>


<style scoped>

</style>