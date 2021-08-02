package com.techelevator.application.model;

public class Preference {

    private long    preferenceId;
    private String  cuisineStyle1;
    private String  cuisineStyle2;
    private String  cuisineStyle3;
    private String  pricePoint;
    private boolean vegan;
    private boolean vegetarian;
    private boolean glutenFree;

    public long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public String getCuisineStyle1() {
        return cuisineStyle1;
    }

    public void setCuisineStyle1(String cuisineStyle1) {
        this.cuisineStyle1 = cuisineStyle1;
    }

    public String getCuisineStyle2() {
        return cuisineStyle2;
    }

    public void setCuisineStyle2(String cuisineStyle2) {
        this.cuisineStyle2 = cuisineStyle2;
    }

    public String getCuisineStyle3() {
        return cuisineStyle3;
    }

    public void setCuisineStyle3(String cuisineStyle3) {
        this.cuisineStyle3 = cuisineStyle3;
    }

    public String getPricePoint() {
        return pricePoint;
    }

    public void setPricePoint(String pricePoint) {
        this.pricePoint = pricePoint;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "preferenceId=" + preferenceId +
                ", cuisineStyle1='" + cuisineStyle1 + '\'' +
                ", cuisineStyle2='" + cuisineStyle2 + '\'' +
                ", cuisineStyle3='" + cuisineStyle3 + '\'' +
                ", pricePoint='" + pricePoint + '\'' +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                ", glutenFree=" + glutenFree +
                '}';
    }
}
