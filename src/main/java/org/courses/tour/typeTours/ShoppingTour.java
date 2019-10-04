package org.courses.tour.typeTours;

import org.courses.tour.city.City;
import org.courses.tour.city.Istanbul;
import org.courses.tour.city.Milan;
import org.courses.tour.city.TelAviv;

import java.util.HashMap;
import java.util.Map;

public class ShoppingTour extends Tour {
    public ShoppingTour() {
        super(null, null, 2500, null, 0, "Shopping Tour", null);
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
        return integerCityMap;
    }

    @Override
    public void createCityAndSet() {
        setCities(createCity());

    }

    @Override
    public Builder newBuilder() {
        return new ShoppingTour().new Builder();
    }
}
