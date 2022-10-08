package model.services;

import computerCls.Memory;
import computerCls.extenders.NoteBook;

import java.util.Arrays;
import java.util.List;

public class NotebookLoader {

    public NotebookLoader(){

    }
    public void loadNtb(List<NoteBook> ntbList) {

        NoteBook n1 = new NoteBook("14", "Air", Memory.ONE, "256", 3000);
        NoteBook n2 = new NoteBook("2", "MagicBook", Memory.EIGHT, "512", 4000);
        NoteBook n3 = new NoteBook("32", "MateBook", Memory.SIXTEEN, "512", 5000);
        NoteBook n4 = new NoteBook("01", "ASUS", Memory.SIX, "512", 5000);
        NoteBook n5 = new NoteBook("23", "Acer", Memory.EIGHT, "512", 5000);
        ntbList.addAll(Arrays.asList(n1, n2, n3, n4, n5));

    }
}
