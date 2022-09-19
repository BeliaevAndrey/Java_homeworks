package task02Mdl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DataMgr {

    public static HashMap<String, LinkedHashMap<String, String[]>> persons = new LinkedHashMap<>();
    public static HashMap<String, String[]> phones = new LinkedHashMap<>();

    public static void reader() throws Exception {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Homework05", "data", "persons.csv");
        BufferedReader bufRdr = new BufferedReader(new FileReader(filePath.toString()));
        String record;
        while ((record = bufRdr.readLine()) != null) {
            if (!record.startsWith("id") && record.length() > 1) {
                parseAddLine(record);
            }
        }
    }

    public static void parseAddLine(String text) {

        LinkedHashMap<String, String[]> person = new LinkedHashMap<>();

        text = text.replace(",\"", ":").replace(",+", ":");
        text = text.replaceAll("\"", "").replaceAll(", ", ",");

        String[] parts = text.split(":");
        String[] tmp = parts[0].split(",");
        String name = String.format("%s %s %s", tmp[1], tmp[2], tmp[3]);
        String dscr = tmp[4];

        String[] phoneArr = parts[1].split(",");
//        String[] pers =  {name, dscr};
        person.put(tmp[0], new String[] {name, dscr});
        if (persons.containsKey(tmp[1])) {
            persons.get(tmp[1]).put(tmp[0], new String[] {name, dscr});
            phones.put(tmp[0], phoneArr);
        } else {
            persons.put(tmp[1], person);
            phones.put(tmp[0], phoneArr);
        }
    }

}
