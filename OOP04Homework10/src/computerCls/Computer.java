package computerCls;

public abstract class Computer {
    protected String id;
    protected String model;
    protected Memory memory;
    protected String ssd;

    public Computer(String id, String model, Memory memory, String ssd) {
        this.id = id;
        this.model = model;
        this.memory = memory;
        this.ssd = ssd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMemory(String memory) {
        this.memory = Memory.valueOf(memory);
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMemory() {
        return memory.name();
    }

    public String getSsd() {
        return ssd;
    }
}
