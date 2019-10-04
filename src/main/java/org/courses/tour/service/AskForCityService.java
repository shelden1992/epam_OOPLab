package org.courses.tour.service;

import org.courses.tour.city.City;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForCityService {
    public City askForCity(Tour tour) {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        tour.createCityAndSet();
        Map<Integer, City> cities = tour.getCities();
        showing.showCity(cities);
        int cityNumber = chooseSomeEntity(cities.size());
        City city = cities.get(cityNumber);
        city.transportCreateAndSet();
        showMessage("You choose wonderful cities " + city.getName() + " for " + tour.getName() + "! Now chose transport.");
        return city;
    }


}
