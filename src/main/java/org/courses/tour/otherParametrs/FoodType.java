package org.courses.tour.otherParametrs;

public enum FoodType {
    ALL_INCLUSIVE(0.30), ROOM_ONLY(0.0), BED_AND_BREAKFAST(0.10), HALF_BOARD(0.15), FULL_BOARD(0.20),
    ;

    private double priceСoefficient;

    FoodType(double priceСoefficient) {
        this.priceСoefficient = priceСoefficient;
    }

    public double getPriceСoefficient() {
        return priceСoefficient;
    }
}
