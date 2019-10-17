package org.courses.tour.utils;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;


public class CalculatePrice {
    public static final Logger LOG = Logger.getLogger(CalculatePrice.class);
    private static final int CITY_COEFFICIENT = 1000;
    private City city;
    private Transport transport;
    private Tour tour;
    private TypeFood typeFood;
    private int day;

    public CalculatePrice(Tour tour) {
        this.city = tour.getCity();
        this.transport = tour.getTransport();
        this.tour = tour;
        this.typeFood = tour.getTypeFood();
        this.day = tour.getDay();
        LOG.debug("CalculatePrice was initialization by Tour " + tour.toString());
    }

    public double calculateTour() {

        double v = day * (transport.getCost() + city.getDistance() / CITY_COEFFICIENT + tour.getTaxForTour());
        double v1 = v * typeFood.getPriceСoefficient();
        LOG.info("Tour cost " + v + v1);
        return v + v1;


    }


}
