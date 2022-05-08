package level4;

public class GasolineEngine extends CombustionEngine {
    public GasolineEngine(double engineCapacity, double fuelTankCapacity, double fuelConsuptionPer100) {
        super("Gasoline", 1.1, engineCapacity, fuelTankCapacity, fuelConsuptionPer100);
    }
    @Override
    public String toString() {
        return "Gasoline";
    }
}
