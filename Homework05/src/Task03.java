import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class Task03 {

    static int[] arrayGenerator(int min, int len) {
        int[] rndArr = new int[len];

        for (int i = 0; i < len; i++) {
            rndArr[i] = min + i;
        }

        for (int i = 0; i < len - 1; i++) {
            int tmp = rndArr[i];
            int j = new Random().nextInt(i + 1, len);
            rndArr[i] = rndArr[j];
            rndArr[j] = tmp;
        }

        return rndArr;
    }


    static void sort(int[] arr) {
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            // initial heap
            makeHeap(arr, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            int tmp = arr[0];   // swap maximum and first elements
            arr[0] = arr[i];
            arr[i] = tmp;
            makeHeap(arr, 0, i);
        }
    }

    static void makeHeap(int[] arr, int index, int lim) {
        int root = index;
        int ltChild = root * 2 + 1;
        int rtChild = root * 2 + 2;

        if (ltChild < lim && arr[root] < arr[ltChild]) {    // a kind of crutch here to stay in bounds
            root = ltChild;
        }
        if (rtChild < lim && arr[root] < arr[rtChild]) {
            root = rtChild;
        }
        if (root != index) {
            int tmp = arr[root];
            arr[root] = arr[index];
            arr[index] = tmp;

            makeHeap(arr, root, lim);
        }

    }

    public static void main(String[] args) {

        Logger log = Logger.getAnonymousLogger(); // I really don't know what to log here

        int[] inArray = arrayGenerator(-10, 20);

        String msg = String.format("Массив на входе:\n%s\n", Arrays.toString(inArray));
        log.info(msg);
        sort(inArray);
        msg = String.format("Отсортированный массив:\n%s\n", Arrays.toString(inArray));
        log.info(msg);

    }
}

