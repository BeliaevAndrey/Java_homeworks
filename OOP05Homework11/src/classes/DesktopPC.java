package classes;

import classes.partClasses.*;

import java.util.List;

public class DesktopPC {
    private Chassis chassis;
    private Cpu cpu;
    private List<Ram> ramSet;
    private int ramVol;
    private MainBoard mainBoard;
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
        this.ramVol = 0;
        for (Ram module : ramSet) {
            this.ramVol += module.getIntRamVol();
        }
    }

    public void setRamVol(int ramVol) {
        this.ramVol = ramVol;
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
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

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    String ramTextList() {
        StringBuilder sb = new StringBuilder();
        for (Ram module : ramSet) {
            sb.append(module.toString()).append("\n");
        }
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return String.format("CPU: %s\nRAM: %d Gb of:\n%s\nmb: %s\nVideo Card: %s" +
//                        "\nssd: %s\nhdd: %s\npowerUnit: %s\nchassis: %s\n",
//                cpu, ramVol, ramTextList(), mainBoard, vCard, ssd, hdd, powerUnit, chassis);
//    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CPU: %s\n", cpu));
        sb.append(String.format("RAM: %d Gb of:\n", ramVol));
        sb.append(String.format("%s", ramTextList()));
        sb.append(String.format("MainBoard: %s\n", mainBoard));
        sb.append(vCard != null ? String.format("Video Card: %s\n", vCard) : "");
        sb.append(ssd != null ? String.format("SSD: %s\n", ssd) : "");
        sb.append(hdd != null ? String.format("HDD: %s\n", hdd) : "");
        sb.append(powerUnit != null ? String.format("Power Supply: %s\n", powerUnit) : "");
        sb.append(chassis != null ? String.format("Chassis: %s\n", chassis) : "");

        return sb.toString();
    }
}
