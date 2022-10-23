package classes.partClasses;

public class Ssd extends Part {
    private String ssdVol;
    private int ssdIntVol;
    private String ssdParam;

    public Ssd(String ssdVol, String ssdParam) {
        super("SSD");
        this.ssdVol = ssdVol;
        this.ssdParam = ssdParam;
        setSsdIntVol();
    }

    void setSsdIntVol() {
        this.ssdIntVol = Integer.parseInt(
                this.ssdVol.replaceAll(" ", "").
                        replaceAll("T[bB]", "").
                        replaceAll("Г[бБ]", "").
                        replaceAll("G[Bb]", ""));
        if (ssdIntVol < 10) {
            ssdIntVol *= 1024;
        }
    }

    public int getSsdIntVol() {
        return ssdIntVol;
    }

    public String getSsdVol() {
        return this.ssdVol;
    }

    public String getSsdParam() {
        return this.ssdParam;
    }

    @Override
    public String toString() {
        return String.format("%s. Volume: %s, Other parameters: %s",
                this.brand, ssdVol, ssdParam);
    }
}
