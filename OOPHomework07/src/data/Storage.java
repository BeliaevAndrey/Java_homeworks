package data;

import cls.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    static List<Product> assort = new ArrayList<>();

    public static void generate(){

        assort.add(new Chocolate("Twix", 20, 140, 10));
        assort.add(new Chocolate("Snickers", 30, 150, 10));
        assort.add(new Chocolate("Bounty", 25, 120, 10));
        assort.add(new Chocolate("KitKat", 15, 140, 10));

        assort.add(new Drinks("Архыз", 35, 0.5, 10));
        assort.add(new Drinks("Боржоми", 45, 0.5, 10));
        assort.add(new Drinks("Буратина", 20, 0.33, 10));
        assort.add(new Drinks("Мальвина", 20, 0.5, 10));

        assort.add(new Chips("Pringles", 45, 80, 10));
        assort.add(new Chips("С луком", 20, 120, 10));
        assort.add(new Chips("С солью", 20, 100, 10));

    }

    public static List<Product> getAssort() {
        return assort;
    }
}
