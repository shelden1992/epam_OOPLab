package org.courses.tour.entity;

public class Food_type {
    private int idFoodType;
    private String name;
    private double coeficient;

    public Food_type(int idFoodType, String name, double coeficient) {
        this.idFoodType = idFoodType;
        this.name = name;
        this.coeficient = coeficient;
    }

    public int getIdFoodType() {
        return idFoodType;
    }

    public void setIdFoodType(int idFoodType) {
        this.idFoodType = idFoodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
}
