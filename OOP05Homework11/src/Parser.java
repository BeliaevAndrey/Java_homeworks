import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class Parser {
    public static void main(String[] args) {
        Parser parser = new Parser();
        HashMap<String, List<String>> parts = new HashMap<>();
        parts.put("hdd", new ArrayList<>());
        parts.put("ssd", new ArrayList<>());
        parts.put("cpu", new ArrayList<>());
        parts.put("ram", new ArrayList<>());
        parts.put("chassis", new ArrayList<>());
        parts.put("vCard", new ArrayList<>());
        parts.put("powerSupply", new ArrayList<>());
        parts.put("motherBoard", new ArrayList<>());

        Logger log = Logger.getAnonymousLogger();
        Path dir = Paths.get(System.getProperty("user.dir"));
        String filePath = Paths.get(dir.toString(), "OOP05Homework11", "data", "Desten_price.csv").toString();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Процессор") &&
                        !line.contains("Процессоры") &&
                        !line.toLowerCase().contains("processor option kit")) {
                    parts.get("cpu").add(parser.parseLine(line, "Процессор"));
                } else if (line.contains("Память") || line.toLowerCase().contains("модуль памяти")) {
                    parts.get("ram").add(parser.parseLine(line, "амят").replace("амят", "Память"));
                } else if (line.contains("Накопитель SSD")) {
                    parts.get("ssd").add(parser.parseLine(line, "Накопитель SSD"));
                } else if (line.contains("Жесткий диск")) {
                    parts.get("hdd").add(parser.parseLine(line, "Жесткий диск"));
                } else if (line.contains("Видеокарта")) {
                    parts.get("vCard").add(parser.parseLine(line, "Видеокарта"));
                } else if (line.contains("Блок питания") && !line.contains("Блок питания для")) {
                    parts.get("powerSupply").add(parser.parseLine(line, "Блок питания"));
                } else if (line.contains("Корпус") && !line.contains("аксессуары")) {
                    parts.get("chassis").add(parser.parseLine(line, "Корпус"));
                } else if (line.contains("Материнская плата")) {
                    parts.get("motherBoard").add(parser.parseLine(line, "Материнская плата"));
                }
            }
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }
        for (Map.Entry<String, List<String>> item : parts.entrySet()) {
            System.out.println(item.getKey());
            for (String line : item.getValue()) {
                System.out.print("\t\t");
                System.out.println(line);
            }
        }
    }

    String parseLine(String lineIn, String startKey) {
        int start = 0;
        if (startKey.equals("амят"))    // rough crutch
            start = lineIn.lastIndexOf(startKey) + 5;
        else
            start = lineIn.lastIndexOf(startKey) + startKey.length();
        lineIn = lineIn.replace("\"", "");
        int end = lineIn.lastIndexOf(",1,");
        if (end < 0) end = lineIn.lastIndexOf(",,");

        return startKey + " " + lineIn.substring(start, end).strip();
    }


}
