package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean wantToChangeSomething = true;
        Scanner scan = new Scanner(System.in);
        Scanner scanInt;
        int performance;
        Enum colorEnum;
        Enum typeOfFuelEnum;
        boolean hasItHeatedSeats;
        Car changedCar = null;
        String choice;

        ArrayList<Car> listOfCars = new ArrayList<>();

        Car car = new Car("Opel", TypeOfFuel.BENZIN, 55, Color.DARKBLUE, true);
        listOfCars.add(car);

        System.out.println(car.toString());

        while (wantToChangeSomething) {

            System.out.println("Do you want to change something? Write in your wish or x if you dont want a change.");
            System.out.println("Performance?");
            try {
                scanInt =  new Scanner(System.in);
                performance = scanInt.nextInt();
            } catch (InputMismatchException ex) {
                performance = car.performance;
            }
            System.out.println("Type of Fuel?");
            typeOfFuelEnum = chooseTypeOfFuel(scan, car);

            System.out.println("Color?");
            System.out.println(Color.DARKBLUE + " " + Color.LIGHTBLUE + " " + Color.MIDNIGHTBLACK + " " + Color.WOLFGREY);
            colorEnum = chooseColor(scan,car);

            System.out.println("Heated seats? (yes or no)");
            hasItHeatedSeats = chooseIfHeatedSeats(scan, car);

        try {
            changedCar = car.clone();
            changedCar.setPerformance(performance);
            changedCar.setColor(colorEnum);
            changedCar.setHasItHeatedSeats(hasItHeatedSeats);
            changedCar.setTypeOfFuel(typeOfFuelEnum);
        } catch (CloneNotSupportedException ex) {
            ex.fillInStackTrace();
        }

        System.out.println(changedCar.toString());

        System.out.println("Do you want to order this car? (yes or no)");
        choice = scan.next();
        if (choice.equalsIgnoreCase("yes")) {
            wantToChangeSomething = false;
            System.out.println("Danke für Ihre Bestellung.");
        }

    }
        listOfCars.add(changedCar);
}
    public static Enum chooseColor(Scanner scan, Car car) {
        String color = scan.next();
        switch (color.toLowerCase()) {
            case ("darkblue"):
                return Color.DARKBLUE;
            case ("lightblue"):
                return Color.LIGHTBLUE;
            case ("midnightblack"):
                return Color.MIDNIGHTBLACK;
            case ("wolfgrey"):
                return Color.WOLFGREY;
            case ("x"):
            default:
                System.out.println("Default value is set.");
                return car.color;
        }
    }
    public static boolean chooseIfHeatedSeats(Scanner scan, Car car) {
        String heatedSeats = scan.next();
        switch (heatedSeats.toLowerCase()) {
            case ("yes"):
                return true;
            case ("no"):
                return false;
            case ("x"):
            default:
                System.out.println("Default value is set.");
                return car.hasItHeatedSeats;
        }
    }
    public static Enum chooseTypeOfFuel(Scanner scan, Car car) {
        String typeOfFuel = scan.next();

        switch (typeOfFuel.toLowerCase()) {
            case ("diesel"):
                return TypeOfFuel.DIESEL;
            case ("benzin"):
                return TypeOfFuel.BENZIN;
            case ("electricity"):
                return TypeOfFuel.ELECTRICITY;
            case ("x"):
            default:
                System.out.println("Default value is set.");
                return car.typeOfFuel;
        }
    }
}
