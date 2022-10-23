package model;

import classes.DesktopPC;
import classes.partClasses.*;
import model.Common.ScanKeybSvc;
import model.Common.ViewSvc;
import model.filters.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesktopBuilder {

    private final DesktopPC aMachine = new DesktopPC();
    private final ViewSvc vs = new ViewSvc();
    private final ScanKeybSvc sk = new ScanKeybSvc();

    Controller control;

    public DesktopBuilder(Controller control) {
        this.control = control;
    }


    void installRam(int ramVol) {
        List<Ram> memSet = new ArrayList<>();
        RamFilter ramFilter = new RamFilter(control);
        for (Part module : ramFilter.getMemSet(ramVol)) {
            memSet.add((Ram) module);
        }
        aMachine.setRam(memSet);
    }

    void installMainBoard() {
        MainBoardFilter mbF = new MainBoardFilter(control);
        HashMap<Integer, Part> mbNumMap = mbF.mbBySocketFilter(aMachine.getCpu().getSocket());
        vs.printNumberedMap(mbNumMap);
        System.out.print("Choose a main board from a list: ");
        int num = sk.scanNum();
        aMachine.setMb((MainBoard) mbNumMap.get(num));
    }

    void installSsd() {
        SsdFilter ssdF = new SsdFilter(control);
        HashMap<Integer, Part> ssdNumMap = ssdF.ssdByVolFilter(vs.chooseDiskVol("SSD"));
        System.out.println("Choose ssd from a list: ");
        vs.printNumberedMap(ssdNumMap);
        aMachine.setSsd((Ssd) ssdNumMap.get(sk.scanNum()));
    }

    void installHdd() {
        HddFilter hddF = new HddFilter(control);
        HashMap<Integer, Part> hddNumMap = hddF.hddByVolFilter(vs.chooseDiskVol("Hard disk"));
        System.out.println("Choose hdd from a list: ");
        vs.printNumberedMap(hddNumMap);
        aMachine.setHdd((Hdd) hddNumMap.get(sk.scanNum()));
    }

    void installChassis() {
        ChassisFilter chassisFilter = new ChassisFilter(control);
        HashMap<Integer, Part> chassisNumMap = chassisFilter.chassisBySizeFilter(vs.chooseChassisSize());
        vs.printNumberedMap(chassisNumMap);
        System.out.print("Choose chassis from a list above: ");
        aMachine.setChassis((Chassis) chassisNumMap.get(sk.scanNum()));
    }

    void installVCard() {
        VCardFilter vCardFilter = new VCardFilter(control);
        HashMap<Integer, Part> vCardNumMap = vCardFilter.videCardFilter();
        vs.printNumberedMap(vCardNumMap);
        System.out.print("Choose Video Card from a list above: ");
        aMachine.setVCard((VideoCard) vCardNumMap.get(sk.scanNum()));
    }

    void installPowerUnit() {
        PowerSupplyFilter powerSupplyFilter = new PowerSupplyFilter(control);
        HashMap<Integer, Part> pwrSupNumMap = powerSupplyFilter.chassisBySizeFilter(vs.choosePwrCap());
        vs.printNumberedMap(pwrSupNumMap);
        System.out.print("Choose Power Supply from a list above (0 to decline): ");
        aMachine.setPowerUnit((PowerSupply) pwrSupNumMap.get(sk.scanNum()));
    }

    public DesktopPC buildDesktop(Cpu proc, int ramVol) {
        aMachine.setCpu(proc);
        aMachine.setRamVol(ramVol);
        installMainBoard();
        installRam(ramVol);
        installVCard();
        installSsd();
        installHdd();
        installChassis();
        installPowerUnit();
        return aMachine;
    }
}
