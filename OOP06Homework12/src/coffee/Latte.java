package coffee;


public class Latte extends Espresso {

    private String milk = "";
    private String milkFoam = "";
    private boolean sugar = false;

    public Latte(Espresso espresso) {
        this.waterVol = espresso.getWaterVol();
        this.coffeeAmt = espresso.getCoffeeAmt();
    }

    public Latte(Espresso espresso, boolean sugar) {
        this.waterVol = espresso.getWaterVol();
        this.coffeeAmt = espresso.getCoffeeAmt();
        this.sugar = sugar;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public void setMilkFoam(String milkFoam) {
        this.milkFoam = milkFoam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLatte: 200 ml. Including:\n");
        sb.append(String.format("Espresso: vol %d ml (coffee: %d g.)",
                this.waterVol, this.coffeeAmt)).append("\n");

        if (sugar) sb.append("Sugar.").append("\n");

        sb.append(milk).append("\n");
        sb.append(milkFoam);
        return sb.toString();
    }

}
