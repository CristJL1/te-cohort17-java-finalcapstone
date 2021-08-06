<template>
<div>
    <form class="form-questionnaire" @submit.prevent="submitQuestionnaire">
    <h1>Preferences</h1>
    <label for="foodtype1">{{cuisineStyle1}} </label>
      <input v-model="preferences.cuisineStyle1">
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        required
        autofocus
      />
    <br>

      </form>


</div>

</template>


<script>

export default {
    name: 'profile',
    data() {
        return {
        preferences: {
                 userId: '', 
                 cuisineStyle1: '',
                 cuisineStyle2: '',
                 cuisineStyle3: '',
                 pricePoint: '',
                 vegan: false,
                 vegetarian: false,
                 glutenFree: false
            }
    } // end of return 
}   // end of data
}  // end of export default

</script>


<style scoped>

</style>