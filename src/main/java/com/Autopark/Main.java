package com.Autopark;

import com.Autopark.Engine.DieselEngine;
import com.Autopark.Engine.ElectricalEngine;
import com.Autopark.Engine.GasolineEngine;

import java.util.Arrays;
import java.util.Collections;

import static com.Autopark.utils.VehicleUtils.*;

public class Main {

    public static final String TYPES_PATH = "src/main/java/com/Autopark/File.csv/types.csv";
    public static final String VEHICLES_PATH = "src/main/java/com/Autopark/File.csv/vehicles.csv";
    public static final String RENTS_PATH = "src/main/java/com/Autopark/File.csv/rents.csv";

    public static void main(String[] args) {

        VehicleCollection vehCollection = new VehicleCollection(TYPES_PATH, VEHICLES_PATH, RENTS_PATH);
        vehCollection.display();

        vehCollection.sortCollection();
        vehCollection.display();

        MyQueue<Vehicle> queue = new MyQueue<>();
        addCarInQueue(vehCollection, queue);
        washVehicles(queue);

        MyStack<Vehicle> stack = new MyStack<>();
        addCarInGarage(vehCollection, stack);
        goToTheGarage(vehCollection, stack);

        goInMechanicService(vehCollection);
        printMaxCarBroken(vehCollection);
        CarTroubleshootingAndRepair(vehCollection);
        printServiceableCars(vehCollection);
        giveInRent(vehCollection);

    }
}