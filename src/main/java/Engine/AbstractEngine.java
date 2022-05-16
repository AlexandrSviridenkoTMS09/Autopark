package Engine;

public abstract class AbstractEngine implements Startable {
    String nameTypeEngine;
    double engineTaxCoefficient;

    public AbstractEngine(String nameTypeEngine, double engineTaxCoefficient) {
        this.nameTypeEngine = nameTypeEngine;
        this.engineTaxCoefficient = engineTaxCoefficient;
    }

    public String getNameTypeEngine() {
        return nameTypeEngine;
    }

    public void setNameTypeEngine(String nameTypeEngine) {
        this.nameTypeEngine = nameTypeEngine;
    }

    public double getEngineTaxCoefficient() {
        return engineTaxCoefficient;
    }

    public void setEngineTaxCoefficient(double engineTaxCoefficient) {
        this.engineTaxCoefficient = engineTaxCoefficient;
    }

    @Override
    public String toString() {
        return nameTypeEngine + ",\"" + engineTaxCoefficient + "\"";
    }
}
