package org.courses.tour.utils.selectionLogic;

import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.typeTours.Tour;

import java.util.Map;

public interface CreationTourAndTypeOfFood {
    Map<Integer, Tour> creationTourMap();

    Map<Integer, TypeFood> creationTypeFood();
}
