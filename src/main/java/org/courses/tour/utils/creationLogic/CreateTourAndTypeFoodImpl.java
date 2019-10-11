package org.courses.tour.utils.creationLogic;

import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.typeTours.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Resource
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
    public Map<Integer, FoodType> creationTypeFood() {
        Map<Integer, FoodType> integerTypeFoodMap = new HashMap<>();
        integerTypeFoodMap.put(1, FoodType.ALL_INCLUSIVE);
        integerTypeFoodMap.put(2, FoodType.FULL_BOARD);
        integerTypeFoodMap.put(3, FoodType.HALF_BOARD);
        integerTypeFoodMap.put(5, FoodType.BED_AND_BREAKFAST);
        integerTypeFoodMap.put(4, FoodType.ROOM_ONLY);
        return integerTypeFoodMap;
    }


}
