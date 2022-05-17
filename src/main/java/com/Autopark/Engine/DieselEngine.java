package com.Autopark.Engine;

public class DieselEngine extends CombustionEngine{
    public DieselEngine(double engineCapacity, double fuelTankCapacity, double fuelConsuptionPer100) {
        super("Diesel", 1.2, engineCapacity, fuelTankCapacity, fuelConsuptionPer100);
    }
    @Override
    public String toString() {
        return "Diesel";
    }
}
