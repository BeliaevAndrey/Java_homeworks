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

    private int ramVol = 0;

    Controller control;// = null;

    private final Part mainBoard = null;


    public DesktopBuilder(Controller control) {
        this.control = control;
    }


    void installRam() {
        List<Ram> memSet = new ArrayList<>();
        RamFilter ramF = new RamFilter(control);
        for (Part module : ramF.getMemSet(aMachine.getRamVol())) {
            memSet.add((Ram) module);
        }
        aMachine.setRam(memSet);
    }

    void installMainBoard() {
        MainBoardFilter mbf = new MainBoardFilter(control);
        System.out.println(aMachine.getCpu());  // TODO remove
        System.out.println(aMachine.getCpu().getSocket());  // TODO remove
        HashMap<Integer, Part> mbNumMap = mbf.mbBySocketFilter(aMachine.getCpu().getSocket());
        vs.printNumberedMap(mbNumMap);
        System.out.print("Choose a main board from a list: ");
        int num = sk.scanNum();
        aMachine.setMb((MainBoard) mbNumMap.get(num));
    }

    void installSsd() {
        SsdFilter ssdf = new SsdFilter(control);
        HashMap<Integer, Part> ssdNumMap = ssdf.ssdByVolFilter(vs.chooseDiskVol("SSD"));
        System.out.println("Choose ssd from a list: ");
        vs.printNumberedMap(ssdNumMap);
        aMachine.setSsd((Ssd) ssdNumMap.get(sk.scanNum()));
    }

    void installHdd() {
        HddFilter hddf = new HddFilter(control);
        HashMap<Integer, Part> hddNumMap = hddf.hddByVolFilter(vs.chooseDiskVol("Hard disk"));
        System.out.println(hddNumMap); // TODO remove
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

    public DesktopPC buildDesktop(Cpu proc, int ramVol) {
        aMachine.setRamVol(ramVol);
        aMachine.setCpu(proc);
        installMainBoard();
        installRam();
        installSsd();
        installHdd();
        installChassis();
//        aMachine.setPowerUnit();
        return aMachine;
    }
}
