package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PreloaderBckp {
    HashMap<String, List<String>> parts = new HashMap<>();

        public static void main(String[] args) {
        PreloaderBckp parse = new PreloaderBckp();
        parse.parser();
    }
    public PreloaderBckp() {
    }

    public void parser() {
        PreloaderBckp preloader = new PreloaderBckp();
        this.parts.put("hdd", new ArrayList<>());
        this.parts.put("ssd", new ArrayList<>());
        this.parts.put("cpu", new ArrayList<>());
        this.parts.put("ram", new ArrayList<>());
        this.parts.put("chassis", new ArrayList<>());
        this.parts.put("vCard", new ArrayList<>());
        this.parts.put("powerSupply", new ArrayList<>());
        this.parts.put("mainBoard", new ArrayList<>());

        Logger log = Logger.getAnonymousLogger();
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
                        !line.toLowerCase().contains("cpux[du]p") &&
                        !line.contains("HP")
                ) {
                    this.parts.get("cpu").add(preloader.parseLine(line, "Процессор"));
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
                } else if (line.contains("Tower") && !line.contains("аксессуары")) {
                    this.parts.get("chassis").add(preloader.parseLine(line, "Корпус"));
                } else if (line.contains("Материнская плата")) {
                    this.parts.get("mainBoard").add(preloader.parseLine(line, "Материнская плата"));
                }
            }
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }
        for (Map.Entry<String, List<String>> item : this.parts.entrySet()) {
            System.out.println(item.getKey());
            for (String line : item.getValue()) {

//                    parser.searchSock(line);
                System.out.print("\t\t");
                System.out.println(line);

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
//    void searchSock(String lineIn) {
//        Pattern p = Pattern.compile("[S] ?[0-5]{4}");
//        Pattern p2 = Pattern.compile("Socket[ -]?[0-5, 475, 945]{4}");
////        Pattern p3 = Pattern.compile("Socket[ -]?AM[2-4]+?");
//        Pattern p4 = Pattern.compile("AM[2-4]+?");
//
//        Matcher m = p.matcher(lineIn);
//        Matcher m2 = p2.matcher(lineIn);
////        Matcher m3 = p3.matcher(lineIn);
//        Matcher m4 = p4.matcher(lineIn);
//        if (m.find()) {
//            if (lineIn.contains("Материнская плата"))
//                socketsMb.add(lineIn.substring(m.start(), m.end()));
//            else if (lineIn.contains("Процессор"))
//                socketsCpu.add(lineIn.substring(m.start(), m.end()));
//        }
//        if (m2.find()) {
//            if (lineIn.contains("Материнская плата"))
//                socketsMb.add(lineIn.substring(m2.start(), m2.end()));
//            else if (lineIn.contains("Процессор"))
//                socketsMb.add(lineIn.substring(m2.start(), m2.end()));
//        }
////        else if (m3.find()) {
////            if(lineIn.contains("Материнская плата"))
////                socketsMb.add(lineIn.substring(m3.start(), m3.end()));
////            else if(lineIn.contains("Процессор"))
////                socketsMb.add(lineIn.substring(m3.start(), m3.end()));
////        }
//        if (m4.find()) {
//            if (lineIn.contains("Материнская плата"))
//                socketsMb.add(lineIn.substring(m4.start(), m4.end()));
//            else if (lineIn.contains("Процессор"))
//                socketsMb.add(lineIn.substring(m4.start(), m4.end()));
//        }
//    }


}
