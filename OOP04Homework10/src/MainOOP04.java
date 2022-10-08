import model.Controller;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainOOP04 {
    public static void main(String[] args) {
        MainOOP04 mLever = new MainOOP04();
        Logger logger = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        Controller controller = new Controller();

        sb.append("\nВ нашей базе есть ноутбуки:\n");
        sb.append(controller.printNotebooks());
        sb.append("\nВ нашей базе есть системные блоки:\n");
        sb.append(controller.printPCs());
        logger.info(sb.toString());
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Что будем искать? Notebooks или PC: ");
            String deviceSection = input.next();
            input.reset();
            mLever.chooser(deviceSection, logger, controller);
        }

    }

    void chooser(String deviceSection, Logger logger, Controller controller) {
        String[] fields;
        switch (deviceSection) {
            case "Notebooks":
            case "notebooks":
                fields = askField();
                logger.info(controller.filterNotebooks(fields[0], fields[1]));
                break;
            case "PC":
            case "pc":
                fields = askField();
                logger.info(controller.filterPCs(fields[0], fields[1]));
                break;
            default:
                throw new IllegalStateException("Wrong search area");
        }
    }

    String[] askField() {
        String[] response = new String[2];
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите поле, по которому хотите выполнить поиск устройства: ");
            response[0] = input.nextLine();
            System.out.print("Введите значение, введённого ранее поля, по которому хотите выполнить поиск устройства: ");
            response[1] = input.nextLine();
            input.reset();
        }
        return response;
    }

}
