<template>
    <select name="cityDropdownMenu" class="dropdown" v-model="latLongString">
        <option value="none" selected disabled hidden>
          Select a City
        </option>  
        <option value="33.4484, -112.0740">Phoenix, AZ</option>
        <option value="34.0522, -118.2437">Los Angeles, CA</option>
        <option value="37.7736, -122.4126">San Francisco, CA</option>
        <option value="39.7421, -104.9724">Denver, CO</option>
        <option value="30.3591, -81.5511">Jacksonville, FL</option>
        <option value="39.7779, -86.1574">Indianapolis, IN</option>
        <option value="41.8781, -87.6298">Chicago, IL</option>
        <option value="42.3624, -71.0618">Boston, MA</option>
        <option value="42.6866, -73.7432">Albany, NY</option>
        <option value="42.8839, -78.8094">Buffalo, NY</option>
        <option value="40.7128, -74.0060">New York City, NY</option>
        <option value="41.0814, -81.5190">Akron, OH</option>
        <option value="41.4993, -81.6944">Cleveland, OH</option>
        <option value="39.9887, -83.0104">Columbus, OH</option>
        <option value="39.9526, -75.1652">Philadelphia, PA</option>
        <option value="35.2907, -80.7440">Charlotte, SC</option>
        <option value="32.7767, -96.7970">Dallas, TX</option>
        <option value="29.7604, -95.3698">Houston, TX</option>
        <option value="47.6036, -122.3358">Seattle, WA</option>
        <option value="38.9113, -77.0407">Washington D.C.</option>
      </select>
</template>



<script>
export default {

    name: changeLocation,
    data() { 

        return {

        latLongString:'',
        lat: '',
        long: '',
        }
    },
    methods: {
        splitString() {
            // method to split latLongString at the comma
            // computed method to call splitString
        }
    }
}
</script>


<style scoped>

</style>