package level1and2;

public class Main {
    public static void main(String[] args) {
        VehicleType[] as = initVehicleType();
        for (VehicleType a : as
        ) {
            a.display();
        }
        for (VehicleType a : as
        ) {
            System.out.println(a.getString());
        }
        for (VehicleType a : as) {
            if (a.typeName.equals("tractor")) {
                a.taxCoefficient = 1.3;
            }
        }
        double maxTax = 0;
        double sumTax = 0;
        for (VehicleType a : as) {
            sumTax = sumTax + a.taxCoefficient;
            if (a.taxCoefficient > maxTax)
                maxTax = a.taxCoefficient;
        }
        double average = sumTax / 4;
        System.out.println("maxTax = " + maxTax + "\n" + "average = " + average);

    }


    public static VehicleType[] initVehicleType() {
        VehicleType[] as = new VehicleType[4];
        as[0] = new VehicleType("Bus", 1.2);
        as[1] = new VehicleType("Car", 1);
        as[2] = new VehicleType("Rink", 1.5);
        as[3] = new VehicleType("Tractor", 1.2);
        return as;
    }
}
