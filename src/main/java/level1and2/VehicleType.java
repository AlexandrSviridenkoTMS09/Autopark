package level1and2;

public class VehicleType {

    String typeName;
    double taxCoefficient;

    public VehicleType(String typeName, double taxCoefficient) {
        this.typeName = typeName;
        this.taxCoefficient = taxCoefficient;
    }

    public VehicleType() {
    }

    public String getName() {
        return typeName;
    }

    public double getTax() {
        return taxCoefficient;
    }

    public void setName(String typeName) {
        this.typeName = typeName;
    }

    public void setTax(double taxCoefficient) {
        this.taxCoefficient = taxCoefficient;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return typeName + "," + taxCoefficient;
    }

    public String getString() {
        return this.typeName + "," + this.taxCoefficient;
    }


}
