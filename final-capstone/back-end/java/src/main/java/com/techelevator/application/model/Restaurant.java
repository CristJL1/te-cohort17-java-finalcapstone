package com.techelevator.application.model;

public class Restaurant {

    private Long restaurantId;
    private Long locationId;
    private String restaurantName;
    private String restaurantPhone;
    private String restaurantWebsite;
    private String hours;
    private String priceRange;
    private Integer priceRangeNum;
    private String cuisineType1;
    private String cuisineType2;
    private String cuisineType3;
    private String cuisineType4;
    private String cuisineType5;
    private String cuisineType6;
    private String cuisineType7;
    private String city;
    private String state;
    private Integer postal_code;
    private String street;
    private String formatted;
    private Double lat;
    private Double lon;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getRestaurantWebsite() {
        return restaurantWebsite;
    }

    public void setRestaurantWebsite(String restaurantWebsite) {
        this.restaurantWebsite = restaurantWebsite;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public Integer getPriceRangeNum() {
        return priceRangeNum;
    }

    public void setPriceRangeNum(Integer priceRangeNum) {
        this.priceRangeNum = priceRangeNum;
    }

    public String getCuisineType1() {
        return cuisineType1;
    }

    public void setCuisineType1(String cuisineType1) {
        this.cuisineType1 = cuisineType1;
    }

    public String getCuisineType2() {
        return cuisineType2;
    }

    public void setCuisineType2(String cuisineType2) {
        this.cuisineType2 = cuisineType2;
    }

    public String getCuisineType3() {
        return cuisineType3;
    }

    public void setCuisineType3(String cuisineType3) {
        this.cuisineType3 = cuisineType3;
    }

    public String getCuisineType4() {
        return cuisineType4;
    }

    public void setCuisineType4(String cuisineType4) {
        this.cuisineType4 = cuisineType4;
    }

    public String getCuisineType5() {
        return cuisineType5;
    }

    public void setCuisineType5(String cuisineType5) {
        this.cuisineType5 = cuisineType5;
    }

    public String getCuisineType6() {
        return cuisineType6;
    }

    public void setCuisineType6(String cuisineType6) {
        this.cuisineType6 = cuisineType6;
    }

    public String getCuisineType7() {
        return cuisineType7;
    }

    public void setCuisineType7(String cuisineType7) {
        this.cuisineType7 = cuisineType7;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", locationId=" + locationId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", restaurantWebsite='" + restaurantWebsite + '\'' +
                ", hours='" + hours + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", priceRangeNum=" + priceRangeNum +
                ", cuisineType1='" + cuisineType1 + '\'' +
                ", cuisineType2='" + cuisineType2 + '\'' +
                ", cuisineType3='" + cuisineType3 + '\'' +
                ", cuisineType4='" + cuisineType4 + '\'' +
                ", cuisineType5='" + cuisineType5 + '\'' +
                ", cuisineType6='" + cuisineType6 + '\'' +
                ", cuisineType7='" + cuisineType7 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code=" + postal_code +
                ", street='" + street + '\'' +
                ", formatted='" + formatted + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
