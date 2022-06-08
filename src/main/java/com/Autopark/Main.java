package com.Autopark;

import com.Autopark.Engine.DieselEngine;
import com.Autopark.Engine.ElectricalEngine;
import com.Autopark.Engine.GasolineEngine;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static final String TYPES_PATH = "src/main/java/com/Autopark/File.csv/types.csv";
    public static final String VEHICLES_PATH = "src/main/java/com/Autopark/File.csv/vehicles.csv";
    public static final String RENTS_PATH = "src/main/java/com/Autopark/File.csv/rents.csv";

    public static void main(String[] args) {
        VehicleCollection vehCollection = new VehicleCollection(TYPES_PATH, VEHICLES_PATH, RENTS_PATH);
        vehCollection.display();

        vehCollection.insert(new Vehicle(8, vehCollection.getVehicleTypes().get(2), new DieselEngine(1.6, 7.2, 55), "Opel", "6427 AA-7", 2500, 1990, 345200, Color.BLACK));
        vehCollection.delete(1);
        vehCollection.delete(4);
        vehCollection.display();

        vehCollection.sortCollection();
        vehCollection.display();
    }




}

