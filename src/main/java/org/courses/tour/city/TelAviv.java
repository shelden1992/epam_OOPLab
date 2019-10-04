package org.courses.tour.city;

import org.courses.tour.transport.*;

import java.util.*;

public class TelAviv extends City {

    public TelAviv() {
        super("Tel Aviv", 1900);
    }


    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Airplane(3700));
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
