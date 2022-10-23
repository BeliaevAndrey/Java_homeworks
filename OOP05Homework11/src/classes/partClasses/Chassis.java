package classes.partClasses;

public class Chassis extends Part{
    private String chSize;
    private String chParam;

    public Chassis(String chSize, String chBrand, String chParam) {
        super(chBrand);
        this.chSize = chSize;
        this.chParam = chParam;
    }

    public String getChSize() {
        return chSize;
    }

    public String getChParam() {
        return chParam;
    }

    @Override
    public String toString() {
        return String.format("Chassis. Size: %s, Brand: %s, Other parameters: %s",
                chSize, this.brand, chParam);
    }
}
