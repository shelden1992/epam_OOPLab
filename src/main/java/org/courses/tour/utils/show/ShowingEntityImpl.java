package org.courses.tour.utils.show;

import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;

import java.util.Map;
import java.util.Set;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class ShowingEntityImpl implements ShowingCity, ShowingTransport, ShowingTour, ShowingTypeFood {
    @Override
    public void showCity(Map<Integer, City> city) {
        Set<Map.Entry<Integer, City>> entries = city.entrySet();
        for (Map.Entry<Integer, City> map : entries
        ) {
            showMessage(map.getKey() + " " + map.getValue().getName());
        }
    }

    @Override
    public void showTransport(Map<Integer, Transport> integerTourMap) {
        Set<Map.Entry<Integer, Transport>> entries = integerTourMap.entrySet();
        for (Map.Entry<Integer, Transport> map : entries
        ) {
            showMessage(map.getKey() + " " + map.getValue().getName());
        }
    }


    @Override
    public void showTours(Map<Integer, Tour> integerTourMap) {
        Set<Map.Entry<Integer, Tour>> entries = integerTourMap.entrySet();
        for (Map.Entry<Integer, Tour> map : entries
        ) {
            showMessage(map.getKey() + " " + map.getValue().getName());
        }
    }


    @Override
    public void showTypeFood(Map<Integer, TypeFood> integerTypeFoodMap) {
        Set<Map.Entry<Integer, TypeFood>> entries = integerTypeFoodMap.entrySet();
        for (Map.Entry<Integer, TypeFood> map : entries
        ) {
            showMessage(map.getKey() + " " + map.getValue().toString());
        }
    }
}
