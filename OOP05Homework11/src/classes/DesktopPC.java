package classes;

import classes.partClasses.*;

import java.util.List;

public class DesktopPC {
    private Chassis chassis;
    private Cpu cpu;
    private List<Ram> ramSet;       // TODO Add nice string maker
    private int ramVol;     // TODO Separate wished volume, and actual one!!!
    private MainBoard mb;
    private VideoCard vCard;
    private PowerSupply powerUnit;
    private Ssd ssd;
    private Hdd hdd;

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setRam(List<Ram> ramSet) {
        this.ramSet = ramSet;
    }

    public void setRamVol(int ramVol) {
        this.ramVol = ramVol;
    }

    public void setMb(MainBoard mb) {
        this.mb = mb;
    }

    public void setVCard(VideoCard vCard) {
        this.vCard = vCard;
    }

    public void setPowerUnit(PowerSupply powerUnit) {
        this.powerUnit = powerUnit;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public int getRamVol() {
        return ramVol;
    }

    @Override
    public String toString() {
        return String.format("CPU: %s\nRAM: %d Gb of:\n %s\nmb: %s\nVideo Card: %s" +
                        "\nssd: %s\nhdd: %s\npowerUnit: %s\nchassis: %s\n",
                cpu, ramVol, ramSet.toString(), mb, vCard, ssd, hdd, powerUnit, chassis);
    }
}
