package model.Common;

import classes.partClasses.Cpu;
import classes.partClasses.Part;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewSvc {

    private final ScanKeybSvc scanKeybSvc = new ScanKeybSvc();

    public void printNumberedMap(HashMap<Integer, Part> mapToPrint) {
        for (Map.Entry<Integer, Part> item : mapToPrint.entrySet()) {
            System.out.printf("%d: %s\n", item.getKey(), item.getValue());
        }
    }

    public void printHashMap(HashMap<String, List<String>> inMap) {
        for (Map.Entry<String, List<String>> item : inMap.entrySet()) {
            System.out.println(item.getKey());
            for (String unit : item.getValue()) {
                System.out.println(unit);
            }
        }
    }

    public void printTxtList(String stringList) {
        System.out.println(stringList);
    }

    public int chooseDiskVol(String diskType) {
        System.out.printf("Input %s drive volume (Gigabytes, 3096 max): ", diskType);
        return scanKeybSvc.scanNum();
    }

    public String chooseChassisSize() {
        String[] chSizes = new String[]{
                "Full Tower", "Midi Tower", "Mini Tower"};
        int counter = 0;
        System.out.println("Choose chassis size: ");
        for (String pos : chSizes){
            System.out.printf("%d.\t %s\n", ++counter, pos);
        }
        System.out.print("Input number: ");

        return chSizes[scanKeybSvc.scanNum() - 1];
    }

}
