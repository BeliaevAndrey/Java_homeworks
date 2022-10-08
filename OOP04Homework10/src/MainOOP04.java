import computerCls.Computer;
import model.Controller;

import java.util.Scanner;

public class MainOOP04 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Controller controller = new Controller();

        sb.append("В нашей базе есть ноутебуки:\n");
        sb.append(controller.printNotebooks());

        sb.append("\nВ нашей базе есть системные блоки:\n");
        sb.append(controller.printPCs());

        System.out.println(sb);

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Введите поле, по которому хотите выполнить поиск ноутбука: ");
            String userAnswerFilterField = input.next();
            System.out.println("Введите значение, введённого ранее поля, по которому хотите выполнить поиск ноутбука: ");
            String userAnswerFilterValue = input.next();
        }

//        System.out.println(controller.getSortedNotebookById(al));

    }
}
