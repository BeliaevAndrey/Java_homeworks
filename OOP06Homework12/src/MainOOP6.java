import builders.AmericanoBuilder;
import builders.EspressoBuilder;
import builders.LatteBuilder;
import builders.MocaccinoBuilder;
import coffee.*;

public class MainOOP6 {
    public static void main(String[] args) {
        EspressoBuilder eb = new EspressoBuilder();
        LatteBuilder lb = new LatteBuilder();
        AmericanoBuilder ab = new AmericanoBuilder();
        MocaccinoBuilder mb = new MocaccinoBuilder();

        String separator = "\n" + "*".repeat(60);

        System.out.println(separator);

        Espresso cupOfEspresso = eb.buildSweetEspresso();
        System.out.println(cupOfEspresso);

        System.out.println(separator);

        DoubleEspresso cupOfDoubleEspresso = eb.buildDoubleSweetEspresso();
        System.out.println(cupOfDoubleEspresso);

        System.out.println(separator);

        Latte cupOfLatte = lb.buildSweetLatte();
        System.out.println(cupOfLatte);

        System.out.println(separator);

        Americano cupOfAmericano = ab.buildSweetAmericano();
        System.out.println(cupOfAmericano);

        System.out.println(separator);

        Mocaccino cupOfMocaccino = mb.buildMocaccino();
        System.out.println(cupOfMocaccino);
    }
}
