<template>
  <div class="questionnaire text-center">
    <form class="form-questionnaire" @submit.prevent="questionnaire">
    <h1>Questionnaire</h1>
    <label for="firstName">First Name </label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        required
        autofocus
      />
      <br>
      <label for="lastName">Last Name </label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        required
      />
      <br>
      <label for="DOB">Date of Birth </label>
      <input type="date" id="DOB" name="DOB" required>
      <br>
      <label for="email">Email </label>
      <input id="email" name="email" type="email" placeholder="email@address.com" required="required">
      <br>
      <label for="zipcode">Zip Code </label>
      <input id="zipcode" type="text" name="zipcode">
      <br>
      <label for="foodtype1">Preferred Types of Cuisine: </label>
      <br>
      <select name="foodtype1" class="foodtype">
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
      <select name="foodtype2" class="foodtype">
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
      <select name="foodtype3" class="foodtype">
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
      <input type="checkbox" name="dietary1" value="glutenFree">
      <label class="dietarybox" for="dietary1"> Gluten Free</label>
      <input type="checkbox" name="dietary2" value="vegan">
      <label class="dietarybox" for="dietary2"> Vegan</label>
      <input type="checkbox" name="dietary3" value="vegitarian">
      <label class="dietarybox" for="dietary3"> Vegitarian</label>
      <br>
      <br>
      <p> Price: </p>
      <input type="radio" name="$" value="$">
      <label for="$"> $ </label>
      <input type="radio" name="$" value="$$">
      <label for="$"> $$ </label>
      <input type="radio" name="$" value="$$$">
      <label for="$"> $$$ </label>
      <input type="radio" name="$" value="$$$$">
      <label for="$"> $$$$ </label><br>
      <br>
      <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <br>
      <br>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
</template>

<script>
export default {
  name: "questionnaire"
};
</script>

<style scoped>
    h1{
        color: red;
    }

    .questionnaire {
        display: grid;
        grid-template-columns: 1fr 3fr 1fr;
        grid-template-rows: 100px 2fr 100px;
        height: 100%;
        grid-template-areas:
            ". . ."
            ". form-questionnaire ."
            ". . ."
    }

    .form-questionnaire {
        grid-area: form-questionnaire;
        background-color: white;
        height: 650px;
        padding: 5%;
    }

    .text-center {
        text-align: center;
        font-family: Monospace, Cursive, Sans-serif;
    }

    .foodtype {
        margin: 2%;
    }

    .dietarybox {
        margin: 2%;
    }

    p {
        margin: 0px;
    }
    
</style>