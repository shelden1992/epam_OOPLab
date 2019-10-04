package org.courses.tour.otherParametrs;

public enum TypeFood {
    ALL_INCLUSIVE(0.30), ROOM_ONLY(0.0), BED_AND_BREAKFAST(0.10), HALF_BOARD(0.15), FULL_BOARD(0.20),
    ;

    private double priceСoefficient;

    TypeFood(double priceСoefficient) {
        this.priceСoefficient = priceСoefficient;
    }

    public double getPriceСoefficient() {
        return priceСoefficient;
    }
}
