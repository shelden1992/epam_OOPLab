package org.courses.tour;

import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.service.*;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class TourAgency {
    public static void main(String[] args) {

        Tour tour = new AskForTourService().askForTour();
        City city = new AskForCityService().askForCity(tour);
        Transport transport = new AskForTransportService().askForTransport(city);
        TypeFood typeFood = new AskForFoodService().askForFood();
        int day = new AskForDayService().askForDay();
        Tour build = tour.newBuilder().setDay(day).setTypeFood(typeFood).setCity(city).setTransport(transport).build();
        showMessage(String.valueOf(build));
        new CalculateService().calculate(build);
    }
}
