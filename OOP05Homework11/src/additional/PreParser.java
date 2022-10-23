package additional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class PreParser {
    Logger log = Logger.getAnonymousLogger();
    HashMap<String, List<String>> parts = new HashMap<>();

    public PreParser() {
        this.parts.put("hdd", new ArrayList<>());
        this.parts.put("ssd", new ArrayList<>());
        this.parts.put("cpu", new ArrayList<>());
        this.parts.put("ram", new ArrayList<>());
        this.parts.put("chassis", new ArrayList<>());
        this.parts.put("vCard", new ArrayList<>());
        this.parts.put("powerSupply", new ArrayList<>());
        this.parts.put("mainBoard", new ArrayList<>());
    }

    void preParse() {
        PreParser preloader = new PreParser();
        ParseRegs parseRegs = new ParseRegs();
        Path dir = Paths.get(System.getProperty("user.dir"));
        String filePath = Paths.get(dir.toString(), "data", "Desten_price.csv").toString();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Процессор") &&
                        !line.contains("Процессоры") &&
                        !line.toLowerCase().contains("processor option") &&
                        !line.toLowerCase().contains("processor kit") &&
                        !line.toLowerCase().contains("dell") &&
                        !line.toLowerCase().contains("ibm") &&
                        !line.toLowerCase().contains("cpuxup") &&
                        !line.toLowerCase().contains("cpuxdp") &&
                        !line.toLowerCase().contains("cpuci") &&
                        !line.contains("HP")
                ) {
                    String cpuLine = (preloader.parseLine(line, "Процессор"));
                    this.parts.get("cpu").add(cpuLine);
                    if (Arrays.toString(parseRegs.parseCpuLine(cpuLine)).contains("null")) {
                        System.out.println(cpuLine);
                        System.out.println(Arrays.toString(parseRegs.parseCpuLine(cpuLine)));
                    }
                } else if (line.contains("Память") || line.toLowerCase().contains("модуль памяти")) {
                    this.parts.get("ram").add(preloader.parseLine(line, "амят").replace("амят", "Память"));
                } else if (line.contains("Накопитель SSD")) {
                    this.parts.get("ssd").add(preloader.parseLine(line, "Накопитель SSD"));
                } else if (line.contains("Жесткий диск")) {
                    this.parts.get("hdd").add(preloader.parseLine(line, "Жесткий диск"));
                } else if (line.contains("Видеокарта")) {
                    this.parts.get("vCard").add(preloader.parseLine(line, "Видеокарта"));
                } else if (line.contains("Блок питания") && !line.contains("Блок питания для")) {
                    this.parts.get("powerSupply").add(preloader.parseLine(line, "Блок питания"));
                } else if (line.contains("Tower") &&
                        !line.contains("аксессуары") &&
                        !line.contains("расшир")) {
                    this.parts.get("chassis").add(preloader.parseLine(line, "Корпус"));
                } else if (line.contains("Материнская плата")) {
                    this.parts.get("mainBoard").add(preloader.parseLine(line, "Материнская плата"));
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        for (Map.Entry<String, List<String>> item : this.parts.entrySet()) {
            System.out.println(item.getKey());
            if (item.getKey().equals("mainBoard")) {
                System.out.println("\n==============================\n");
                System.out.println(item.getValue().size());
                System.out.println("\n==============================\n");
//                for (String line : item.getValue()) {
//                    System.out.print("\t\t");
//                    System.out.println(line);

//                }
            }
        }
    }

    String parseLine(String lineIn, String startKey) {
        int start;
        if (startKey.equals("амят"))    // rough crutch
            start = lineIn.lastIndexOf(startKey) + 5;
        else
            start = lineIn.lastIndexOf(startKey) + startKey.length();
        lineIn = lineIn.replace("\"", "");
        int end = lineIn.lastIndexOf(",1,");
        if (end < 0) end = lineIn.lastIndexOf(",,");

        return startKey + " " + lineIn.substring(start, end).strip();
    }

    public HashMap<String, List<String>> getParts() {
        return this.parts;
    }


    public static void main(String[] args) {
        PreParser parser = new PreParser();
        parser.preParse();

    }
}

