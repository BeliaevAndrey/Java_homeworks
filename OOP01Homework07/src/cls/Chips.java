package cls;

public class Chips extends Product{

    public Chips(String name, double cost, double weight, int amount) {
        super(name, cost, weight, amount);
        super.setType("Чипсы");
    }
}
