package org.courses.tour.service;

import org.apache.log4j.Logger;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.utils.creationLogic.CreateTourAndTypeFoodImpl;
import org.courses.tour.utils.show.ShowingEntityImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.courses.tour.utils.ConsoleComunication.chooseSomeEntity;
import static org.courses.tour.utils.ConsoleComunication.showMessage;

@Service
public class AskForFoodService {
    private static final Logger LOG = Logger.getLogger(AskForFoodService.class);

    public FoodType askForFood() {
        ShowingEntityImpl showing = new ShowingEntityImpl();
        CreateTourAndTypeFoodImpl createTourAndTypeFood = new CreateTourAndTypeFoodImpl();
        Map<Integer, FoodType> typeFoodMap = createTourAndTypeFood.creationTypeFood();
        showing.showTypeFood(typeFoodMap);
        int typeFoodNumber = chooseSomeEntity(typeFoodMap.size());
        FoodType foodType = typeFoodMap.get(typeFoodNumber);
        LOG.info("Choose FoodType = " + foodType);
        showMessage("Ok, and how days you want rest?");
        return foodType;
    }
}
