<template>
<div>
    <form class="form-questionnaire">
    <h1>Preferences</h1>
    <label for="foodtype1">Preferred Types of Cuisine: </label>
    <br>
      <select name="foodtype1" class="foodtype" v-model="preferences.cuisineStyle1">
        <option value="{{this.$store.state.preferences}}" selected disabled hidden>
          Select an Option
        </option>  
        <option value="american">American</option>
        <option value="barbecue">Barbecue</option>
        <option value="chinese">Chinese</option>
        <option value="italian">Italian</option>
        <option value="indian">Indian</option>
        <option value="mexican">Mexican</option>
        <option value="pizza">Pizza</option>
        <option value="seafood">Seafood</option>
        <option value="steak">Steak</option>
        <option value="sushi">Sushi</option>
        <option value="thai">Thai</option>
      </select>
    <br>
    <label for="foodtype2">{{cuisineStyle2}} </label>
      <input v-model="preferences.cuisineStyle2">
        type="text"
        id="foodType2"
        class="form-control"
        placeholder={{this.$store.state.preferences}}
        autofocus
      />
    <br>
    <label for="foodtype3">{{cuisineStyle3}} </label>
      <input v-model="preferences.cuisineStyle3">
        type="text"
        id="foodType3"
        class="form-control"
        placeholder={{this.$store.state.preferences}}
        autofocus
      />
    <br>
    
      <br>
      <p> Dietary Restrictions: </p>
      <input type="checkbox" name="dietary1" value="true" v-model="preferences.glutenFree">
        <label class="dietarybox" for="dietary1"> Gluten Free</label>
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