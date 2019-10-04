package org.courses.tour.utils.creationLogic;

import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.typeTours.*;
import org.courses.tour.utils.show.ShowingTour;
import org.courses.tour.utils.show.ShowingTypeFood;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class CreateTourAndTypeFoodImpl implements CreationTourAndTypeOfFood {


    @Override
    public Map<Integer, Tour> creationTourMap() {
        Map<Integer, Tour> integerTourMap = new HashMap<>();
        integerTourMap.put(1, new CruiseTour());
        integerTourMap.put(2, new ExcursionTour());
        integerTourMap.put(3, new RecreationTour());
        integerTourMap.put(4, new ShoppingTour());
        integerTourMap.put(5, new TreatmentTour());
        return integerTourMap;
    }

    @Override
    public Map<Integer, TypeFood> creationTypeFood() {
        Map<Integer, TypeFood> integerTypeFoodMap = new HashMap<>();
        integerTypeFoodMap.put(1, TypeFood.ALL_INCLUSIVE);
        integerTypeFoodMap.put(2, TypeFood.FULL_BOARD);
        integerTypeFoodMap.put(3, TypeFood.HALF_BOARD);
        integerTypeFoodMap.put(5, TypeFood.BED_AND_BREAKFAST);
        integerTypeFoodMap.put(4, TypeFood.ROOM_ONLY);
        return integerTypeFoodMap;
    }


}
