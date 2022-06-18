package com.Autopark.utils;

import com.Autopark.*;


public class VehicleUtils {
    public static void changeTaxCoefficient(VehicleType[] as) {
        for (VehicleType a : as) {
            if (a.getName().equals("Tractor")) {
                a.setTax(1.3);
            }
        }
    }

    public static double calculationMaxTax(VehicleType[] as) {
        double maxTax = 0;
        for (VehicleType a : as) {
            if (a.getTax() > maxTax)
                maxTax = a.getTax();
        }
        return maxTax;
    }

    public static double calculationAverage(VehicleType[] as) {
        double sumTax = 0;
        for (VehicleType a : as) {
            sumTax = sumTax + a.getTax();
        }
        double average = sumTax / 4;
        return average;
    }

    public static Vehicle findMinMileageVehicle(Vehicle[] vehicles) {
        int minMileage;
        Vehicle minMileageVehicle;
        minMileageVehicle = vehicles[0];
        minMileage = vehicles[0].getMileage();
        for (int i = 0; i < SIZE_VEHICLES; i++) {
            int mileage = vehicles[i].getMileage();
            if (mileage < minMileage) {
                minMileage = mileage;
                minMileageVehicle = vehicles[i];
            }
        }
        return minMileageVehicle;
    }

    public static Vehicle findMaxMileageVehicle(Vehicle[] vehicles) {
        int maxMileage;
        Vehicle maxMileageVehicle;
        maxMileageVehicle = vehicles[0];
        maxMileage = vehicles[0].getMileage();
        for (int i = 0; i < SIZE_VEHICLES; i++) {
            int mileage = vehicles[i].getMileage();
            if (mileage > maxMileage) {
                maxMileage = mileage;
                maxMileageVehicle = vehicles[i];
            }
        }
        return maxMileageVehicle;
    }

    public static <T> void displayArr(T[] elements) {
        for (T element :
                elements) {
            System.out.println(element.toString());
        }
        System.out.println();
    }

    public static void autoMaxKilometrs(Vehicle[] vehicle) {
        double maxKilometers = 0.0;
        for (Vehicle as : vehicle) {
            if (as.getEngine().getMaxKilometers() - maxKilometers > 0) {
                maxKilometers = as.getEngine().getMaxKilometers();
            }
        }

        for (Vehicle as : vehicle) {
            if (maxKilometers == as.getEngine().getMaxKilometers()) {
                System.out.println(as);
            }
        }
    }

    public static final int SIZE_VEHICLES = 7;

    public static void washVehicles(VehicleCollection vehCollection, MyQueue<Vehicle> queue) {
        int size;

        for (Vehicle vehicle : vehCollection.getVehicles()) {
            queue.enqueue(vehicle);
        }

        size = queue.size();

        for (int i = 0; i < size; i++) {
            System.out.println(queue.dequeue() + " -- is washed up");
        }
    }

    public static void goToTheGarage(VehicleCollection vehCollection, MyStack<Vehicle> stack) {
        int size;

        for (Vehicle vehicle : vehCollection.getVehicles()) {
            stack.push(vehicle);
            System.out.println(stack.peek() + " -- has driven in");
        }

        System.out.println("Garage is fulled\n");
        size = stack.size();

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop() + " -- has driven out");
        }
    }
}
