import computerCls.Computer;
import computerCls.Memory;
import computerCls.extending.NoteBook;
import computerCls.extending.PC;
import model.Controller;

import java.util.Scanner;

public class MainOOP04 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Controller controller = new Controller();

        sb.append("В нашей базе есть вот эти нотебяки:\n");

        for (Computer ntb : controller.getNotebooks()){
            sb.append(ntb).append("\n");
        }

        sb.append("\nи ещё такие писюки:\n");

        for (Computer pc : controller.getPcComputers()){
            sb.append(pc.toString()).append("\n");
        }

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
