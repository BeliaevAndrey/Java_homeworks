package coffee;

public class Espresso {
    protected int waterVol = 0;
    protected int coffeeAmt = 0;
    protected boolean sugar = false;

    public Espresso(){
    }
    public Espresso(int waterVol, int coffeeAmt) {     // 30 ml, 10 g
        this.waterVol = waterVol;
        this.coffeeAmt = coffeeAmt;

    }
    public Espresso(int waterVol, int coffeeAmt, boolean sugar) {     // 30 ml, 10 g
        this.waterVol = waterVol;
        this.coffeeAmt = coffeeAmt;
        this.sugar = sugar;

    }

    public int getWaterVol() {
        return waterVol;
    }

    public int getCoffeeAmt() {
        return coffeeAmt;
    }

    @Override
    public String toString() {
        if (sugar)
            return String.format("\nEspresso with sugar: vol %d ml (coffee: %d g.)",
                    this.waterVol, this.coffeeAmt);
        else
            return String.format("\nEspresso: vol %d ml (coffee: %d g. )",
                    this.waterVol, this.coffeeAmt);
    }
}
