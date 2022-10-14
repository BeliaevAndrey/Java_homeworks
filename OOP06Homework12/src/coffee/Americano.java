package coffee;

public class Americano extends Espresso{

    private boolean sugar = false;

    public Americano(Espresso espresso) {
        this.waterVol = espresso.getWaterVol();
        this.coffeeAmt = espresso.getCoffeeAmt();
    }

    public Americano(Espresso espresso, boolean sugar) {
        this.waterVol = espresso.getWaterVol();
        this.coffeeAmt = espresso.getCoffeeAmt();
        this.sugar = sugar;
    }

    public void setWater(int water) {
        this.waterVol += water;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAmericano: 200 ml. Including:\n");
        sb.append(String.format("Water: vol %d ml\nCoffee: %d g.",
                this.waterVol, this.coffeeAmt)).append("\n");

        if (sugar) sb.append("Sugar.").append("\n");

        return sb.toString();
    }

}
