package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> listOfCars = new ArrayList<>();

        Car car = new Car("Opel",TypeOfFuel.BENZIN,55,Color.DARKBLUE,true);

        listOfCars.add(car);
    }
}
