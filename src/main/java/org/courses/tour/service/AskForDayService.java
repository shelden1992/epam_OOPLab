package org.courses.tour.service;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;

public class AskForDayService {
    private static final int MAX_DAYS = 100;

    public int askForDay() {
        return chooseSomeEntity(MAX_DAYS);
    }
}
