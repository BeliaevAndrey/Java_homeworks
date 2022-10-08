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
}

//    public List<NoteBook> methodFindAndWriteFilteringValue(List<NoteBook> list, String field, String value) { // данный метод выводит отфильтрованные строки
//        List<NoteBook> fList = new ArrayList<>();
//        for (NoteBook notebook : list) {
//            switch (field) {
//                case "id":
//                    if (notebook.getId().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//                case "model":
//                    if (notebook.getModel().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//                case "memory":
//                    if (notebook.getMemory().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//
//                case "ssd":
//                    if (notebook.getSsd().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//            }
//        }
//
//        return fList;
//    }
//
//    public List<NoteBook> getSortedByIdNotebook(List<NoteBook> listIn) {
//        Collections.sort(listIn, new ComputerComparator());
//        return listIn;
//    }
//
//}

//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NotebookService {
//
//    /*public static String methodFindFieldInDataBase(String field){ // метод выполняет проверку наличия поля, которое ввёл пользователь
//        String res = o + "1";
//        // to do 3. Написать метод
//        return res;
//    }*/
//
//    public List<NoteBook> methodFindAndWriteFilteringValue(List<NoteBook> list, String field, String value) { // данный метод выводит отфильтрованные строки
//        List<NoteBook> fList = new ArrayList<>();
//        for (NoteBook notebook : list) {
//            switch (field) {
//                case "id":
//                    if (notebook.getId().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//                case "model":
//                    if (notebook.getModel().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//                case "memory":
//                    if (notebook == null) {
//
//                    }
//                    if (notebook.getMemory().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//
//
//                case "ssd":
//                    if (notebook.getSsd().equals(value)) {
//                        fList.add(notebook);
//                    }
//                    break;
//            }
//        }
//
//        return fList;
//    }
//    public List<NoteBook> getAsusNotebooks(List<NoteBook> list){
//        List<NoteBook> fList = new ArrayList<>();
//        for (NoteBook notebook : list) {
//            if (notebook.getModel().equals("Air")){
//                fList.add(notebook);
//            }
//        }
//        return fList;
//    }
//
//}
