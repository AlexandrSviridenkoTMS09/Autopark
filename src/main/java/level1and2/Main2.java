//package level1and2;
//
//public class Main2 {
//    public static final int SIZE_VEHICLES = 7;
//
//    public static void main(String[] args) {
//        Vehicle[] vehicle = initVehicle();
//        VehicleType[] as = initVehicleType();
//        Unsorted();
//        Sorted();
//        MaxMinAndEqual();
//    }
//
//    public static void MaxMinAndEqual() {
//        Vehicle[] vehicle = initVehicle();
//        System.out.println("\nMax mileage car: ");
//        System.out.println(findMaxMileageVehicle(vehicle));
//
//        System.out.println("\nMin mileage car: ");
//        System.out.println(findMinMileageVehicle(vehicle));
//
//        System.out.println("\nThe following vehicles are equal:");
//        displayEqual(vehicle);
//    }
//
//    public static void Unsorted() {
//        Vehicle[] vehicle = initVehicle();
//        System.out.println("Unsorted vehicles: ");
//        Helper.displayArr(vehicle);
//    }
//
//    public static void Sorted() {
//        Vehicle[] vehicle = initVehicle();
//        for (int i = 0; i < SIZE_VEHICLES; i++) {
//            for (int j = 0; j < SIZE_VEHICLES - 1; j++) {
//                if (vehicle[j].compareTo(vehicle[j + 1]) > 0) {
//
//                    Vehicle temp = vehicle[j + 1];
//                    vehicle[j + 1] = vehicle[j];
//                    vehicle[j] = temp;
//                }
//            }
//        }
//        System.out.println("\nSorted vehicles: ");
//        Helper.displayArr(vehicle);
//    }
//
//    public static VehicleType[] initVehicleType() {
//        VehicleType[] as = new VehicleType[4];
//        as[0] = new VehicleType("Bus", 1.2);
//        as[1] = new VehicleType("Car", 1);
//        as[2] = new VehicleType("Rink", 1.5);
//        as[3] = new VehicleType("Tractor", 1.2);
//
//        return as;
//    }
//
//    public static Vehicle[] initVehicle() {
//        VehicleType[] as = initVehicleType();
//        Vehicle[] vehicle = new Vehicle[7];
//        vehicle[0] = new Vehicle(as[0], "Volkswagen Crafter", "5427 AX-7", 2022,
//                2015, 376000, Color.BLUE, 75);
//        vehicle[1] = new Vehicle(as[0], "Volkswagen Crafter", "6427 AA-7", 2500,
//                2014, 227010, Color.WHITE, 75);
//        vehicle[2] = new Vehicle(as[0], "ElectricBus", "6785 ВA-7", 12080,
//                2019, 20451, Color.GREEN, 100);
//        vehicle[3] = new Vehicle(as[0], "Golf 5", "8682 AX-7", 1200,
//                2006, 230451, Color.GRAY, 55);
//        vehicle[4] = new Vehicle(as[0], "TestaModel S70D", "0001 AA-7", 2200,
//                2019, 10454, Color.WHITE, 70);
//        vehicle[5] = new Vehicle(as[2], "Hamm HD", null, 3000,
//                2016, 122, Color.YELLOW, 135);
//        vehicle[6] = new Vehicle(as[3], "MT3", "1145 AB-7", 1200,
//                2020, 109, Color.RED, 130);
//        return vehicle;
//    }
//
//    public static Vehicle findMinMileageVehicle(Vehicle[] vehicles) {
//        int minMileage;
//        Vehicle minMileageVehicle;
//
//        minMileageVehicle = vehicles[0];
//        minMileage = vehicles[0].getMileage();
//
//        for (int i = 0; i < SIZE_VEHICLES; i++) {
//
//            int mileage = vehicles[i].getMileage();
//
//            if (mileage < minMileage) {
//                minMileage = mileage;
//                minMileageVehicle = vehicles[i];
//            }
//        }
//
//        return minMileageVehicle;
//    }
//
//    public static Vehicle findMaxMileageVehicle(Vehicle[] vehicles) {
//        int maxMileage;
//        Vehicle maxMileageVehicle;
//
//        maxMileageVehicle = vehicles[0];
//        maxMileage = vehicles[0].getMileage();
//
//        for (int i = 0; i < SIZE_VEHICLES; i++) {
//
//            int mileage = vehicles[i].getMileage();
//
//            if (mileage > maxMileage) {
//                maxMileage = mileage;
//                maxMileageVehicle = vehicles[i];
//            }
//        }
//
//        return maxMileageVehicle;
//    }
//
//
//    public static void displayEqual(Vehicle[] vehicles) {
//        int counter = 0;
//
//        for (int i = 0; i < SIZE_VEHICLES; i++) {
//
//            for (int j = i + 1; j < SIZE_VEHICLES; j++) {
//
//                if (vehicles[i].equals(vehicles[j])) {
//                    counter++;
//                    System.out.println(vehicles[i] + " and " + vehicles[j]);
//                }
//            }
//        }
//
//        if (counter == 0) {
//            System.out.println("Neither of vehicles are equal");
//        }
//    }
//
//
//    public static class Helper {
//        public static <T> void displayArr(T[] elements) {
//            for (T element :
//                    elements) {
//                System.out.println(element.toString());
//            }
//            System.out.println();
//        }
//    }
//}
