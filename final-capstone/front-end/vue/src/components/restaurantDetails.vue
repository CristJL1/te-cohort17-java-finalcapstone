<template>
    <div class="descriptionGrid">
            <button type="button" id="description" class="collapsible" v-on:click.prevent="collapse">See Description</button>
                <div class="content">
                    <p v-if="canDisplayDescription()">Description: {{this.$store.state.currentRestaurant.description}}</p>
                    <p>{{this.$store.state.currentRestaurant.rating}}</p>

                    <div class="awardGrid">
                        <div class="awardName">
                            <div id="name"
                                v-for="awardObject in this.$store.state.currentRestaurant.awards"
                                v-bind:key="awardObject.id"><span>{{awardObject.display_name}}</span></div>
                        </div>
                        <div class="awardImg">
                            <div 
                                v-for="awardObject in this.$store.state.currentRestaurant.awards"
                                v-bind:key="awardObject.id"><img id="award" v-bind:src="awardObject.images.large" alt=""></div>
                        </div>
                    </div>
                    <p> <a v-bind:href="this.$store.state.currentRestaurant.reviews[0].url" target="_blank">
                        Click here to see {{this.$store.state.currentRestaurant.name}}'s Reviews!</a>
                    </p>
                </div>
    </div>
</template>

<script>
import restaurantsVue from './restaurants.vue'
export default {
    name: 'restaurants-details',

    methods: {
        canDisplayDescription() {
           let description = this.$store.state.currentRestaurant.description
           if(description != null) {
               if(description != '') {
                   return true
               }
           }
       },

       collapse() {
            const coll = document.getElementsByClassName("collapsible");

            for (let i = 0; i < coll.length; i++) {
                coll[i].addEventListener("click", function() {
                    this.classList.toggle("active");
                    let content = this.nextElementSibling;
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                    content.style.display = "block";
                    }
                });
            }
        }
    }
}
</script>

<style scoped>

#award {
    height: 75px;
    width: 75px;
}

#name {
    height: 79px;
    width: 200px;
    text-align: center;
}

span {
    text-align: center;
    vertical-align: middle;
}

button {
    height: 60px;
}
.collapsible {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 10px;
  width: 100%;
  border: 2px solid black;
  outline: none;
  font-size: 15px;
  margin-top: 20px;
}

.active, .collapsible:hover {
  background-color: rgb(184, 184, 184);
}

.content {
  grid-area: content;  
  padding: 0 18px;
  display: none;
  overflow: scroll;
  background-color: #f1f1f16b;
  height: auto;
}

#description {
grid-area: description;
}

.descriptionGrid {
    display: grid;
    grid-template-areas:
    "description"
    "content" 
}

.awardGrid {
    display: grid;
    grid-template-columns: .25fr .5fr 1fr 1fr;
    grid-template-areas:
    "awardImg awardName . .";
}

.awardImg {
    grid-area: awardImg;
}

.awardName {
    grid-area: awardName;
}
</style>