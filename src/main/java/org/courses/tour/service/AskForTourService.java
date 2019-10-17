package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.creationLogic.CreateTourAndTypeFoodImpl;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForTourService {
    private static final Logger LOG = Logger.getLogger(AskForTourService.class);

    public Tour askForTour() {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        CreateTourAndTypeFoodImpl createTourAndTypeFood = new CreateTourAndTypeFoodImpl();
        showMessage("Hello, we have many type of tour, what you prefer?");
        Map<Integer, Tour> integerTourMap = createTourAndTypeFood.creationTourMap();
        showing.showTours(integerTourMap);
        int tourNumber = chooseSomeEntity(integerTourMap.size());
        LOG.info("Choose tour under the number = " + tourNumber);
        Tour tour = integerTourMap.get(tourNumber);
        LOG.info("Choose Tour = " + tour);
        tour.createCityAndSet();
        showMessage("Ok, you choose " + tour.getName() + " this tour better realize in cities ");
        return tour;
    }
}
