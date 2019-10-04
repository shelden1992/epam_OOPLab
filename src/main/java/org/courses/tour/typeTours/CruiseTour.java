package org.courses.tour.typeTours;

import org.courses.tour.city.Budapest;
import org.courses.tour.city.City;
import org.courses.tour.city.Istanbul;

import java.util.HashMap;
import java.util.Map;

public class CruiseTour extends Tour {

    public CruiseTour() {
        super(null, null, 2900, null, 0, "Cruise Tour", null);
    }

    @Override
    public void setCities(Map<Integer, City> cities) {
        this.cities = cities;
    }

    @Override
    public Map<Integer, City> createCity() {
        Map<Integer, City> integerCityMap = new HashMap<>();

        integerCityMap.put(1, new Istanbul());
        integerCityMap.put(2, new Budapest());

        return integerCityMap;
    }

    @Override
    public void createCityAndSet() {
        setCities(createCity());

    }

    @Override
    public Builder newBuilder() {
        return new CruiseTour().new Builder();
    }
}
