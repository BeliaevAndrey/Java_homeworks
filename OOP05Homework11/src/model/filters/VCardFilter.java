package model.filters;

import classes.partClasses.VideoCard;
import classes.partClasses.Part;
import model.Controller;

import java.util.HashMap;

public class VCardFilter {

    private final Controller control;

    public VCardFilter(Controller control) {
        this.control = control;
    }

    public HashMap<Integer, Part> videCardFilter() {
        HashMap<Integer, Part> videCardsNumberedList = new HashMap<>();
        int counter = 0;
        for (VideoCard chassis : control.vCardSvc.getVCardList()) {
            videCardsNumberedList.put(++counter, chassis);
        }
        return videCardsNumberedList;
    }

}
