package com.Autopark;

import com.Autopark.Engine.DieselEngine;
import com.Autopark.Engine.ElectricalEngine;
import com.Autopark.Engine.GasolineEngine;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.Autopark.utils.VehicleUtils.*;

public class Main {

    public static final String TYPES_PATH = "src/main/java/com/Autopark/File.csv/types.csv";
    public static final String VEHICLES_PATH = "src/main/java/com/Autopark/File.csv/vehicles.csv";
    public static final String RENTS_PATH = "src/main/java/com/Autopark/File.csv/rents.csv";
    public static final String MESSAGE_VOLKSWAGEN = "The following vehicles are Volkswagen's:";
    public static final String MESSAGE_MAX_YEAR_VOLKSWAGEN = "The following vehicle is the oldest Volkswagen's:";

    public static void main(String[] args) {

        VehicleCollection vehCollection = new VehicleCollection(TYPES_PATH, VEHICLES_PATH, RENTS_PATH);
//        vehCollection.display();
//
//        vehCollection.sortCollection();
//        vehCollection.display();
//
//        MyQueue<Vehicle> queue = new MyQueue<>();
//        addCarInQueue(vehCollection, queue);
//        washVehicles(queue);
//
//        MyStack<Vehicle> stack = new MyStack<>();
//        addCarInGarage(vehCollection, stack);
//        goToTheGarage(vehCollection, stack);
//
//        goInMechanicService(vehCollection);
//        CarTroubleshootingAndRepair(vehCollection);
//        printServiceableCars(vehCollection);
//        giveInRent(vehCollection);
//        printMaxCarBroken(vehCollection);


        List<Vehicle> vehicles = vehCollection.getVehicles();
        List<Vehicle> brokenVehicles = vehCollection.getVehicles().stream()
                .filter(Vehicle::getBroken)
                .collect(Collectors.toList());
        printVehicles(brokenVehicles, "Broken Car:");

        ComparatorByDefectCount comparatorByDefectCount = new ComparatorByDefectCount();
        brokenVehicles = brokenVehicles.stream()
                .sorted(comparatorByDefectCount)
                .collect(Collectors.toList());
        printVehicles(brokenVehicles, "Sorted Broken Car:");

        ComparatorByTaxPerMonth comparatorByTaxPerMonth = new ComparatorByTaxPerMonth();
        Optional<Vehicle> max = vehCollection.getVehicles().stream().max(comparatorByTaxPerMonth);
        printCarWithMaxTax(max);

        List<Vehicle> listBroken = vehCollection.getVehicles().stream()
                .peek((vehicle) -> goInMechanicService(vehicle))
                .collect(Collectors.toList());

        List<Vehicle> carTroubleshootingAndRepair = vehCollection.getVehicles().stream()
                .peek((vehicle) -> CarTroubleshootingAndRepair(vehicle))
                .collect(Collectors.toList());
        printVehicles(carTroubleshootingAndRepair, "Service:");

        List<Vehicle> volkswagens = findVolkswagens(vehicles);
        printVehicles(volkswagens, MESSAGE_VOLKSWAGEN);

        Vehicle maxYearVolkswagen = findMaxYear(volkswagens);
        printVehicles(maxYearVolkswagen, MESSAGE_MAX_YEAR_VOLKSWAGEN);

        washVehicles(vehicles);
        goToGarage(vehicles);
    }

    private static void  printCarWithMaxTax(Optional<Vehicle> vehicle){
        System.out.println("Car with max tax per month:" + vehicle);
    }

    private static <T> Stream<T> reverse(Stream<T> stream) {
        LinkedList<T> stack = new LinkedList<>();
        stream.forEach(stack::push);

        return stack.stream();
    }

    private static void goToGarage(List<Vehicle> vehicles) {
        Stream<Vehicle> pushToGarage = reverse(vehicles.stream());
        pushToGarage.forEach(veh -> System.out.println(veh + " -- drove out from garage"));
    }

    private static void washVehicles(List<Vehicle> vehicles) {
        vehicles.stream().forEach(veh -> System.out.println(veh + "-- washed up"));
    }

    private static Vehicle findMaxYear(List<Vehicle> vehicles) {
        Optional<Vehicle> maxYear = vehicles.stream().max(Comparator.comparingInt(Vehicle::getManufactureYear));
        return maxYear.get();
    }

    private static void printVehicles(List<Vehicle> vehicles, String message) {
        System.out.println(message);
        vehicles.stream().forEach(System.out::println);
        System.out.println();
    }

    private static void printVehicles(Vehicle vehicle, String message) {
        System.out.println(message);
        System.out.println(vehicle + "\n");
    }

    private static List<Vehicle> findVolkswagens(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(car -> car.getModelName().contains("Volkswagen Crafter"))
                .collect(Collectors.toList());
    }
}