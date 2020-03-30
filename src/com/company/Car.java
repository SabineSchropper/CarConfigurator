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
        this.hasItHeatedSeats = hasItHeatedSeats;
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    @Override
    public String toString() {
        return "Car: " +
                "brand='" + brand + '\'' +
                ", performance=" + performance +
                ", typeOfFuel=" + typeOfFuel +
                ", color=" + color +
                ", hasItHeatedSeats=" + hasItHeatedSeats +"\n";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public void setTypeOfFuel(Enum typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public void setColor(Enum color) {
        this.color = color;
    }

    public void setHasItHeatedSeats(boolean hasItHeatedSeats) {
        this.hasItHeatedSeats = hasItHeatedSeats;
    }
}
