package computerCls;

import java.util.List;

public interface Sortable<T extends Computer> {

    List<T> sort(List<T> list);


}
