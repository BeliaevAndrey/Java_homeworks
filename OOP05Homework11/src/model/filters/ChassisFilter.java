package model.filters;

import classes.partClasses.Chassis;
import classes.partClasses.Part;
import model.Controller;

import java.util.HashMap;

public class ChassisFilter {

    private final Controller control;
    public ChassisFilter(Controller control){
        this.control = control;
    }

    public HashMap<Integer, Part> chassisBySizeFilter(String wishedSize) {
        HashMap<Integer, Part> chassisNumberedList = new HashMap<>();

        int counter = 0;

        for (Chassis chassis : control.chassisSvc.getChassisList()) {
            if (chassis.getChSize().equals(wishedSize)) {
                chassisNumberedList.put(++counter, chassis);
            }
        }
        return chassisNumberedList;
    }

}
