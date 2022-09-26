package cls;

public class Drinks extends Product {

    public Drinks(String name, double cost, double weight, int amount) {
        super(name, cost, weight, amount);
        super.setType("Напиток");
    }

    @Override
    public String toString() {
        return String.format("%s \"%s\" (%.2f л.): %.2f р.",
                super.type,
                super.name,
                super.quantity,
                super.cost);
    }
}
