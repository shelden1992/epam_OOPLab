package org.courses.tour.entity;

import java.util.List;

public class Tour_type {
    private int idTour;
    private String nameTour;
    private int days;
    private int price;
    private Food_type foodType;
    private Transport transport;
    private List<City> cities;

    public Tour_type(int idTour, String nameTour, int days, int price, Food_type foodType, Transport transport, List<City> cities) {
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Food_type getFoodType() {
        return foodType;
    }

    public void setFoodType(Food_type foodType) {
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
