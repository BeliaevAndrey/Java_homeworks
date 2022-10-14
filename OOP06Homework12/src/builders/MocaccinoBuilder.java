package builders;

import coffee.Mocaccino;

public class MocaccinoBuilder extends EspressoBuilder{

    void addMilk(Mocaccino cupOfMocaccino){
        System.out.println("Heating milk...");
        cupOfMocaccino.setMilk("Milk, 150 ml. ");
        System.out.println("Milk added");
    }

    void addChocolate(Mocaccino cupOfMocaccino){
        System.out.println("Adding chocolate...");
        cupOfMocaccino.setChocolateChips("Swiss-chocolate chips. 20 g.");
        System.out.println("Chocolate chips added");
    }

    void whipMilkFoam(Mocaccino cupOfMocaccino) {
        System.out.println("Whipping Milk foam...");
        cupOfMocaccino.setMilkFoam("Milk foam, 20 ml. ");
        System.out.println("Ready");
    }

    public Mocaccino buildMocaccino(){
        Mocaccino cupOfMocaccino = new Mocaccino(buildEspresso());
        addMilk(cupOfMocaccino);
        whipMilkFoam(cupOfMocaccino);
        addChocolate(cupOfMocaccino);

        return cupOfMocaccino;
    }

    public Mocaccino buildSweetMocaccino(){
        Mocaccino cupOfMocaccino = new Mocaccino(buildEspresso(), true);
        addMilk(cupOfMocaccino);
        whipMilkFoam(cupOfMocaccino);
        addChocolate(cupOfMocaccino);
        return cupOfMocaccino;
    }

}
