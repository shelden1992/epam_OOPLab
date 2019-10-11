package org.courses.tour.utils.show;

import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class ShowingEntityImpl implements ShowingCity, ShowingTransport, ShowingTour, ShowingTypeFood {
    @Override
    public void showCity(Map<Integer, City> city) {
        city.forEach((key, value) -> showMessage(key + " " + value.getName()));
    }


    @Override
    public void showTransport(Map<Integer, Transport> integerTourMap) {
        integerTourMap.forEach((key, value) -> showMessage(key + " " + value.getName()));
    }


    @Override
    public void showTours(Map<Integer, Tour> integerTourMap) {
        integerTourMap.forEach((key, value) -> showMessage(key + " " + value.getName()));

    }


    @Override
    public void showTypeFood(Map<Integer, FoodType> integerTypeFoodMap) {
        integerTypeFoodMap.forEach((key, value) -> showMessage(key + " " + value.toString()));
    }
}
