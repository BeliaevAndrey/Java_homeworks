/**
 * Пусть дан произвольный список(ArrayList) целых чисел, удалить из него четные числа
 */
import java.util.*;

public class task02 {

    static List<Integer> evenRemover2(List<Integer> listIn) {
        List<Integer> result = new ArrayList<>();
        for (int element : listIn)
            if (element % 2 != 0) result.add(element);
        return result;
    }

    static List<Integer> evenRemover(List<Integer> listIn) {
        listIn.removeIf(e -> e % 2 == 0);
        return listIn;
    }

    static int[] filler() {
        int ln;
        System.out.print("Введите длину массива: ");
        if (Program.input.hasNextInt())
            ln = Program.input.nextInt();
        else {
            System.out.println("Неверный ввод. Принимается длина массива 10");
            ln = 10;
            Program.input.next();
        }
        int[] array = new int[ln];
        Random rnd = new Random();
        for (int i = 0; i < ln; i++) {
            array[i] = rnd.nextInt(21) - 10;
//            array[i] += array[i] * (-2) * rnd.nextInt(2);
        }
        return array;
    }

    static List<Integer> arrToList(int[] arr) {
        List<Integer> converted = new ArrayList<>();
        for (int element : arr) {
            converted.add(element);
        }

        return converted;
    }


//    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 3, 4, 5, 7, 7, 8, 9};         // Test array

//        System.out.println(Arrays.toString(arr));
//        System.out.println(evenRemover(arrToList(arr)));     // Remove odds roms test array converted to List
//        System.out.println();
//    }
}
