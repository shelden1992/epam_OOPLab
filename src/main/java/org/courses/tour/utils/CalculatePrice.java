package org.courses.tour.utils;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;

public class CalculatePrice {
    public static final  Logger LOG = Logger.getLogger(CalculatePrice.class);
    private static final int CITY_COEFFICIENT = 1000;
    private City city;
    private Transport transport;
    private Tour tour;
    private FoodType foodType;
    private int day;

    public CalculatePrice(Tour tour) {
        this.city = tour.getCity();
        this.transport = tour.getTransport();
        this.tour = tour;
        this.foodType = tour.getFoodType();
        this.day = tour.getDay();
    }

    public double calculateTour() {

        double totalPrice = day * (transport.getCost() + city.getDistance() / CITY_COEFFICIENT + tour.getTaxForTour());
        double v1 = totalPrice * foodType.getPriceСoefficient();
        return totalPrice + v1;


    }


}
