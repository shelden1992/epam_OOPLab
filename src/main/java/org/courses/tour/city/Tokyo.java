package org.courses.tour.city;

import org.courses.tour.transport.Airplane;
import org.courses.tour.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class Tokyo extends City {

    public Tokyo() {
        super("Tokyo", 1100);
    }

    @Override
    protected Map<Integer, Transport> transportCreate() {
        Map<Integer, Transport> transportMap = new HashMap<>();
        transportMap.put(1, new Airplane(13000));
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
