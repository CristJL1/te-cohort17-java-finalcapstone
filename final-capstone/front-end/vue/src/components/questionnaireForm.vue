<template>
    <div class="questionnaire text-center"> 
    <form class="form-questionnaire" @submit.prevent="questionnaire">
    <h1>Questionnaire</h1>
    <label for="firstName">First Name </label>
      <input v-model="profile.firstName"
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        required
        autofocus
      />
      <br>
      <label for="lastName">Last Name </label>
      <input v-model="profile.lastName"
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        required
      />
      <br>
      <label for="DOB">Date of Birth </label>
      <input type="date" id="DOB" name="DOB" v-model="profile.DOB" required>
      <br>
      <label for="email">Email </label>
      <input id="email" name="email" type="email" placeholder="email@address.com" v-model="profile.email" required="required">
      <br>
      <label for="zipcode">Zip Code </label>
      <input id="zipcode" type="text" name="zipcode" v-model="profile.zipCode">
      <br>
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
      <input type="checkbox" name="dietary3" value="true" v-model="preferences.vegitarian">
      <label class="dietarybox" for="dietary3"> Vegitarian</label>
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
    
}
</script>

<script>
import applicationServices from "../services/ApplicationServices"

export default {
    name: 'questionnaire-form',
    data() {
        return {
            profile: {
                firstName: '',
                lastName: '',
                DOB: '',
                email: '',
                zipCode: ''
            },
            preferences: {
                 cuisineStyle1: '',
                 cuisineStyle2: '',
                 cuisineStyle3: '',
                 pricePoint: '',
                 vegan: false,
                 vegetarian: false,
                 glutenFree: false
            }
        }
    }, // END OF DATA
    methods: {
        submitQuestionnaire() {
            const newProfile = {
                firstName: this.profile.firstName,
                lastName: this.profile.lastName,
                DOB: this.profile.DOB,
                email: this.profile.email,
                zipCode: this.profile.zipCode 
            };
            applicationServices
            .addProfile(newProfile)
            .then(response => {
            this.profile = response.data;
        })

        const newPreferences = {
                 cuisineStyle1: this.preferences.cuisineStyle1,
                 cuisineStyle2: this.preferences.cuisineStyle2,
                 cuisineStyle3: this.preferences.cuisineStyle3,
                 pricePoint: this.preferences.pricePoint,
                 vegan: this.preferences.vegan,
                 vegetarian: this.preferences.vegetarian,
                 glutenFree: this.preferences.glutenFree
            }
            applicationServices
            .addPreferences(newPreferences)
            .then(response => {
            this.preferences = response.data;
        })

        } // END OF SUBMITQUESTIONNAIRE
    }
}
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