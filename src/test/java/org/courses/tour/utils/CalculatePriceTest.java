package org.courses.tour.utils;

import org.courses.tour.city.Budapest;
import org.courses.tour.otherParametrs.FoodType;
import org.courses.tour.transport.Bus;
import org.courses.tour.typeTours.CruiseTour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class CalculatePriceTest {
    CalculatePrice calculatePrice;
    CruiseTour tour;

    @Before
    public void setUp() {
        tour = new CruiseTour(FoodType.ROOM_ONLY, new Bus(100), 1000.0, null, 1, "", new Budapest());
        calculatePrice = new CalculatePrice(tour);
    }

    @Test
    public void shouldReturnValidResulrWhenPassValidTour() {
        double result = calculatePrice.calculateTour();
        assertEquals(1101.0 , result,0.0);
    }
}