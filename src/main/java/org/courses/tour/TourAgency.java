package org.courses.tour;

import org.apache.log4j.Logger;
import org.courses.tour.city.City;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.service.*;
import org.courses.tour.transport.Transport;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.ConsoleComunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

@SpringBootApplication
public class TourAgency implements CommandLineRunner {
    private static final Logger LOG = Logger.getLogger(TourAgency.class);
    @Autowired
    AskForTourService askForTourService;
    @Autowired
    AskForCityService askForCityService;
    @Autowired
    AskForTransportService askForTransport;
    @Autowired
    AskForFoodService askForFoodService;
    @Autowired
    AskForDayService askForDayService;
    @Autowired
    CalculateService calculateService;

    public static void main(String[] args) {
        LOG.info("Start application");
        SpringApplication.run(TourAgency.class, args);
        LOG.info("Finish application");

    }

    @Override
    public void run(String... args) {
        Tour tour = askForTourService.askForTour();
        City city = askForCityService.askForCity(tour);
        Transport transport = askForTransport.askForTransport(city);
        FoodType foodType = askForFoodService.askForFood();
        int day = askForDayService.askForDay();
        Tour build = tour.newBuilder().setDay(day).setTypeFood(foodType).setCity(city).setTransport(transport).build();
        showMessage(String.valueOf(build));
        new CalculateService().calculate(build);
        ConsoleComunication.close();
    }
}
