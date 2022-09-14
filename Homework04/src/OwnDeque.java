import java.util.Arrays;

public class OwnDeque {

    int[] data;
    private final int fixedLength = 5;
    OwnDeque() {
        data = new int[0];
    }

    OwnDeque(int[] init) {
        if (init.length > fixedLength)
            throw new IllegalArgumentException("5 elements limit exceeded!");
        data = init.clone();
    }

    boolean offerFirst(int candidate) {
        if (data.length < fixedLength) {
            int[] tmp = data.clone();
            data = new int[data.length + 1];
            data[0] = candidate;
            System.arraycopy(tmp, 0, data, 1, tmp.length);
            return true;
        }
        return false;
    }

    boolean offerLast(int candidate) {
        if (data.length < fixedLength) {
            int[] tmp = data.clone();
            data = new int[data.length + 1];
            System.arraycopy(tmp, 0, data, 0, tmp.length);
            data[data.length - 1] = candidate;
            return true;
        }
        return false;
    }

    Integer peekFirst() {
        if (data.length == 0) return null;
        return data[0];
    }

    Integer peekLast() {
        if (data.length == 0) return null;
        return data[data.length - 1];
    }

    Integer pollFirst() {
        if (data.length == 0) return null;
        int value = data[0];

        data = Arrays.copyOfRange(data, 1, data.length);
        return value;
    }

    Integer pollLast() {
        if (data.length == 0) return null;
        int value = data[data.length - 1];
        data = Arrays.copyOf(data, data.length - 1);
        return value;
    }


}
