package model.interfaces;

import computerCls.Computer;

import java.util.List;

public interface Sortable<T extends Computer> {

    List<T> sortUnitsById(List<T> list);

}
