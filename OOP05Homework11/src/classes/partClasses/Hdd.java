package classes.partClasses;

public class Hdd extends Part{
    private String hddVol;

    private int hddIntVol;
    private String hddParam;

    public Hdd(String hddVol, String hddParam) {
        super("HDD");
        this.hddVol = hddVol;
        this.hddParam = hddParam;
        setHddIntVol();
    }

    void setHddIntVol() {
        this.hddIntVol = Integer.parseInt(
                this.hddVol.replaceAll(" ", "").
                        replaceAll("T[Bb]", "").
                        replaceAll("Г[бБ]", "").
                        replaceAll("G[Bb]", ""));
        if (hddIntVol < 10) {
            hddIntVol *= 1024;
        }
    }

    public int getHddIntVol() {
        return hddIntVol;
    }

    public String getHddVol() {
        return this.hddVol;
    }

    public String getHddParam() {
        return this.hddParam;
    }

    @Override
    public String toString() {
        return String.format("%s. Volume: %s, %d, Other parameters: %s",
                this.brand, hddVol, hddIntVol, hddParam);
    }

}
