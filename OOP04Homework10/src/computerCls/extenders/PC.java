package computerCls.extenders;

import computerCls.Computer;
import computerCls.Memory;

public class PC extends Computer {
    private Integer powerSupply;

    public PC(String id, String model, Memory memory, String ssd, Integer powerSupply) {
        super(id, model, memory, ssd);
        this.powerSupply = powerSupply;
    }

    public void setPowerSupply(Integer powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Integer getPowerSupply() {
        return powerSupply;
    }

    @Override
    public String toString() {
        return "PC id=" + id + ", " +
                "model: \"" + model + "\", " +
                "memory: " + memory + " GB, " +
                "SSD:" + ssd + " GB, " +
                "Power Supply: " + powerSupply + " W";
    }

}

