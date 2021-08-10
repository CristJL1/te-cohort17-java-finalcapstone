<template>
<div>
    <label for="foodtype1">Preferred Types of Cuisine: </label>
      <br>
      <select name="foodtype1" class="foodtype" v-model="preferences.cuisineStyle1">
        <option value="none" selected disabled hidden>
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
      <select name="foodtype2" class="foodtype" v-model="preferences.cuisineStyle2">
        <option value="none" selected disabled hidden>
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
      <select name="foodtype3" class="foodtype" v-model="preferences.cuisineStyle3">
        <option value="none" selected disabled hidden>
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
      <br>
      <p> Dietary Restrictions: </p>
      <input type="checkbox" name="dietary1" value="true" v-model="preferences.glutenFree">
      <label class="dietarybox" for="dietary1"> Gluten Free</label>
      <input type="checkbox" name="dietary2" value="true" v-model="preferences.vegan">
      <label class="dietarybox" for="dietary2"> Vegan</label>
      <input type="checkbox" name="dietary3" value="true" v-model="preferences.vegetarian">
      <label class="dietarybox" for="dietary3"> Vegetarian</label>
      <br>
      <br>
      <p> Price: </p>
      <input type="radio" name="$" value="$" v-model="preferences.pricePoint">
      <label for="$"> $ </label>
      <input type="radio" name="$" value="$$" v-model="preferences.pricePoint">
      <label for="$"> $$ </label>
      <input type="radio" name="$" value="$$$" v-model="preferences.pricePoint">
      <label for="$"> $$$ </label>
      <input type="radio" name="$" value="$$$$" v-model="preferences.pricePoint">
      <label for="$"> $$$$ </label><br>
      <br>
      <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Save Changes
        </button>
</div>



</template>
<script></script>


<style scoped>

</style>

