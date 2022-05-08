package level1and2;

public class printlnSortedVehicleType {
    public static final int SIZE_VEHICLES = 7;
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
        Main2.Helper.displayArr(vehicle);}
}
