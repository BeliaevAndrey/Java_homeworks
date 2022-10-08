package model.services;

import model.interfaces.Sortable;
import computerCls.extending.PC;
import model.ComputerComparator;
import model.interfaces.Printable;

import java.util.Collections;
import java.util.List;

public class PCService implements Sortable<PC>, Printable<PC> {

    public PCService() {
    }

    @Override
    public List<PC> sort(List<PC> list){
        Collections.sort(list, new ComputerComparator());
        return list;
    }

    public String printedVersion(List<PC> unitList) {
        StringBuilder sb = new StringBuilder();
        for (PC unit : unitList){
            sb.append(unit.toString()).append("\n");
        }
        return sb.toString();
    }
}
