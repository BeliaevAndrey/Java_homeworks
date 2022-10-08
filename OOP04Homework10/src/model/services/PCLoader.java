package model.services;

import computerCls.Memory;
import computerCls.extending.PC;

import java.util.Arrays;
import java.util.List;

public class PCLoader {

    public PCLoader() {
    }

    public void loadPCs(List<PC> pcList) {
        PC n1 = new PC("005", "Vist", Memory.ONE, "256", 300);
        PC n2 = new PC("020", "MiniTower", Memory.SIXTEEN, "512", 800);
        PC n3 = new PC("003", "MidiTower", Memory.SIXTEEN, "1024", 1200);
        pcList.addAll(Arrays.asList(n1, n2, n3));

    }
}
