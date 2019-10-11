package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.show.ShowingEntityImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

@Service
public class AskForCityService {
    private static final Logger LOG = Logger.getLogger(AskForCityService.class);

    public City askForCity(Tour tour) {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        Map<Integer, City> cities = tour.getCities();
        showing.showCity(cities);
        int cityNumber = chooseSomeEntity(cities.size());
        City city = cities.get(cityNumber);
        city.transportCreateAndSet();
        LOG.info("Choose cite = " + city.getName());
        showMessage("You choose wonderful cities " + city.getName() + " for " + tour.getName() + "! Now chose transport.");
        return city;
    }


}
