package model;

import computerCls.extending.NoteBook;
import computerCls.extending.PC;
import model.services.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final List<NoteBook> notebooks = new ArrayList<>();
    private final List<PC> pcComputers = new ArrayList<>();

    public Controller() {
        NotebookLoader loadNotebooks = new NotebookLoader();
        PCLoader loadPCs = new PCLoader();

        loadNotebooks.loadNtb(notebooks);
        loadPCs.loadPCs(pcComputers);
    }

    public String printNotebooks() {
        NotebookService ntbSvc = new NotebookService();
        return ntbSvc.printedVersion(notebooks);
    }

    public String printPCs() {
        PCService pcSvc = new PCService();
        return pcSvc.printedVersion(pcComputers);
    }

    public List<NoteBook> getNotebooks() {
        return notebooks;
    }

    public List<PC> getPcComputers() {
        return pcComputers;
    }

    public List<NoteBook> filterNotebooks(String field, String request) {
        NotebookFilterService nfs = new NotebookFilterService();
        return nfs.commonFilter(notebooks, field, request);
    }
}
