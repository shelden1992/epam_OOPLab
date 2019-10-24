package org.courses.tour.entity;

import java.util.List;
import java.util.StringJoiner;

public class TourType {
    private int idTour;
    private String nameTour;
    private int days;
    private double price;
    private FoodType foodType;
    private Transport transport;
    private List<City> cities;

    public TourType(int idTour, String nameTour, int days, double price, FoodType foodType, Transport transport, List<City> cities) {
        this.idTour = idTour;
        this.nameTour = nameTour;
        this.days = days;
        this.price = price;
        this.foodType = foodType;
        this.transport = transport;
        this.cities = cities;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TourType.class.getSimpleName() + "[", "]")
                .add("idTour=" + idTour)
                .add("nameTour='" + nameTour + "'")
                .add("days=" + days)
                .add("price=" + price)
                .add("foodType=" + foodType)
                .add("transport=" + transport)
                .add("cities=" + cities)
                .toString();
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
