import java.util.logging.Logger;

public class Program02 {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Program02");
        System.out.println("Starting Task 01 \"Hundred Tests\"");
        long sTime = System.nanoTime();
        try {
            hundredTests.fileOut1();
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }
        System.out.println(System.nanoTime() - sTime);
        sTime = System.nanoTime();
        try {
            hundredTests.fileOut2();
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }
        System.out.println(System.nanoTime() - sTime);
        System.out.println("Starting Task 02 \"Students\"");
        try {
            students.parseFile("students.txt");
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }

    }
}