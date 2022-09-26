package svc;

import cls.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ViewSvc {
    public void printWholeList(HashMap<String, HashMap<String, Product>> products) {
        System.out.println("Витрина:\n");
        for (Map.Entry<String, HashMap<String, Product>> item : products.entrySet()) {
            System.out.println(item.getKey());
            System.out.println("-".repeat(40));
            for (Map.Entry<String, Product> subItem : products.get(item.getKey()).entrySet()) {
                System.out.println(subItem.getValue());
            }
            System.out.println();
        }
    }

    public void printSubList(String line) {
        System.out.println(line);
    }

    public String choice(String menuLine, Scanner scn) {
        System.out.print(menuLine + "\n_> ");
        String input = scn.next();
        scn.reset();
        return input;
    }

}


