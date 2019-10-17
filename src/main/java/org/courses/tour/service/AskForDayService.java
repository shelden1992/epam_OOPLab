package org.courses.tour.service;

import org.apache.log4j.Logger;

import static org.courses.tour.utils.ConsoleComunication.chooseDay;

public class AskForDayService {
    private static final Logger LOG = Logger.getLogger(AskForCityService.class);

    public int askForDay() {

        int days = chooseDay();
        LOG.info("Choose days = " + days);
        return days;
    }
}
