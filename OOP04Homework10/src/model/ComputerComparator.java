package model;

import computerCls.Computer;

import java.util.Comparator;

public class ComputerComparator implements Comparator<Computer> {

    public ComputerComparator(){
    }

    @Override
    public int compare(Computer o1, Computer o2) {
        if (Integer.valueOf(o1.getId()) > Integer.valueOf(o2.getId())) return 1;
        if (Integer.valueOf(o1.getId()) < Integer.valueOf(o2.getId())) return -1;
        return 0;
    }

}
