package model.services;

import classes.partClasses.Part;
import classes.partClasses.Ssd;

import java.util.ArrayList;
import java.util.List;

public class SsdService {
    private final List<Ssd> ssdList = new ArrayList<>();

    public SsdService() {
    }

    public void load(List<String> units) {
        for (String s : units) {
            String[] ssdLine = s.split(";");
            ssdList.add(new Ssd(ssdLine[0], ssdLine[1]));
        }
    }

    public List<Ssd> getSsdList() {
        return ssdList;
    }

    public String getUnitsStringList() {
        StringBuilder sb = new StringBuilder();
        for (Part unit : ssdList)
            sb.append(unit).append("\n");
        return sb.toString();
    }

}

