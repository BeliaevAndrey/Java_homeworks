package task02Mdl;

import java.util.Arrays;
import java.util.Map;

public class Printer {
    public static void printPhoneBk() {
        for (Map<String, String[]> item : DataMgr.persons.values()) {
//            unpack(item);
            System.out.println("==================================================");
            for (Map.Entry<String, String[]> list : item.entrySet()) {
                System.out.println(Arrays.toString(list.getValue()));
                System.out.println(Arrays.toString(DataMgr.phones.get(list.getKey())));
                System.out.println();
            }

        }
    }

}
