/**
 * Реализовать алгоритм сортировки слиянием
 */
import java.util.ArrayList;
import java.util.List;

public class task01 {

    static List<Integer> merger(List<Integer> ltPart, List<Integer> rtPart) {
        List<Integer> listOut = new ArrayList<>();
        List<Integer> ltCopy = new ArrayList<>(ltPart);
        List<Integer> rtCopy = new ArrayList<>(rtPart);
        while (ltCopy.size() > 0 && rtCopy.size() > 0) {
            if (ltCopy.get(0) <= rtCopy.get(0)) {
                listOut.add(ltCopy.remove(0));
            } else if (ltCopy.get(0) > rtCopy.get(0)) {
                listOut.add(rtCopy.remove(0));
            }
        }
        listOut.addAll(ltCopy);
        listOut.addAll(rtCopy);
        return listOut;
    }

    static List<Integer> sorter(List<Integer> listIn) {
        int len = listIn.size();
        if (len < 2) {
            return listIn;
        }
        List<Integer> ltPart = listIn.subList(0, len / 2);
        List<Integer> rtPart = listIn.subList(len / 2, len);
        return merger(sorter(ltPart), sorter(rtPart));

    }

}

