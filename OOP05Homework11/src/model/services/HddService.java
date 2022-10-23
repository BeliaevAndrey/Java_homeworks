package model.services;

import classes.partClasses.Hdd;
import classes.partClasses.Part;

import java.util.ArrayList;
import java.util.List;

public class HddService {
    private final List<Hdd> hddList = new ArrayList<>();

    public HddService(){

    }

    public void load(List<String> units) {
        for (String s : units) {
            String[] ssdLine = s.split(";");
            hddList.add(new Hdd(ssdLine[0], ssdLine[1]));
        }
    }

    public List<Hdd> getHddList() {
        return hddList;
    }
    public String getUnitsStringList() {
        StringBuilder sb = new StringBuilder();
        for (Part unit : hddList)
            sb.append(unit).append("\n");
        return sb.toString();
    }

}
