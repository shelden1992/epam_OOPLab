package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.typeTours.Tour;
import org.courses.tour.utils.CalculatePrice;
import org.springframework.stereotype.Service;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

@Service
public class CalculateService {
    Logger LOG = Logger.getLogger(CalculateService.class);

    public double calculate(Tour tour) {
        showMessage("And total tour while cost");
        double totalPrice = new CalculatePrice(tour).calculateTour();
        showMessage(String.format(String.valueOf(totalPrice), "02.f"));
        LOG.info("Total price = " + totalPrice);
        return totalPrice;
    }
}
