package model.common;

import classes.partClasses.Part;

import java.util.HashMap;
import java.util.Map;

public class ViewSvc {

    private final ScanKbdSvc scanKbdSvc = new ScanKbdSvc();


    public void printText(String line) {
        System.out.println(line);
    }

    public void printPrompt(String line) {
        System.out.print(line + ": _> ");
    }

    public void printNumberedMap(HashMap<Integer, Part> mapToPrint) {
        for (Map.Entry<Integer, Part> item : mapToPrint.entrySet()) {
            System.out.printf("%d: %s\n", item.getKey(), item.getValue());
        }
    }


    public int chooseDiskVol(String diskType, int diskVol) {
        System.out.printf("Input %s drive volume (Gigabytes, %d max): ", diskType, diskVol);
        return scanKbdSvc.scanNum();
    }

    public String chooseChassisSize() {
        String[] chSizes = new String[]{
                "Full Tower", "Midi Tower", "Mini Tower", "CANCEL"};
        int counter = 0;
        System.out.println("Choose chassis size: ");
        for (String pos : chSizes) {
            System.out.printf("%d.\t %s\n", ++counter, pos);
        }
        printPrompt("Input number");

        return chSizes[scanKbdSvc.scanNum() - 1];
    }

    public int choosePwrCap() {
        printPrompt("Input Power Supply capacity (W, 900 max, 0 to decline)");
        return scanKbdSvc.scanNum();
    }


    public String chooseCpu() {
        printPrompt("Choose CPU brand (Intel, AMD, CANCEL to exit)");
        return scanKbdSvc.scanLine();
    }

    public int chooseRamVol() {
        int ramVol = 0;
        boolean flag = true;
        while (flag) {
            printPrompt("Set RAM volume (max 64GB)");
            ramVol = scanKbdSvc.scanNum();
            if (ramVol <= 64 && ramVol > 0) {
                flag = false;
            } else {
                System.out.println("Incorrect input. Try again, please.");
            }
        }
        return ramVol;
    }
}
