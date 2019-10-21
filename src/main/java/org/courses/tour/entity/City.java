package org.courses.tour.entity;

import java.util.List;

public class City {
    private String nameCity;
    private double distance;
    private List<Transport> transports;

    public City(String nameCity, double distance, List<Transport> transports) {
        this.nameCity = nameCity;
        this.distance = distance;
        this.transports = transports;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }
}
