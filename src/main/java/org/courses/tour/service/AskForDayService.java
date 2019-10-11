package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import static org.courses.tour.utils.ConsoleComunication.chooseDay;

@Service
public class AskForDayService {
    Logger LOG = Logger.getLogger(AskForDayService.class);


    public int askForDay() {
        int days = chooseDay();
        LOG.info("Choose days = " + days);
        return days;
    }
}
