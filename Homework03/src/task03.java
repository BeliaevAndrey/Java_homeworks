/**
 * Задан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее из этого списка.
 */

import java.util.ArrayList;
import java.util.List;

public class task03 {

    static List<Object> searchMinMax(List<Integer> listIn) {
        List<Object> result = new ArrayList<>();
        int maxElement = 0, minElement = 0;
        double meanValue = 0;
        for (int element : listIn) {
            if (maxElement < element) maxElement = element;
            if (minElement > element) minElement = element;
            meanValue += (double) element;

        }
        meanValue /= listIn.size();
        result.add(maxElement);
        result.add(minElement);
        result.add(meanValue);
        return result;
    }

}
