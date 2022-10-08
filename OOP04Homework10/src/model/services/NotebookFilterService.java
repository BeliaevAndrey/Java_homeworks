package model.services;

import computerCls.extending.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NotebookFilterService {
    public NotebookFilterService() {

    }

//    public List<NoteBook> filterById(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }

    String getFiled(NoteBook unit, String field){
        switch (field){
            case "id": return unit.getId();
            case "model": return unit.getModel();
            case "memory": return unit.getMemory();
            case "ssd": return unit.getSsd();
            case "Battery": return unit.getBatteryCapacity().toString();
            default: throw new IllegalStateException("Wrong Field");
        }
    }

    public List<NoteBook> commonFilter(List<NoteBook> source, String field,  String request) {
        List<NoteBook> filtered = new ArrayList<>();
        for (NoteBook unit : source) {
            if (getFiled(unit, field).equals(request))
                filtered.add(unit);
        }
        return filtered;
    }
//    public List<NoteBook> filterBySsd(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }
//
//    public List<NoteBook> filterByMemory(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }
//
//    public List<NoteBook> filterByModel(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }
//
//    public List<NoteBook> filterByBattery(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }
}
