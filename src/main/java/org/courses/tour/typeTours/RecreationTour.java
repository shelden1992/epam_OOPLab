package org.courses.tour.typeTours;

import org.courses.tour.city.*;

import java.util.HashMap;
import java.util.Map;

public class RecreationTour extends Tour {
    public RecreationTour() {
        super(null, null, 2500, null, 0, "Recreation Tour", null);
    }

    @Override
    public void setCities(Map<Integer, City> cities) {
        this.cities = cities;
    }

    @Override
    public Map<Integer, City> createCity() {
        Map<Integer, City> integerCityMap = new HashMap<>();
        integerCityMap.put(1, new TelAviv());
        integerCityMap.put(2, new Milan());
        integerCityMap.put(3, new Istanbul());
        integerCityMap.put(4, new Budapest());
        integerCityMap.put(5, new Tokyo());
        return integerCityMap;
    }

    @Override
    public void createCityAndSet() {
        setCities(createCity());

    }

    @Override
    public Builder newBuilder() {
        return new RecreationTour().new Builder();
    }
}
