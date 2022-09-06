import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class hundredTests {
    static void fileOut1() throws Exception {
        Logger log = Logger.getLogger("Hundred Tests");
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "Homework02", "data", "task01_1.txt");
        String word = "TEST";
        StringBuilder sb = new StringBuilder();
        try (FileWriter fw = new FileWriter(filePath.toString(), false)) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) sb.append(word);
                else sb.append(word.toLowerCase());
            }
            System.out.println("Writing...");
            fw.append(sb);
            fw.flush();
        } catch (Exception exc) {
            log.info(exc.getMessage());
        }
    }

    static void fileOut2() throws Exception {
        Logger log = Logger.getLogger("Hundred Tests");
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "Homework02", "data", "task01_2.txt");
        String word = "TEST";
        StringBuilder sb = new StringBuilder();
        word = String.join("", word, word.toLowerCase(), word, word.toLowerCase());
        try (FileWriter fw = new FileWriter(filePath.toString(), false)) {
            for (int i = 0; i < 25; i++) {
                sb.append(word);
            }
            System.out.println("Writing...");
            fw.append(sb);
            fw.flush();
        } catch (Exception exc) {
            log.info(exc.getMessage());
        }
    }
}
