package com.Autopark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static com.Autopark.TechnicalSpecialist.*;

public class Vehicle {
    private VehicleType type;
    private String modelName;
    private String registrationNumber;
    private int weight;
    private int manufactureYear;
    private int mileage;
    private Color color;
    private int volumeTank;

    public Vehicle(VehicleType type, String modelName, String registrationNumber, int weight, int manufactureYear,
                   int mileage, Color color, int volumeTank) {
        if (!validateVehicleType(type)) {
            this.type = null;
        } else {
            this.type = type;
        }
        if (!validateModelName(modelName)) {
            this.modelName = null;
        } else {
            this.modelName = modelName;
        }
        if (!validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = null;
        } else {
            this.registrationNumber = registrationNumber;
        }

        if (validateWeight(weight)) {
            if (validateWeight(weight)) {
                this.weight = weight;
            } else {
                this.weight = 0;
            }
        }
        if (validateManufactureYear(manufactureYear)) {
            if (validateManufactureYear(manufactureYear)) {
                this.manufactureYear = manufactureYear;
            } else {
                this.manufactureYear = 0;
            }
        }

        if (validateMileage(mileage)) {
            if (validateMileage(mileage)) {
                this.mileage = mileage;
            } else {
                this.mileage = 0;
            }
        }
        if (validateColor(color)) {
            if (validateColor(color)) {
                this.color = color;
            } else {
                this.color = null;
            }
        }
        this.volumeTank = volumeTank;
    }


    public Vehicle() {
    }

    public VehicleType getType() {
        return type;
    }

    public String getModelName() {
        return modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVolumeTank() {
        return volumeTank;
    }

    public void setVolumeTank(int volumeTank) {
        this.volumeTank = volumeTank;
    }

    public double getCalcTaxPerMonth() {
        VehicleType vehicleType = new VehicleType();
        double GetCalcTaxPerMonth = getWeight() * 0.0013 + vehicleType.taxCoefficient * 30 + 5;
        return new BigDecimal(GetCalcTaxPerMonth).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    @Override
    public String toString() {
        return type + "," + modelName + "," + registrationNumber + "," + weight + "," + manufactureYear + ","
                + mileage + "," + color + "," + volumeTank + "," + getCalcTaxPerMonth();

    }

    public int compareTo(Vehicle obj) {
        if (manufactureYear > obj.manufactureYear) {
            return 1;
        } else if (manufactureYear < obj.manufactureYear) {
            return -1;
        } else {
            if (mileage > obj.mileage) {
                return 1;
            } else if (mileage < obj.mileage) {
                return -1;
            }
        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return type.equals(vehicle.type) && modelName.equals(vehicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, modelName);
    }
}

