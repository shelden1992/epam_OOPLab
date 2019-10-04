package org.courses.tour.service;

import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.CalculatePrice;
import org.courses.tour.utils.ConsoleComunication;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class CalculateService {
    public double calculate(Tour tour) {
        showMessage("And total tour while cost");
        double v = new CalculatePrice(tour).calculateTour();
        showMessage(String.format( String.valueOf( v),"02.f"));
        return v;
    }
}
