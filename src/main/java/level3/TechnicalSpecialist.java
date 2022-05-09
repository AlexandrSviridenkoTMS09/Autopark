package level3;

import level1and2.Color;
import level1and2.Vehicle;
import level1and2.VehicleType;
import level4.DieselEngine;
import level4.ElectricalEngine;
import level4.GasolineEngine;

public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;

    static public boolean validateManufactureYear(int manufactureYear){
        if(manufactureYear>=LOWER_LIMIT_MANUFACTURE_YEAR && (manufactureYear-1000 >=0 && manufactureYear-9999 <= 0)){
            return true;
        }
        else{
            return false;
        }
    }
    static public boolean validateMileage(int mileage){
        if(mileage >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    static public boolean validateWeight(int weight){

        if(weight >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    static public boolean validateColor (Color color){
        if(color != null){
            return true;
        }
        else{
            return false;
        }
    }

    static public boolean validateVehicleType(VehicleType type){
        VehicleType vehicleType = new VehicleType();
        if(vehicleType.getName() != null){
            return true;
        }
        else{
            return false;
        }
    }

    static public boolean validateRegistrationNumber(String registrationNumber){
        Vehicle vehicle = new Vehicle();
        if (vehicle.getRegistrationNumber() == null || vehicle.getRegistrationNumber().length() != 9) {
            return false;
        }

        char[] chars = vehicle.getRegistrationNumber().toCharArray();

        for (int i = 0; i < 4; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }

        if (chars[4] != ' ') {
            return false;
        }

        for (int i = 5; i < 7; i++) {
            if (chars[i] < 'A' || chars[i] > 'Z') {
                return false;
            }
        }

        if (chars[7] != '-') {
            return false;
        }

        return chars[8] >= '0' && chars[8] <= '9';
    }

    static public boolean validateModelName(String name){
        Vehicle vehicle = new Vehicle();
        if(vehicle.getModelName() != null){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean validateGasolineEngine(GasolineEngine engine) {
        if (engine == null) {
            return false;
        }
        return engine.getEngineCapacity() > 0 && engine.getFuelTankCapacity() > 0 && engine.getFuelConsuptionPer100() > 0;
    }

    public static boolean validateDieselEngine(DieselEngine engine) {
        if (engine == null) {
            return false;
        }

        return engine.getEngineCapacity() > 0 && engine.getFuelTankCapacity() > 0 && engine.getFuelConsuptionPer100() > 0;
    }

    public static boolean validateElectricalEngine(ElectricalEngine engine) {
        if (engine == null) {
            return false;
        }

        return engine.getBatterySize() > 0 && engine.getElectricityConsumption() > 0;
    }
}
