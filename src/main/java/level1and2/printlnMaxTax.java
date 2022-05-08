package level1and2;

import static level1and2.Main2.*;

public class printlnMaxTax {
    public static void printlnMaxTax(VehicleType[] vehicleTypes){
        System.out.println("maxTax = " + calculationMaxTax(vehicleTypes) + "\n" + "average = " + calculationAverage(vehicleTypes));
    }
}
