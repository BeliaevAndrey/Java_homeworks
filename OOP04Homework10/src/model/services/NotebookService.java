package model.services;

import model.ComputerComparator;
import computerCls.extenders.NoteBook;
import model.interfaces.Sortable;
import model.interfaces.Printable;

import java.util.Collections;
import java.util.List;

public class NotebookService implements Sortable<NoteBook>, Printable<NoteBook> {

    public NotebookService() {
    }

    @Override
    public List<NoteBook> sortUnitsById(List<NoteBook> list) {
        Collections.sort(list, new ComputerComparator());
        return list;
    }

    @Override
    public String printedVersion(List<NoteBook> unitList) {

        StringBuilder sb = new StringBuilder();
        for (NoteBook ntb : sortUnitsById(unitList))
            sb.append(ntb).append("\n");
        return sb.toString();
    }

    @Override
    public void print(List<NoteBook> unitList) {

        StringBuilder sb = new StringBuilder();
        for (NoteBook ntb : sortUnitsById(unitList))
            sb.append(ntb).append("\n");
        System.out.println(sb);
    }
}
