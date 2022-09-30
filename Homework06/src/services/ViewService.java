package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class ViewService {


    String greetText =
            "Программа предоставляет список ноутбуков." + "\n" +
            "Список позаимствован с сайта www.notik.ru" + "\n" +
            "в тренировочных целях.";
    String menuText =
            "(P)rint     Распечатать весь список" + "\n" +
            "(F)ilter    Фильтровать по параметрам" + "\n" +
            "(E)xit      Выход";

    String filterText =
            "Фильтровать по:" + "\n" +
            "(P)rocessor     Процессору" + "\n" +
            "(R)AM           Объему оперативной памяти" + "\n" +
            "(D)sik          Объему НЖМД (ТТД)" + "\n" +
            "(B)rand         Производителю" + "\n" +
            "(O)s            Операционной системе" + "\n" +
            "(C)olor         Цвету" + "\n" +
            "(E)xit          Выход";

    static Map<String, String> menus = new HashMap<>();

    public void init() {
        System.out.println(greetText);
        menus.put("filter", filterText);
        menus.put("mainMenu", menuText);
    }

    public void printMenu(String menuItem) {
        System.out.println(menus.get(menuItem));
        System.out.print("_> ");
    }

    public int printFilterSelect(HashMap<Integer, String> menuList, Scanner localScn, Logger logger) {
        while (true) {
            for (Map.Entry<Integer, String> entry : menuList.entrySet()) {
                System.out.printf("%2d: %s\n", entry.getKey(), entry.getValue());
            }
            System.out.println(" 0: Выход");
            System.out.print("_> ");
            localScn.reset();
            try {
                int selection = localScn.nextInt();
                localScn.reset();
                return selection;
            } catch (Exception excPFL) {
                localScn.nextLine();
                System.out.println("Неверный ввод");
                logger.warning("Неверный ввод" + excPFL.getMessage());
            }
        }
    }

    public void printNotebookSet(HashSet<Notebook> notebooksSet) {
        for (Notebook notebook : notebooksSet) {
            System.out.println(notebook.toString());
        }
        System.out.println("\n\n");
    }
}
