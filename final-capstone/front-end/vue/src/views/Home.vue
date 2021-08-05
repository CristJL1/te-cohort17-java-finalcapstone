<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <restaurants/>
  </div>
</template>

<script>
import restaurants from '../components/restaurants.vue';
import ApplicationServices from '../services/ApplicationServices';
export default {
  components: { restaurants },
  name: "home",
  created() {
    ApplicationServices
            .getProfileById(this.$store.state.user.id)
            .then(res => {
              this.$store.commit("SET_PROFILE_DATA", res.data);
              ApplicationServices
              .getPreferenceById(this.$store.state.user.id)
              .then(res => {
                this.$store.commit("SET_PREFERENCE_DATA", res.data); // need a service to get preference and profile
              })
            }) 
  }
};

</script>
