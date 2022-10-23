package model.filters;

import classes.partClasses.Hdd;
import classes.partClasses.Part;
import model.Controller;

import java.util.HashMap;

public class HddFilter {

    private final Controller control;
    public HddFilter(Controller control){
        this.control = control;
    }

    public HashMap<Integer, Part> hddByVolFilter(int wishedVol) {
        HashMap<Integer, Part> hddNumberedList = new HashMap<>();

        int counter = 0;

        for (Hdd hdd : control.hddSvc.getHddList()) {
            if (hdd.getHddIntVol()== wishedVol ||
                    Math.abs(hdd.getHddIntVol() - wishedVol) < 25) {
                hddNumberedList.put(++counter, hdd);
            }
        }
        return hddNumberedList;
    }

}
