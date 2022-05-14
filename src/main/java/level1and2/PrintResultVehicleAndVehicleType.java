package level1and2;

import static level1and2.Main.*;

public class PrintResultVehicleAndVehicleType {
    public static final int SIZE_VEHICLES = 7;

    public static void printlnEqualVehicleType(Vehicle[] vehicle){
        System.out.println("\nThe following vehicles are equal:");
        displayEqual(vehicle);
    }

    public static void printlnGetStringVehicleType(VehicleType[] as) {
        for (VehicleType a : as
        ) {
            System.out.println(a.getString());
        }
    }

    public static void printlnMaxAndMinMileage(Vehicle[] vehicle){
        System.out.println("\nMax mileage car: ");
        System.out.println(findMaxMileageVehicle(vehicle));

        System.out.println("\nMin mileage car: ");
        System.out.println(findMinMileageVehicle(vehicle));
    }

    public static void printlnMaxTax(VehicleType[] vehicleTypes){
        System.out.println("maxTax = " + calculationMaxTax(vehicleTypes) + "\n" + "average = " + calculationAverage(vehicleTypes));
    }

    public static void printlnSortedVehicleType(Vehicle[] vehicle) {
        for (int i = 0; i < SIZE_VEHICLES; i++) {
            for (int j = 0; j < SIZE_VEHICLES - 1; j++) {
                if (vehicle[j].compareTo(vehicle[j + 1]) > 0) {

                    Vehicle temp = vehicle[j + 1];
                    vehicle[j + 1] = vehicle[j];
                    vehicle[j] = temp;
                }
            }
        }
        System.out.println("\nSorted vehicles: ");
        Main.Helper.displayArr(vehicle);}

    public static void printUnsortedVehicleType(Vehicle[] vehicle) {
        System.out.println("Unsorted vehicles: ");
        Main.Helper.displayArr(vehicle);
    }

    public static void printlnVehicleType(VehicleType[] as) {
        for (VehicleType a : as
        ) {
            a.display();
        }
    }
}

