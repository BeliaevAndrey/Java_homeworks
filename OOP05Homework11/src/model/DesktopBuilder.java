package model;

import classes.DesktopPC;
import classes.partClasses.*;
import model.common.ScanKbdSvc;
import model.common.ViewSvc;
import model.filters.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesktopBuilder {

    private final DesktopPC aMachine = new DesktopPC();
    private final ViewSvc vs = new ViewSvc();
    private final ScanKbdSvc scanKbdSvc = new ScanKbdSvc();

    Controller control;

    public DesktopBuilder(Controller control) {
        this.control = control;
    }


    void installRam(int ramVol) {
        List<Ram> memSet = new ArrayList<>();
        RamFilter ramFilter = new RamFilter(control);
        for (Part module : ramFilter.getRamList(ramVol)) {
            memSet.add((Ram) module);
        }
        aMachine.setRam(memSet);
    }

    void installMainBoard() {
        MainBoardFilter mbF = new MainBoardFilter(control);
        HashMap<Integer, Part> mbNumMap = mbF.mbBySocketFilter(aMachine.getCpu().getSocket());
        vs.printNumberedMap(mbNumMap);
        vs.printPrompt("Choose a main board from a list above (0 to decline)");
        int num = scanKbdSvc.scanNum();
        aMachine.setMainBoard((MainBoard) mbNumMap.get(num));
    }

    void installSsd() {
        int volLim = 512;
        SsdFilter ssdF = new SsdFilter(control);
        HashMap<Integer, Part> ssdNumMap = ssdF.ssdByVolFilter(vs.chooseDiskVol("SSD", volLim));
        if (ssdNumMap.size() > 0) {
            vs.printNumberedMap(ssdNumMap);
            vs.printPrompt("Choose ssd from a list above (0 to decline)");
            aMachine.setSsd((Ssd) ssdNumMap.get(scanKbdSvc.scanNum()));
        }
    }

    void installHdd() {
        int volLim = 3096;
        HddFilter hddF = new HddFilter(control);
        HashMap<Integer, Part> hddNumMap = hddF.hddByVolFilter(vs.chooseDiskVol("Hard disk", volLim));
        if (hddNumMap.size() > 0) {
            vs.printNumberedMap(hddNumMap);
            vs.printPrompt("Choose hdd from a list above (0 to decline): ");
            aMachine.setHdd((Hdd) hddNumMap.get(scanKbdSvc.scanNum()));
        }
    }

    void installChassis() {
        ChassisFilter chassisFilter = new ChassisFilter(control);
        HashMap<Integer, Part> chassisNumMap = chassisFilter.chassisBySizeFilter(vs.chooseChassisSize());
        if (chassisNumMap.size() > 0) {
            vs.printNumberedMap(chassisNumMap);
            vs.printPrompt("Choose chassis from a list above (0 to decline)");
            aMachine.setChassis((Chassis) chassisNumMap.get(scanKbdSvc.scanNum()));
        }
    }

    void installVCard() {
        VCardFilter vCardFilter = new VCardFilter(control);
        HashMap<Integer, Part> vCardNumMap = vCardFilter.videCardFilter();
        vs.printNumberedMap(vCardNumMap);
        vs.printPrompt("Choose Video Card from a list above (0 to decline)");
        aMachine.setVCard((VideoCard) vCardNumMap.get(scanKbdSvc.scanNum()));
    }

    void installPowerUnit() {
        PowerSupplyFilter powerSupplyFilter = new PowerSupplyFilter(control);
        HashMap<Integer, Part> pwrSupNumMap = powerSupplyFilter.chassisBySizeFilter(vs.choosePwrCap());
        if (pwrSupNumMap.size() > 0) {
            vs.printNumberedMap(pwrSupNumMap);
            vs.printPrompt("Choose Power Supply from a list above (0 to decline)");
            aMachine.setPowerUnit((PowerSupply) pwrSupNumMap.get(scanKbdSvc.scanNum()));
        }
    }

    public DesktopPC buildDesktop(Cpu proc, int ramVol) {
        aMachine.setCpu(proc);
//        aMachine.setRamVol(ramVol);
        installMainBoard();
        if (aMachine.getMainBoard() != null) {
            installRam(ramVol);
            installVCard();
            installSsd();
            installHdd();
            installChassis();
            installPowerUnit();
            return aMachine;
        }
        return null;

    }
}
