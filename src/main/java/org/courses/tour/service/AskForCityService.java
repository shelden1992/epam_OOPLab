package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForCityService {
    private static final Logger LOG = Logger.getLogger(AskForCityService.class);

    public City askForCity(Tour tour) {

        ShowingEntityImpl showing = new ShowingEntityImpl();
        Map<Integer, City> cities = tour.getCities();
        showing.showCity(cities);
        int cityNumber = chooseSomeEntity(cities.size());
        LOG.debug("Choose number city = " + cityNumber);
        City city = cities.get(cityNumber);
        city.transportCreateAndSet();
        showMessage("You choose wonderful cities " + city.getName() + " for " + tour.getName() + "! Now chose transport.");
        LOG.info("Choose cities " + city.getName() + " for " + tour.getName());
        return city;
    }


}
