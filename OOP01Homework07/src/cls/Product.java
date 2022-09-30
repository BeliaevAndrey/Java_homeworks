package cls;

public abstract class Product {
    protected String name;
    protected String type;
    protected double cost;
    protected double quantity;
    protected int amount;

    Product(String name, double cost, double weight, int amount) {
        this.setCost(cost);
        this.setName(name);
        this.setQuantity(weight);
        this.setAmount(amount);
    }

    public void decreaseAmt() {
        this.amount--;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    void setCost(double cost) {
        this.cost = cost;
    }

    void setName(String name) {
        this.name = name;
    }

    void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    void setType(String type) {
        this.type = type;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s \"%s\" (%.2f г.): %.2f р.",
                this.type,
                this.name,
                this.quantity,
                this.cost);
    }

}
