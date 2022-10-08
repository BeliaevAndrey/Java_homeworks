package model.services;

import computerCls.Memory;
import computerCls.extenders.PC;

import java.util.Arrays;
import java.util.List;

public class PCLoader {

    public PCLoader() {
    }

    public void loadPCs(List<PC> pcList) {
        PC n1 = new PC("005", "FullTower", Memory.SIXTEEN, "1024", 1200);
        PC n2 = new PC("020", "MiniTower", Memory.FOUR, "256", 300);
        PC n3 = new PC("023", "MidiTower", Memory.SIXTEEN, "1024", 800);
        PC n4 = new PC("001", "Dell", Memory.SIX, "512", 600);
        pcList.addAll(Arrays.asList(n1, n2, n3, n4));

    }
}
