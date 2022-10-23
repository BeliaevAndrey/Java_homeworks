package model.filters;

import classes.partClasses.MainBoard;
import classes.partClasses.Part;
import model.Controller;
import model.services.MBoardService;

import java.util.HashMap;

public class MainBoardFilter {

    private final Controller control;
    public MainBoardFilter(Controller control){
        this.control = control;
    }

    public HashMap<Integer, Part> mbBySocketFilter(String socket) {
        HashMap<Integer, Part> mbNumberedList = new HashMap<>();

//        Controller control = new Controller();
//        MBoardService mbSvc = new MBoardService();

        int counter = 0;

        for (MainBoard mb : control.mBoardSvc.getMbList()) {
            if (mb.getSocket().equals(socket)) {
                mbNumberedList.put(++counter, mb);
            }
        }
        return mbNumberedList;
    }

}
