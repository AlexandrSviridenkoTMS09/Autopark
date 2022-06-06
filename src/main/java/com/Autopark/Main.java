package com.Autopark;

import com.Autopark.Engine.DieselEngine;
import com.Autopark.Engine.ElectricalEngine;
import com.Autopark.Engine.GasolineEngine;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static final String TYPES_PATH = "src/main/java/com/Autopark/File.csv/";
    public static final String VEHICLES_PATH = "src/main/java/com/Autopark/File.csv/";
    public static final String RENTS_PATH = "src/main/java/com/Autopark/File.csv/";

    public static void main(String[] args) {
        VehicleCollection vehCollection = loadInfo();
        vehCollection.display();

        vehCollection.insert(8, new Vehicle(8, new VehicleType("Car", 1, 2), new DieselEngine(1.6, 7.2, 55), "Opel", "6427 AA-7", 2500, 1990, 345200, Color.BLACK));
        vehCollection.delete(1);
        vehCollection.delete(4);
        vehCollection.display();

        vehCollection.sortCollection();
        vehCollection.display();
    }

    public static VehicleCollection loadInfo() {
        VehicleCollection vehicleCollection = new VehicleCollection("types.csv", "vehicles.csv", "rents.csv");

        vehicleCollection.loadTypes(TYPES_PATH);
        vehicleCollection.loadVehicles(VEHICLES_PATH);
        vehicleCollection.loadRents(RENTS_PATH);

        return vehicleCollection;
    }


}

