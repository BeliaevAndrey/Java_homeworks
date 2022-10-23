package model;

import classes.DesktopPC;
import classes.partClasses.Cpu;
import classes.partClasses.Part;
import model.Common.ViewSvc;
import model.filters.CpuFilter;
import model.services.*;

import java.util.HashMap;
import java.util.Scanner;


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


//    public Controller() {
//
//    }

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

//        vs.printTxtList(cpuSvc.getUnitsStringList());
//        vs.printTxtList(ramSvc.getUnitsStringList());
//        vs.printTxtList(mBoardSvc.getUnitsStringList());
//        vs.printTxtList(hddSvc.getUnitsStringList());
//        vs.printTxtList(ssdSvc.getUnitsStringList());
//        vs.printTxtList(vCardSvc.getUnitsStringList());
        vs.printTxtList(pwrSupSvc.getUnitsStringList());
//        vs.printTxtList(chassisSvc.getUnitsStringList());

    }

    public void pickAnOrder() {
        CpuFilter cf = new CpuFilter();

        try(Scanner scn = new Scanner(System.in)) {
            boolean flag = true;
            HashMap<Integer, Part> cpuList = new HashMap<>();
            vs.printTxtList(cpuSvc.getUnitsStringList());
            while(flag) {
                System.out.print("Choose CPU brand: ");
                String brand = scn.nextLine();
                cpuList = cf.brandFilter(cpuSvc.getCpuList(), brand);
                if (cpuList.size() > 0){
                    flag = false;
                }else {
                    System.out.println("Incorrect input. Try again, please.");
                }
            }
            vs.printNumberedMap(cpuList);
            System.out.print("Choose processor: ");
            Cpu proc = (Cpu) cpuList.get(scn.nextInt());

            System.out.println(proc);

            System.out.print("Set RAM volume (max 64GB): ");
            int ramVol = 0;
            flag = true;
            while (flag) {
                ramVol = scn.nextInt();
                if (ramVol <= 64 && ramVol > 0){
                    flag = false;
                }else {
                    System.out.print("Incorrect input. Try again, please.\nSet RAM volume (max 64GB): ");
                }
            }

            System.out.println(ramVol);

            DesktopBuilder dtBuild = new DesktopBuilder(this);
            DesktopPC newPC = dtBuild.buildDesktop(proc, ramVol);
            System.out.println(newPC.toString());
        }

    }

}
