package model;

import computerCls.extending.NoteBook;
import model.services.NotebookService;

import java.util.List;

public class NotebookController {
    private NotebookService notebookService;

    public NotebookController() {
        this.notebookService = new NotebookService();
    }

    public List<NoteBook> getSortedNotebookById(List<NoteBook> list) {
        return notebookService.sort(list);
    }
}
//
////    public List<NoteBook> getFilteredNotebookList(List<NoteBook> list, String field, String value){
//    public List<NoteBook> getFilteredNotebookList(List<NoteBook> list, String field, String value){
//        if(list.isEmpty()) {
//            return new ArrayList<>();
//        }
//        if (field.isBlank()) {
////            throw new IllegalStateException();
//            throw new StupidUserException();
//        }
//        return notebookService.methodFindAndWriteFilteringValue(list, field, value);
//    }
//    public List<NoteBook> getSortedByIdNotebook(List<NoteBook> list) {
//        return notebookService.getSortedByIdNotebook(list);
//    }
//}

//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NotebookContoller {
//    private NotebookService notebookService;
//
//    public NotebookContoller(){
//        this.notebookService = new NotebookService();
//    }
//
//    public List<NoteBook> getFilteredNotebookList(List<NoteBook> list, String field, String value){
////        if(list.isEmpty()){
////            return new ArrayList<>();
////        }
//        if (field.isBlank()){
//            throw new StupidUserException();
//        }
//
//
////          return notebookService.methodFindAndWriteFilteringValue(list, field, value);
////        List<NoteBook> temp =  notebookService.methodFindAndWriteFilteringValue(list, field, value);
//        List<NoteBook> temp2 = notebookService.getAsusNotebooks(list);
//        return temp2;
//
//    }
//
//}
