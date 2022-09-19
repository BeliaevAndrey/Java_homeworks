package task02Mdl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Searcher {
    public static void search(String surname, Scanner scn) throws Exception {
        System.out.println("Ищем: " + surname);
        if (!DataMgr.persons.containsKey(surname)) {
            System.out.println("Искома персона не найдена.");
        } else {
            int count = 0;
            HashMap<Integer, String[]> pair = new HashMap<>();
            for (Map.Entry<String, String[]> item : DataMgr.persons.get(surname).entrySet()) {
                count++;
                pair.put(count, new String[]{item.getKey(), item.getValue()[0], item.getValue()[1]});
                System.out.printf("(%d) %s\n", count, item.getValue()[0]);
            }
            int persNum = 1;
            if (count > 1) {
                System.out.println("(0) Выход\n");
                System.out.print("Выберите искомую персону\n_>");
                while (true) {
                    if (scn.hasNextInt()) {
                        persNum = scn.nextInt();
                        if (persNum <= count) break;
                    } else {
                        System.out.println("Неверный ввод");
                        break;
                    }
                    scn.reset();
                }
            }
            if (persNum != 0) {
                System.out.printf("%s\n%s\n", pair.get(persNum)[1], pair.get(persNum)[2]);
                System.out.printf("%s\n", Arrays.toString(DataMgr.phones.get(pair.get(persNum)[0])));
            }
        }

    }
}
