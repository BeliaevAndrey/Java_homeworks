package model;

import computerCls.Computer;

import java.util.List;

public interface Printable<T extends Computer> {
    String printedVersion(List<T> unitList);
}
