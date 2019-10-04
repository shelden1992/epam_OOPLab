package org.courses.tour.city;

import org.courses.tour.transport.Airplane;
import org.courses.tour.transport.Bus;
import org.courses.tour.transport.Car;
import org.courses.tour.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class Milan extends City {


    public Milan() {
        super("Milan", 2000);
    }


    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Bus(1000));
        transportMap.put(2, new Airplane(3700));
        transportMap.put(3, new Car(1900));
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
