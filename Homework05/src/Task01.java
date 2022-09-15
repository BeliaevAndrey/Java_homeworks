/**
 * Задание 1
 * <p>
 * Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
 * Строки с одинаковой длиной не должны “потеряться”.
 * Пример:
 * “Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись”
 * Результат:
 * [и], [ты], [Еще], [день, друг, Пора], [Мороз], [солнце], [чудесный, дремлешь, проснись], [красавица], [прелестный]
 */

import java.util.ArrayList;
import java.util.TreeMap;

public class Task01 {

    public static void main(String[] args) {
        String aLine = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        System.out.println(counter(aLine).values());
    }

    static TreeMap<Integer, ArrayList<String>> counter(String s) {
        TreeMap<Integer, ArrayList<String>> tm = new TreeMap<>();
        String[] localList = s.split(" ");
        for (String word : localList) {
            int key = word.length();
            if (tm.containsKey(key)) {
                tm.get(key).add(word);
            } else {
                tm.put(key, new ArrayList<>());
                tm.get(key).add(word);
            }
        }
        return tm;
    }
}


