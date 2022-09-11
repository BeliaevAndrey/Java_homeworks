import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Program {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        Logger log = Logger.getAnonymousLogger();
        FileHandler fh = new FileHandler("log.txt", true);
        SimpleFormatter sFmt = new SimpleFormatter();
        fh.setFormatter(sFmt);
        log.addHandler(fh);
        System.out.println("Задача 01");
        try {
            List<Integer> localList = task02.arrToList(task02.filler());      // Create and convert new test array
            System.out.printf("Список для задачи 01: %s\n", localList);
            System.out.printf("Список после сортировки: %s\n", task01.sorter(localList));
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }


        try {
            System.out.println("\nЗадача 02");
            List<Integer> localList = task02.arrToList(task02.filler());
            System.out.printf("Список для задачи 02: %s\n", localList);
            System.out.printf("Список, пересборка без четных: %s\n", task02.evenRemover2(localList));
            System.out.printf("Список после удаления четных: %s\n", task02.evenRemover(localList));     // Remove evens and print out
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }

        try {
            System.out.println("\nЗадача 03");
            List<Integer> localList = task02.arrToList(task02.filler());
            System.out.printf("Список для задачи 03: %s\n", localList);
            List<Object> tmp = task03.searchMinMax(localList);
            System.out.printf("Максимальное: %s " +
                            "\nМинимальное: %s" +
                            "\nСредннее арифметическое: %s\n",
                    tmp.get(0), tmp.get(1), tmp.get(2));
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }

        input.close();
    }


}

