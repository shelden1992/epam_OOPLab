package org.courses.tour.city;

import org.courses.tour.transport.Airplane;
import org.courses.tour.transport.Ship;
import org.courses.tour.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class Istanbul extends City {

    public Istanbul() {
        super("Istanbul", 1300);
    }

    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Airplane(3700));
        transportMap.put(2, new Ship(2000));
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
