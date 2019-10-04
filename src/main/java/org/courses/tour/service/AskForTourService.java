package org.courses.tour.service;

import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.creationLogic.CreateTourAndTypeFoodImpl;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForTourService {

    public Tour askForTour() {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        CreateTourAndTypeFoodImpl createTourAndTypeFood = new CreateTourAndTypeFoodImpl();
        showMessage("Hello, we have many type of tour, what you prefer?");
        Map<Integer, Tour> integerTourMap = createTourAndTypeFood.creationTourMap();
        showing.showTours(integerTourMap);
        int tourNumber = chooseSomeEntity(integerTourMap.size());
        Tour tour = integerTourMap.get(tourNumber);
        showMessage("Ok, you choose " + tour.getName() + " this tour better realize in cities ");
        return tour;
    }
}
