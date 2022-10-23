package model.filters;

import classes.partClasses.Part;
import classes.partClasses.Ssd;
import model.Controller;

import java.util.HashMap;

public class SsdFilter {

    private final Controller control;
    public SsdFilter(Controller control){
        this.control = control;
    }

    public HashMap<Integer, Part> ssdByVolFilter(int wishedVol) {
        HashMap<Integer, Part> ssdNumberedList = new HashMap<>();

        int counter = 0;

        for (Ssd ssd : control.ssdSvc.getSsdList()) {
            if (ssd.getSsdIntVol() == wishedVol ||
                    Math.abs(ssd.getSsdIntVol() - wishedVol) < 25) {
                ssdNumberedList.put(++counter, ssd);
            }
        }
        return ssdNumberedList;
    }

}
