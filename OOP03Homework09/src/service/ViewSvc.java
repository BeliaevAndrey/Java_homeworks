package service;

import people.Human;
import people.Relations;
import people.Relatives;

import java.util.Deque;
import java.util.List;

public class ViewSvc {
    public void printTree(List<Relatives> list) {
        for (Relatives r : list) {
            if (r.getR().equals(Relations.FATHER)) {
                System.out.print("||    |\n||    |____");
                System.out.println(r.getR() + " of " + r.getSecond());
            } else {
                System.out.print("||\n||_");
                System.out.println(r);
            }
        }
    }

    public void printFullRelativesList(List<Relatives> rtlList) {
        for (Relatives pair : rtlList)
            System.out.println(pair);
    }

    public void printFullHumanList(List<Human> pplList) {
        for (Human person : pplList)
            System.out.println(person);
    }

    public void printMenu() {
        String menuLine = "\n\n" +
                "Enter your choice:\n" +
                "1: Print Tree\n" +
                "2: Print Full Human List\n" +
                "3: Print Full Relatives List\n" +
                "4: Search person and Print Relations\n" +
                "0: Exit\n" + "_> ";


        System.out.print(menuLine);
    }
}
