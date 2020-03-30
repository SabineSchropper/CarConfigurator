package com.company;

public class Car implements Cloneable{
    String brand;
    int performance;
    Enum typeOfFuel;
    Enum color;
    boolean hasItHeatedSeats;

    public Car(String brand, Enum typeOfFuel, int performance, Enum color, boolean hasItHeatedSeats) {
        this.brand = brand;
        this.typeOfFuel = typeOfFuel;
        this.performance = performance;
        this.color = color;
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
