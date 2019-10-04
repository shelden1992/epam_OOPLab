package org.courses.tour;

import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.CalculatePrice;
import org.courses.tour.utils.selectionLogic.CreateTourAndTypeFoodImpl;
import org.courses.tour.utils.selectionLogic.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.enterMessageForTour;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class TourAgency {
    public static void main(String[] args) {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        CreateTourAndTypeFoodImpl createTourAndTypeFood = new CreateTourAndTypeFoodImpl();
        showMessage("Hello, we have many type of tour, what you prefer?");
        Map<Integer, Tour> integerTourMap = createTourAndTypeFood.creationTourMap();
        showing.showTours(integerTourMap);
        int tourNumber = enterMessageForTour(integerTourMap.size());
        Tour tour = integerTourMap.get(tourNumber);
        showMessage("Ok, you choose " + tour.getName() + " this tour better realize in cities ");
        tour.createCityAndSet();
        Map<Integer, City> cities = tour.getCities();
        showing.showCity(cities);
        int cityNumber = enterMessageForTour(cities.size());
        City city = cities.get(cityNumber);
        city.transportCreateAndSet();
        showMessage("You choose wonderful cities " + city.getName() + " for " + tour.getName() + "! Now chose transport.");
        Map<Integer, Transport> transportMap = city.getTransportMap();
        showing.showTransport(transportMap);
        int transportNumber = enterMessageForTour(transportMap.size());
        Transport transport = transportMap.get(transportNumber);
        showMessage("Great choose. What type of food you prefer?");
        Map<Integer, TypeFood> typeFoodMap = createTourAndTypeFood.creationTypeFood();
        showing.showTypeFood(typeFoodMap);
        int typeFoodNumber = enterMessageForTour(typeFoodMap.size());
        TypeFood typeFood = typeFoodMap.get(typeFoodNumber);
        showMessage("Ok, and how days you want rest?");
        int i = enterMessageForTour(50);
        Tour build = tour.newBuilder().setDay(i).setTypeFood(typeFood).setCity(city).setTransport(transport).build();
        showMessage("And total tour while cost");
        double v = new CalculatePrice(build).calculateTour();
        showMessage(String.valueOf(v));
    }


}
