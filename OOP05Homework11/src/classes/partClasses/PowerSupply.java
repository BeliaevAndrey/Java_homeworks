package classes.partClasses;

public class PowerSupply extends Part {
    private String powerCap;

    private String psParam;

    public PowerSupply(String powerCap, String brand, String psParam) {
        super(brand);
        this.powerCap = powerCap;
        this.psParam = psParam;
    }

    public String getPowerCap() {
        return powerCap;
    }

    public String getPsParam() {
        return psParam;
    }

    @Override
    public String toString() {
        return String.format("Power Supply. Power Capacity: %s, Brand: %s, Other parameters: %s",
                powerCap, this.brand, psParam);
    }
}
