package model.filters;

import classes.partClasses.Part;
import classes.partClasses.PowerSupply;
import model.Controller;

import java.util.HashMap;

public class PowerSupplyFilter {

    private final Controller control;
    public PowerSupplyFilter(Controller control){
        this.control = control;
    }

    public HashMap<Integer, Part> chassisBySizeFilter(int wishedCap) {
        HashMap<Integer, Part> pwrSupNumList = new HashMap<>();

        int counter = 0;

        for (PowerSupply powerSupply : control.pwrSupSvc.getPsList()) {
            if (powerSupply.getIntPowerCap() == wishedCap) {
                pwrSupNumList.put(++counter, powerSupply);
            }
        }
        return pwrSupNumList;
    }

}
