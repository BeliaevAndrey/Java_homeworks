import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class students {
    static void parseFile(String fileName) throws Exception {
        Logger log = Logger.getLogger("Students");
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "Homework02", "data", fileName);
        BufferedReader bRead = new BufferedReader(new FileReader(filePath.toString()));
        String line;
        while ((line = bRead.readLine()) != null) {
            if (!line.isBlank()) {
                String[] tmp = line.split(" +");
                int mark = Integer.parseInt(tmp[3]);
                String outLine = String.format("Ученик %s получил сегодня %d.", tmp[1], mark);
                log.info(outLine);
            }
        }
        bRead.close();
    }
}
