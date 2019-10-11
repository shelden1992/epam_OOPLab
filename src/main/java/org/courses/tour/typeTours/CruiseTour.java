package org.courses.tour.typeTours;

import org.courses.tour.city.Budapest;
import org.courses.tour.city.City;
import org.courses.tour.city.Istanbul;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class CruiseTour extends Tour {

    public CruiseTour() {
        super(null, null, 2900, null, 0, "Cruise Tour", null);
    }

    public CruiseTour(FoodType foodType, Transport transport, double taxForTour, Map<Integer, City> cities, int day, String name, City city) {
        super(foodType, transport, taxForTour, cities, day, name, city);
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
