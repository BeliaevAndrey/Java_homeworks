package model.filters;

import classes.partClasses.Part;
import classes.partClasses.Ram;
import model.Controller;
import model.services.RamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RamFilter {
    private final List<Plates> memSet = new ArrayList<>();

    private final Controller control;

    public RamFilter(Controller control) {
        this.control = control;
    }

    enum Plates {
        SIXTEEN(16), EIGHT(8), FOUR(4), TWO(2), ONE(1);
        private final int vol;

        Plates(int a) {
            this.vol = a;
        }

        int getVol() {
            return this.vol;
        }

    }

    void count(int inVol) {
        memSet.clear();
        int vol = inVol;
        int position = 0;

        while (vol > 0) {
            while (vol - Plates.values()[position].getVol() > 0) {
                memSet.add(Plates.values()[position]);
                vol -= Plates.values()[position].getVol();
            }
            if (vol % Plates.values()[position].getVol() == 0) {
                memSet.add(Plates.values()[position]);
                vol -= Plates.values()[position].getVol();
            } else {
                position++;
            }
        }
        if (memSet.size() > 4) {
            count(inVol + 1);
        }
    }

    int adder(List<Part> ramList) {
        int result = 0;
        for (Part module : ramList) {
            result += ((Ram) module).getIntRamVol();
        }
        return result;
    }

    public List<Part> getMemSet(int memVol) {       // TODO Correct calculating!!!
        List<Ram> ramStore = control.ramSvc.getRamList();
        List<Part> ramList = new ArrayList<>();
        count(memVol);
        for (Plates plate : memSet) {
            for (Ram module : ramStore) {
                if (module.getIntRamVol() == plate.getVol()) {
                    ramList.add(module);
                }
                if (adder(ramList) >= memVol) {
                    break;
                }

            }
        }
        return ramList;
    }

//    public static void main(String[] args) {
//        RamFilter cntP = new RamFilter();
//
//
//        cntP.count(64);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(63);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(56);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(43);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(11);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(16);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(32);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(17);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//        cntP.count(33);
//        System.out.println(cntP.memSet);
//        System.out.println(cntP.adder());
//        System.out.println("=".repeat(40));
//
//    }


}
