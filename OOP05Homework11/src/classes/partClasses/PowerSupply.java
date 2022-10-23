package classes.partClasses;

public class PowerSupply extends Part {
    private String powerCap;

    private int intPowerCap;
    private String psParam;

    public PowerSupply(String powerCap, String brand, String psParam) {
        super(brand);
        this.powerCap = powerCap;
        this.psParam = psParam;
        setIntPowerCap();
    }

    void setIntPowerCap() {
        this.intPowerCap = Integer.parseInt(
                this.powerCap.replaceAll(" ", "").
                        replaceAll("W", "").
                        replaceAll("В[Тт]", ""));
    }

    public int getIntPowerCap() {
        return intPowerCap;
    }

    public String getPowerCap() {
        return powerCap;
    }

    public String getPsParam() {
        return psParam;
    }

    @Override
    public String toString() {
        return String.format("Power Supply. Power Capacity: %d W, Brand: %s, Other parameters: %s",
                intPowerCap, this.brand, psParam);
    }
}
