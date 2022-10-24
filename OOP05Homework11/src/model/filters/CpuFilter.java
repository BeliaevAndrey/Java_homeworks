package model.filters;

import classes.partClasses.Cpu;
import classes.partClasses.Part;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class CpuFilter {

    public HashMap<Integer, Part> brandFilter(List<Cpu> cpuPreFilteredList, String brand) {
        HashMap<Integer, Part> brandLine = new HashMap<>();
        int counter = 0;
        for (Cpu proc : cpuPreFilteredList) {
            if (proc.getBrand().toLowerCase().contains(brand.toLowerCase()))
                brandLine.put(++counter, (Part)proc);
        }
        return brandLine;
    }


    HashMap<Integer, Cpu> socketFilter(List<Cpu> cpuPreFilteredList, String socket) {
        HashMap<Integer, Cpu> socketLine = new HashMap<>();
        int counter = 0;
        for (Cpu proc : cpuPreFilteredList) {
            if (proc.getSocket().contains(socket))
                socketLine.put(++counter, proc);
        }
        return socketLine;
    }
}
