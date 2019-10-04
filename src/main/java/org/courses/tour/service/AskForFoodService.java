package org.courses.tour.service;

import org.courses.tour.otherParametrs.TypeFood;
import org.courses.tour.utils.creationLogic.CreateTourAndTypeFoodImpl;
import org.courses.tour.utils.show.ShowingEntityImpl;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

public class AskForFoodService {

    public TypeFood askForFood() {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        CreateTourAndTypeFoodImpl createTourAndTypeFood = new CreateTourAndTypeFoodImpl();
        Map<Integer, TypeFood> typeFoodMap = createTourAndTypeFood.creationTypeFood();
        showing.showTypeFood(typeFoodMap);
        int typeFoodNumber = chooseSomeEntity(typeFoodMap.size());
        TypeFood typeFood = typeFoodMap.get(typeFoodNumber);
        showMessage("Ok, and how days you want rest?");
        return typeFood;
    }
}
