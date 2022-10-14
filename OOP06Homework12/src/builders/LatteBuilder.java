package builders;

import coffee.Latte;

public class LatteBuilder extends EspressoBuilder {


    void addMilk(Latte cupOfLatte){
        System.out.println("Heating milk...");
        cupOfLatte.setMilk("Milk, 150 ml. ");
        System.out.println("Milk added");
    }

    void whipMilkFoam(Latte cupOfLatte) {
        System.out.println("Whipping Milk foam...");
        cupOfLatte.setMilkFoam("Milk foam, 20 ml. ");
        System.out.println("Ready");
    }

    public Latte buildLatte(){
        Latte cupOfLatte = new Latte(buildEspresso());
        addMilk(cupOfLatte);
        whipMilkFoam(cupOfLatte);
        return cupOfLatte;
    }

    public Latte buildSweetLatte(){
        Latte cupOfLatte = new Latte(buildEspresso(), true);
        addMilk(cupOfLatte);
        whipMilkFoam(cupOfLatte);
        return cupOfLatte;
    }

}
