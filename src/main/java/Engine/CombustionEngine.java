package Engine;

public class CombustionEngine extends AbstractEngine {
    double engineCapacity;
    double fuelTankCapacity;
    double fuelConsuptionPer100;

    public CombustionEngine(String nameTypeEngine, double engineTaxCoefficient, double engineCapacity, double fuelTankCapacity, double fuelConsuptionPer100) {
        super(nameTypeEngine, engineTaxCoefficient);
        this.engineCapacity = engineCapacity;
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelConsuptionPer100 = fuelConsuptionPer100;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getFuelConsuptionPer100() {
        return fuelConsuptionPer100;
    }

    public void setFuelConsuptionPer100(double fuelConsuptionPer100) {
        this.fuelConsuptionPer100 = fuelConsuptionPer100;
    }

    @Override
    public double getTaxPerMonth() {
        return getEngineTaxCoefficient();
    }

    @Override
    public double getMaxKilometers() {
        return fuelTankCapacity*100/fuelConsuptionPer100;
    }
}
