package org.courses.tour.utils.creationLogic;

import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.typeTours.Tour;

import java.util.Map;

public interface CreationTourAndTypeOfFood {
    Map<Integer, Tour> creationTourMap();

    Map<Integer, FoodType> creationTypeFood();
}
