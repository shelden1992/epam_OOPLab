package org.courses.tour.typeTours;

import org.courses.tour.city.City;
import org.courses.tour.city.TelAviv;

import java.util.HashMap;
import java.util.Map;

public class TreatmentTour extends Tour {

    public TreatmentTour() {
        super(null, null, 2000, null, 0, "Treatment Tour", null);
    }

    @Override
    public void setCities(Map<Integer, City> cities) {
        this.cities = cities;
    }

    @Override
    public Map<Integer, City> createCity() {
        Map<Integer, City> integerCityMap = new HashMap<>();
        integerCityMap.put(1, new TelAviv());
        return integerCityMap;
    }

    @Override
    public void createCityAndSet() {
        setCities(createCity());

    }

    @Override
    public Builder newBuilder() {
        return new TreatmentTour().new Builder();
    }
}
