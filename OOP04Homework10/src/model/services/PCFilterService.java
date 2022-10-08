package model.services;

import computerCls.extenders.PC;
import model.interfaces.Printable;

import java.util.ArrayList;
import java.util.List;

public class PCFilterService implements Printable<PC> {
    public PCFilterService() {

    }

    String getFiled(PC unit, String field){
        switch (field){
            case "id": return unit.getId();
            case "model": return unit.getModel();
            case "memory": return unit.getMemory();
            case "ssd": return unit.getSsd();
            case "Power Supply": return unit.getPowerSupply().toString();
            default: throw new IllegalStateException("Wrong Field");
        }
    }

    public String commonFilter(List<PC> source, String field,  String request) {
        List<PC> filtered = new ArrayList<>();
        for (PC unit : source) {
            if (getFiled(unit, field).equals(request))
                filtered.add(unit);
        }
        return printedVersion(filtered);
    }

    @Override
    public String printedVersion(List<PC> unitList) {
        StringBuilder sb = new StringBuilder("\n");
        for (PC unit : unitList){
            sb.append(unit).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void print(List<PC> unitList) {
        StringBuilder sb = new StringBuilder("\n");
        for (PC unit : unitList){
            sb.append(unit).append("\n");
        }
        System.out.println(sb);
    }
}
