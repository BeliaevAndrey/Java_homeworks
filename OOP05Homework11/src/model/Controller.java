package model;

import classes.DesktopPC;
import classes.partClasses.Cpu;
import classes.partClasses.Part;
import model.common.ScanKbdSvc;
import model.common.ViewSvc;
import model.filters.CpuFilter;
import model.services.*;

import java.util.HashMap;


public class Controller {

    private final ViewSvc vs = new ViewSvc();
    public final CpuService cpuSvc = new CpuService();
    public final RamService ramSvc = new RamService();
    public final HddService hddSvc = new HddService();
    public final SsdService ssdSvc = new SsdService();
    public final PowerSupplyService pwrSupSvc = new PowerSupplyService();
    public final MBoardService mBoardSvc = new MBoardService();
    public final ChassisService chassisSvc = new ChassisService();
    public final VideoCardService vCardSvc = new VideoCardService();


    public void loadParts() {
        Preloader preLdr = new Preloader();
        preLdr.parser();
        cpuSvc.load(preLdr.parts.get("cpu"));
        ramSvc.load(preLdr.parts.get("ram"));
        mBoardSvc.load(preLdr.parts.get("mainBoard"));
        ssdSvc.load(preLdr.parts.get("ssd"));
        hddSvc.load(preLdr.parts.get("hdd"));
        vCardSvc.load(preLdr.parts.get("vCard"));
        pwrSupSvc.load(preLdr.parts.get("powerSupply"));
        chassisSvc.load(preLdr.parts.get("chassis"));

    }

    public void startBuildPC() {
        ScanKbdSvc scanKbd = new ScanKbdSvc();
        CpuFilter cf = new CpuFilter();

        HashMap<Integer, Part> cpuList = new HashMap<>();
        String brand = null;
        int ramVol;
        Cpu proc;

        boolean flag = true;
        while (flag) {
            brand = vs.chooseCpu();
            if (!brand.equalsIgnoreCase("cancel")) {
                cpuList = cf.brandFilter(cpuSvc.getCpuList(), brand);
                if (cpuList.size() > 0) {
                    flag = false;
                } else {
                    vs.printText("Incorrect input. Try again, please.");
                }
            } else {
                flag = false;
            }
        }
        if (!brand.equalsIgnoreCase("cancel")) {
            vs.printNumberedMap(cpuList);
            vs.printPrompt("Choose processor: \b\r");
            proc = (Cpu) cpuList.get(scanKbd.scanNum());

            ramVol = vs.chooseRamVol();


            DesktopBuilder dtBuild = new DesktopBuilder(this);
            DesktopPC newPC = dtBuild.buildDesktop(proc, ramVol);
            if (newPC != null) {
                vs.printText(newPC.toString());
            } else {
                vs.printText("Assembly cancelled!");
            }
        } else {
            vs.printText("Assembly cancelled!");
        }
    }


//    public void pickAnOrder() {
//        CpuFilter cf = new CpuFilter();
//
//        try(Scanner scn = new Scanner(System.in)) {
//            boolean flag = true;
//            HashMap<Integer, Part> cpuList = new HashMap<>();
//            while(flag) {
//                vs.printText("Choose CPU brand (Intel, AMD): ");
//                String brand = scn.nextLine();
//                cpuList = cf.brandFilter(cpuSvc.getCpuList(), brand);
//                if (cpuList.size() > 0){
//                    flag = false;
//                }else {
//                    vs.printText("Incorrect input. Try again, please.");
//                }
//            }
//            vs.printNumberedMap(cpuList);
//            vs.printText("Choose processor: \r");
//            Cpu proc = (Cpu) cpuList.get(scn.nextInt());
//
//            vs.printText("Set RAM volume (max 64GB): \r");
//            int ramVol = 0;
//            flag = true;
//            while (flag) {
//                ramVol = scn.nextInt();
//                if (ramVol <= 64 && ramVol > 0){
//                    flag = false;
//                }else {
//                    vs.printText("Incorrect input. Try again, please.\nSet RAM volume (max 64GB): ");
//                }
//            }
//
//            DesktopBuilder dtBuild = new DesktopBuilder(this);
//            DesktopPC newPC = dtBuild.buildDesktop(proc, ramVol);
//            if (newPC != null)
//                vs.printText(newPC.toString());
//            else vs.printText("Assembly cancelled!");
//        }
//
//    }

}
