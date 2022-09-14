import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task01DequeEntity {

    public static void main(String[] args) {

        Logger log = Logger.getAnonymousLogger();

        OwnDeque firstVar = new OwnDeque(new int[]{1, 2, 3, 4, 5});
        System.out.printf("firstVar.data:          %s\n", Arrays.toString(firstVar.data));
        System.out.printf("firstVar.peekFirst():   %s\n", firstVar.peekFirst());
        System.out.printf("firstVar.peekLast():    %s\n", firstVar.peekLast());
        System.out.printf("firstVar.pollFirst():   %s\n", firstVar.pollFirst());
        System.out.printf("firstVar.pollLast():    %s\n", firstVar.pollLast());
        System.out.printf("firstVar.data:          %s\n", Arrays.toString(firstVar.data));
        System.out.printf("firstVar.offerFirst(5): %s\n", firstVar.offerFirst(5));
        System.out.printf("firstVar.offerLast(1):  %s\n", firstVar.offerLast(1));
        System.out.printf("firstVar.offerFirst(6): %s\n", firstVar.offerFirst(4)); // length limit exceeding, false
        System.out.printf("firstVar.offerLast(7):  %s\n", firstVar.offerLast(5));
        System.out.printf("firstVar.data:          %s\n", Arrays.toString(firstVar.data));

        OwnDeque secondVar = new OwnDeque();
        System.out.printf("secondVar.data:        %s\n", Arrays.toString(secondVar.data));
        for (int i = 9; i > 0; i--)
            System.out.printf("secondVar.offerLast(%d): %s\n", i, secondVar.offerLast(i));
        System.out.printf("secondVar.data:          %s\n", Arrays.toString(secondVar.data));
        for (int i = 0; i < 10; i++) {
            System.out.printf("secondVar.peekFirst(): %s\n", secondVar.peekFirst());
            System.out.printf("secondVar.pollFirst(): %s\n", secondVar.pollFirst());
        }
        try {
            System.out.println("Creating of wittingly length-limit exceeding array");
            OwnDeque third = new OwnDeque(new int[]{10, 20, 30, 40, 50, 60, 70});
        } catch (Exception exc) {
            log.log(Level.WARNING, exc.getMessage());
        }

    }
}
