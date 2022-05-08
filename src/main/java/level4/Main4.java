package level4;

import level1and2.Color;
import level1and2.Vehicle;
import level1and2.VehicleType;
import static level4.Main4.Helper.displayArr;

public class Main4 {
    private static final int SIZE_VEHICLES = 7;

    public static void main(String[] args) {
        Vehicle[] vehicle = initVehicle();
        VehicleType[] as = initVehicleType();
        displayArr(vehicle);
        displayEqual(vehicle);
        autoMaxKilometrs(vehicle);
    }

    public static VehicleType[] initVehicleType() {
        VehicleType[] as = new VehicleType[4];
        as[0] = new VehicleType("Bus", 1.2);
        as[1] = new VehicleType("Car", 1);
        as[2] = new VehicleType("Rink", 1.5);
        as[3] = new VehicleType("Tractor", 1.2);
        return as;
    }

    public static Vehicle[] initVehicle() {
        VehicleType[] as = initVehicleType();

        Vehicle[] vehicle = new Vehicle[7];
        vehicle[0] = new Vehicle(as[0], "Volkswagen Crafter", "5427 AX-7", 2022,
                2015, 376000, Color.BLUE, 75,new GasolineEngine(2, 8.1, 75));
        vehicle[1] = new Vehicle(as[0], "Volkswagen Crafter", "6427 AA-7", 2500,
                2014, 227010, Color.WHITE, 75,  new GasolineEngine(2.18, 8.5, 75));
        vehicle[2] = new Vehicle(as[0], "ElectricBus", "6785 ВA-7", 12080,
                2019, 20451, Color.GREEN, 100, new ElectricalEngine(50,150));
        vehicle[3] = new Vehicle(as[0], "Golf 5", "8682 AX-7", 1200,
                2006, 230451, Color.GRAY, 55, new DieselEngine(1.6, 7.2, 55));
        vehicle[4] = new Vehicle(as[0], "TestaModel S70D", "0001 AA-7", 2200,
                2019, 10454, Color.WHITE, 70, new ElectricalEngine(25, 70));
        vehicle[5] = new Vehicle(as[2], "Hamm HD", null, 3000,
                2016, 122, Color.YELLOW, 135, new DieselEngine(3.2, 25, 20));
        vehicle[6] = new Vehicle(as[3], "MT3", "1145 AB-7", 1200,
                2020, 109, Color.RED, 130, new DieselEngine(4.75, 20.1, 135));
        return vehicle;
    }

    public static class Helper {
        public static <T> void displayArr(T[] elements) {
            for (T element :
                    elements) {
                System.out.println(element.toString());
            }
            System.out.println();
        }
    }

    public static void displayEqual(Vehicle[] vehicles) {
        int counter = 0;

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            for (int j = i + 1; j < SIZE_VEHICLES; j++) {

                if (vehicles[i].equals(vehicles[j])) {
                    counter++;
                    System.out.println(vehicles[i] + " and " + vehicles[j]);
                }
            }
        }

        if (counter == 0) {
            System.out.println("Neither of vehicles are equal");
        }
    }


    public static void autoMaxKilometrs(Vehicle[] vehicle){
        double maxKilometers = 0.0;
        for (Vehicle as : vehicle) {
           double Kilometers = as.getEngine().getMaxKilometers();
            if( as.getEngine().getMaxKilometers() - maxKilometers > 0 )    {
            maxKilometers = as.getEngine().getMaxKilometers();
            }
        }

        System.out.println("maxKilometers = " + maxKilometers);

        for (Vehicle as : vehicle) {
            if(maxKilometers == as.getEngine().getMaxKilometers()){
                System.out.println(as);;
            }
        }

    }




}
