package org.courses.tour.city;

import org.courses.tour.transport.Airplane;
import org.courses.tour.transport.Bus;
import org.courses.tour.transport.Car;
import org.courses.tour.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class Tbilisi extends City {
    public Tbilisi() {
        super("Tbilisi", 1866);
    }


    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Bus(2700));
        transportMap.put(2, new Airplane(3400));
        transportMap.put(3, new Car(2200));
        return transportMap;
    }

    @Override
    protected void setTransportMap(Map<Integer, Transport> transportMap) {
        this.transportMap = transportMap;

    }

    @Override
    public void transportCreateAndSet() {
        setTransportMap(transportCreate());
    }
}
