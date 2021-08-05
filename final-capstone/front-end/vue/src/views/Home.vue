<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <restaurants/>
  </div>
</template>

<script>
import restaurants from '../components/restaurants.vue';
export default {
  components: { restaurants },
  name: "home"
};
</script>
