package model.services;

import classes.partClasses.Part;
import classes.partClasses.PowerSupply;

import java.util.ArrayList;
import java.util.List;

public class PowerSupplyService {
    private final List<PowerSupply> psList = new ArrayList<>();

    public PowerSupplyService(){

    }

    public void load(List<String> units) {
        for (String s : units) {
            String[] psLine = s.split(";");
            psList.add(new PowerSupply(psLine[0], psLine[1], psLine[2]));
        }
    }

    public List<PowerSupply> getPsList() {
        return psList;
    }

    public String getUnitsStringList() {
        StringBuilder sb = new StringBuilder();
        for (Part unit : psList)
            sb.append(unit).append("\n");
        return sb.toString();
    }

}
