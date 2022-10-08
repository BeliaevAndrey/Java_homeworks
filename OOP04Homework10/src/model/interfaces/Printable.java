package model.interfaces;

import computerCls.Computer;

import java.util.List;

public interface Printable<T extends Computer> {
    String printedVersion(List<T> unitList);

    void print(List<T> unitList);
}
