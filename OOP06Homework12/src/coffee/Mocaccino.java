package coffee;

public class Mocaccino extends Espresso{

    private String milk = "";
    private String chocolateChips = "";
    private String milkFoam = "";
    private boolean sugar = false;

    public Mocaccino(Espresso espresso) {
        this.waterVol = espresso.getWaterVol();
        this.coffeeAmt = espresso.getCoffeeAmt();
    }

    public Mocaccino(Espresso espresso, boolean sugar) {
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

    public void setChocolateChips(String chocolateChips) {
        this.chocolateChips = chocolateChips;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMocaccino: 200 ml. Including:\n");
        sb.append(String.format("Espresso: vol %d ml (coffee: %d g.)",
                this.waterVol, this.coffeeAmt)).append("\n");

        if (sugar) sb.append("Sugar.").append("\n");

        sb.append(milk).append("\n");
        sb.append(milkFoam).append("\n");
        sb.append(chocolateChips);
        return sb.toString();
    }

}
