package model.services;

import model.interfaces.Sortable;
import computerCls.extenders.PC;
import model.ComputerComparator;
import model.interfaces.Printable;

import java.util.Collections;
import java.util.List;

public class PCService implements Sortable<PC>, Printable<PC> {

    public PCService() {
    }

    @Override
    public List<PC> sortUnitsById(List<PC> list){
        Collections.sort(list, new ComputerComparator());
        return list;
    }

    public String printedVersion(List<PC> unitList) {
        StringBuilder sb = new StringBuilder();
        for (PC unit : sortUnitsById(unitList)){
            sb.append(unit.toString()).append("\n");
        }
        return sb.toString();
    }

    public void print(List<PC> unitList) {
        StringBuilder sb = new StringBuilder();
        for (PC unit : sortUnitsById(unitList)){
            sb.append(unit.toString()).append("\n");
        }
        System.out.println(sb);
    }
}
