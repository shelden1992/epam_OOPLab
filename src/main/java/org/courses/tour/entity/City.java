package org.courses.tour.entity;

import java.util.List;
import java.util.StringJoiner;

public class City {
    private int idCity;
    private String nameCity;
    private List<Transport> transports;

    public City(int idCity, String nameCity, List<Transport> transports) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.transports = transports;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "[", "]")
                .add("idCity=" + idCity)
                .add("nameCity='" + nameCity + "'")
                .add("transports=" + transports)
                .toString();
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }
}
