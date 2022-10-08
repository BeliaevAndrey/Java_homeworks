package model;

import computerCls.extending.NoteBook;
import computerCls.extending.PC;
import model.services.NotebookLoader;
import model.services.PCLoader;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<NoteBook> notebooks = new ArrayList<>();
    private List<PC> pcComputers = new ArrayList<>();

    public Controller() {
        NotebookLoader loadNotebooks = new NotebookLoader();
        PCLoader loadPCs = new PCLoader();

        loadNotebooks.loadNtb(notebooks);
        loadPCs.loadPCs(pcComputers);
    }

    public List<NoteBook> getNotebooks() {
        return notebooks;
    }

    public List<PC> getPcComputers() {
        return pcComputers;
    }
}
