import task02Mdl.DataMgr;
import task02Mdl.Printer;
import task02Mdl.Searcher;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Task02 {

    static Scanner scn = new Scanner(System.in);


    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();

        try {
            Path logPath = Paths.get(System.getProperty("user.dir"), "Homework05", "data", "logOutput.log");
            FileHandler fh = new FileHandler(logPath.toString(), true);
            logger.addHandler(fh);

        } catch (Exception exc1) {
            logger.warning(exc1.getMessage());
        }
        try {
            DataMgr.reader();
        } catch (Exception exc2) {
            logger.warning(exc2.getMessage());
        }

        menu(logger);
        scn.close();
    }

    static void menu(Logger logger) {
        String cList = "\n(P)rint whole book\n(S)earch\n(L)ist commands\n(E)xit\n";
        String cPrompt = "\nВведите команду (l - список доступных команд)\n_> ";
        System.out.println(cList);
        String command;
        do {
            System.out.print(cPrompt);
            command = scn.next();
            switch (command) {
                case "P":
                case "p":
                    Printer.printPhoneBk();
                    break;
                case "S":
                case "s":
                    try {
                        Searcher.search(readLine(), scn);
                    } catch (Exception exc3) {
                        logger.warning(exc3.getMessage());
                    }
                    break;
                case "L":
                case "l":
                    System.out.println(cList);
                    break;
                case "E":
                case "e":
                    System.out.println("Всего хорошего!");
                    break;
                default:
                    System.out.println("Команда не распознана.");
                    break;
            }
            scn.reset();

        } while (!command.equalsIgnoreCase("E"));
    }

    static String readLine() {
        // This method might be extended
        System.out.print("\nВведите фамилию, или ФИО для поиска:\n_> ");
        String input = scn.next();
        return input;
    }


}

