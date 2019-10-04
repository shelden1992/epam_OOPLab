package org.courses.tour.typeTours;

import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.transport.Transport;

import java.util.Map;
import java.util.StringJoiner;

public abstract class Tour {
    protected TypeFood typeFood;
    protected Transport transport;
    protected double taxForTour;
    protected Map<Integer, City> cities;
    protected City city;
    protected int day;
    protected String name;


    public Tour() {
    }

    public Tour(TypeFood typeFood, Transport transport, double taxForTour, Map<Integer, City> cities, int day, String name, City city) {
        this.typeFood = typeFood;
        this.transport = transport;
        this.taxForTour = taxForTour;
        this.cities = cities;
        this.city = city;
        this.day = day;
        this.name = name;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tour.class.getSimpleName() + "[", "]")
                .add("city=" + city)
                .add("transport=" + transport)
                .add("typeFood=" + typeFood)
                .add("taxForTour=" + taxForTour)
                .add("day=" + day)
                .add("name='" + name + "'")
                .toString();
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public double getTaxForTour() {
        return taxForTour;
    }

    public void setTaxForTour(double taxForTour) {
        this.taxForTour = taxForTour;
    }

    public Map<Integer, City> getCities() {
        return cities;
    }

    public abstract void setCities(Map<Integer, City> cities);

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Map<Integer, City> createCity();

    public abstract void createCityAndSet();

    public abstract Builder newBuilder();


    public class Builder {
        protected Builder() {

        }

        public Builder setDay(int day) {
            Tour.this.setDay(day);
            return this;
        }

        public Builder setTypeFood(TypeFood typeFood) {
            Tour.this.setTypeFood(typeFood);
            return this;
        }

        public Tour build() {
            return Tour.this;
        }

        public Builder setCity(City city) {
            Tour.this.setCity(city);
            return this;
        }

        public Builder setTransport(Transport transports) {
            Tour.this.setTransport(transports);
            return this;
        }
    }
}
