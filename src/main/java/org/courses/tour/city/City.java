package org.courses.tour.city;

import org.courses.tour.transport.Transport;

import java.util.Map;
import java.util.StringJoiner;

public abstract class City {
    protected String name;
    protected double distance;
    protected Map<Integer, Transport> transportMap;

    public City() {
    }

    public City(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

//

    public Map<Integer, Transport> getTransportMap() {
        return transportMap;
    }

    protected abstract void setTransportMap(Map<Integer, Transport> transportMap);

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("distance=" + distance)

                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    protected abstract Map<Integer, Transport> transportCreate();

    public abstract void transportCreateAndSet();
}
