package model.services;

import classes.partClasses.Part;
import classes.partClasses.VideoCard;

import java.util.ArrayList;
import java.util.List;

public class VideoCardService {
    private final List<VideoCard> vCardList = new ArrayList<>();

    public VideoCardService(){

    }

    public void load(List<String> units) {
        for (String s : units) {
            vCardList.add(new VideoCard(s));
        }
    }

    public List<VideoCard> getVCardList() {
        return vCardList;
    }

    public String getUnitsStringList() {
        StringBuilder sb = new StringBuilder();
        for (Part unit : vCardList)
            sb.append(unit).append("\n");
        return sb.toString();
    }

}
