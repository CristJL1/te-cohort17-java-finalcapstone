<template>
    <div class="buttonFooter">
        <button v-on:click.prevent="pushToDatabase(); cycleRestaurant()">I Like this Restaurant</button>
        <button v-on:click.prevent="cycleRestaurant">I Dislike this Restaurant</button>
    </div>
    
</template>

<script>
export default {
    name: 'buttons',

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
               this.$store.commit("RESET_RESTAURANTDTO")}) 

       }

    }
    
}
</script>

<style scoped>

</style>