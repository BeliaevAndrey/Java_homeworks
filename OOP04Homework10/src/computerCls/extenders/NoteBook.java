package computerCls.extenders;// data

import computerCls.Computer;
import computerCls.Memory;

public class NoteBook extends Computer {

    private Integer BatteryCapacity;

    public NoteBook(String id, String model, Memory memory, String ssd, Integer BatteryCapacity) {
        super(id, model, memory, ssd);
        this.BatteryCapacity = BatteryCapacity;
    }



    public void setBatteryCapacity(Integer batteryCapacity) {
        BatteryCapacity = batteryCapacity;
    }

    public Integer getBatteryCapacity() {
        return BatteryCapacity;
    }

    @Override
    public String toString() {
        return "Notebook id=" + id + ", " +
                "model: \"" + model + "\", " +
                "memory: " + memory + " GB, " +
                "SSD:" + ssd + " GB, " +
                "Battery: " + BatteryCapacity + " mAh";
    }

}