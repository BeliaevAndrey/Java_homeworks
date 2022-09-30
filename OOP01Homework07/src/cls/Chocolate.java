package cls;

public class Chocolate extends Product {

    public Chocolate(String name, double cost, double weight, int amount) {
        super(name, cost, weight, amount);
        super.setType("Шоколад");
    }

}
