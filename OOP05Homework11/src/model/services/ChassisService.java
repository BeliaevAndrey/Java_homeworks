package model.services;

import classes.partClasses.Chassis;
import classes.partClasses.Part;

import java.util.ArrayList;
import java.util.List;

public class ChassisService {
    private final List<Chassis> chassisList = new ArrayList<>();

    public ChassisService(){
    }

    public void load(List<String> units) {
        for (String s : units) {
            String[] chassisLine = s.split(";");
            chassisList.add(new Chassis(chassisLine[0], chassisLine[1], chassisLine[2]));
        }
    }

    public List<Chassis> getChassisList() {
        return chassisList;
    }

    public String getUnitsStringList() {
        StringBuilder sb = new StringBuilder();
        for (Part unit : chassisList)
            sb.append(unit).append("\n");
        return sb.toString();
    }

}
