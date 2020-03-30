package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean wantToChangeSomething = true;
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        int performance = 0;
        String typeOfFuel = "";
        String color = "";
        String heatedSeats = "";
        Enum colorEnum = null;
        Enum typeOfFuelEnum = null;
        boolean hasItHeatedSeats = false;
        Car changedCar = null;
        String choice = "";

        ArrayList<Car> listOfCars = new ArrayList<>();

        Car car = new Car("Opel", TypeOfFuel.BENZIN, 55, Color.DARKBLUE, true);
        listOfCars.add(car);

        System.out.println(car.toString());

        while (wantToChangeSomething) {

            System.out.println("Do you want to change something? Write in your wish or x if you dont want a change.");
            System.out.println("Performance?");
            try {
                performance = scanInt.nextInt();
            }
            catch (InputMismatchException ex){
                performance = car.performance;
            }
            System.out.println("Type of Fuel?");
            typeOfFuel = scan.next();
            System.out.println("Color?");
            System.out.println(Color.DARKBLUE + " " + Color.LIGHTBLUE + " " + Color.MIDNIGHTBLACK + " " + Color.WOLFGREY);
            color = scan.next();
            System.out.println("Heated seats? (yes or no)");
            heatedSeats = scan.next();

            color.toLowerCase();
            switch (color) {
                case ("darkblue"):
                    colorEnum = Color.DARKBLUE;
                    break;
                case ("lightblue"):
                    colorEnum = Color.LIGHTBLUE;
                    break;
                case ("midnightblack"):
                    colorEnum = Color.MIDNIGHTBLACK;
                    break;
                case ("wolfgrey"):
                    colorEnum = Color.WOLFGREY;
                    break;
                case("x"): colorEnum = car.color; break;
                default:
                    System.out.println("Color not found");
                    break;
            }
            heatedSeats.toLowerCase();
            switch (heatedSeats) {
                case ("yes"):
                    hasItHeatedSeats = true;
                    break;
                case ("no"):
                    hasItHeatedSeats = false;
                    break;
                case("x"): hasItHeatedSeats = car.hasItHeatedSeats; break;
                default:
                    System.out.println("Answer not possible");
                    break;
            }
            typeOfFuel.toLowerCase();

            switch (typeOfFuel) {
                case ("diesel"):
                    typeOfFuelEnum = TypeOfFuel.DIESEL;
                    break;
                case ("benzin"):
                    typeOfFuelEnum = TypeOfFuel.BENZIN;
                    break;
                case ("electricity"):
                    typeOfFuelEnum = TypeOfFuel.ELECTRICITY;
                    break;
                case ("x"): typeOfFuelEnum = car.typeOfFuel; break;
                default:
                    System.out.println("Please choose again. A failure occured.");
                    break;
            }

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
            if(choice.equalsIgnoreCase("yes")){
                wantToChangeSomething = false;
                System.out.println("Danke für Ihre Bestellung.");
            }

        }
        listOfCars.add(changedCar);
    }
}
