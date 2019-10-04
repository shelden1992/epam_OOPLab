package org.courses.tour.city;

import org.courses.tour.transport.*;

import java.util.HashMap;
import java.util.Map;

public class Budapest extends City {


    public Budapest() {
        super("Budapest", 1000.0);
    }

    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Bus(700));
        transportMap.put(2, new Airplane(1700));
        transportMap.put(3, new Ship(2000));
        transportMap.put(4, new Car(1200));
        transportMap.put(5, new Train(650));
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
