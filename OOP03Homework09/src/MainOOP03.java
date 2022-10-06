import people.Human;
import people.Relatives;
import service.Controller;
import service.LoaderSvc;
import service.ViewSvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainOOP03 {

    Scanner scn = new Scanner(System.in);
    List<Human> humans = new ArrayList<>();
    List<Relatives> bloodline = new ArrayList<>();

    public static void main(String[] args) {
        MainOOP03 m = new MainOOP03();
        LoaderSvc ls = new LoaderSvc();
        Controller cnt = new Controller();
        ls.loader(m.humans, m.bloodline);
        cnt.buildTree(m.humans.get(0), m.bloodline);
        m.menu(m.scn, cnt);

        m.scn.close();
    }

    void menu(Scanner mScn, Controller mCnt) {
        ViewSvc vs = new ViewSvc();
        String choice;
        do {
            vs.printMenu();
            choice = mScn.next();
            switch (choice) {
                case "1":
                    vs.printTree(mCnt.tree);
                    break;
                case "2":
                    vs.printFullHumanList(humans);
                    break;
                case "3":
                    vs.printFullRelativesList(bloodline);
                    break;
                case "4":
                    searchMenu(mScn, vs, mCnt);
                    break;
                case "5":
                    break;
                case "0":
                    choice = "exit";
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
            scn.reset();
        } while (!choice.equals("exit"));
    }

    void searchMenu(Scanner mScn, ViewSvc vs, Controller mCnt) {
        System.out.print("Enter surname: ");
        String surname = mScn.next();
        System.out.print("Enter name: ");
        String name = mScn.next();
        List<Relatives> tmp = mCnt.search(bloodline, surname, name);
        if (tmp.size() > 0)
            vs.printFullRelativesList(tmp);
        else System.out.println("Nobody found");
        mScn.reset();

    }
}
