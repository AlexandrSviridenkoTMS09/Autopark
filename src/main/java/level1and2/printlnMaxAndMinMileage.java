package level1and2;

import static level1and2.Main2.findMaxMileageVehicle;
import static level1and2.Main2.findMinMileageVehicle;

public class printlnMaxAndMinMileage {
    public static void printlnMaxAndMinMileage(Vehicle[] vehicle){
        System.out.println("\nMax mileage car: ");
        System.out.println(findMaxMileageVehicle(vehicle));

        System.out.println("\nMin mileage car: ");
        System.out.println(findMinMileageVehicle(vehicle));
    }
}
