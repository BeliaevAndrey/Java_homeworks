package service;

import people.Human;
import people.Relations;
import people.Relatives;

import java.util.List;

public class LoaderSvc {

    public void loader(List<Human> humans, List<Relatives> bloodline) {


        humans.add(new Human("John", "Smith", "Williams", "M", 80));      // 0
        humans.add(new Human("Jenna", "Smith", "Peters", "F", 75));       // 1
        bloodline.add(new Relatives(humans.get(0), humans.get(1), Relations.SPOUSE));
        bloodline.add(new Relatives(humans.get(1), humans.get(0), Relations.SPOUSE));

        humans.add(new Human("Harry", "Smith", "Johns", "M", 55));        // 2
        bloodline.add(new Relatives(humans.get(0), humans.get(2), Relations.FATHER));
        bloodline.add(new Relatives(humans.get(1), humans.get(2), Relations.MOTHER));
        bloodline.add(new Relatives(humans.get(2), humans.get(0), Relations.SON));
        bloodline.add(new Relatives(humans.get(2), humans.get(1), Relations.SON));

        humans.add(new Human("Jane", "Doe", "Martins", "F", 52));         // 3
        bloodline.add(new Relatives(humans.get(2), humans.get(3), Relations.SPOUSE));
        bloodline.add(new Relatives(humans.get(3), humans.get(2), Relations.SPOUSE));

        humans.add(new Human("Jedidiah", "Smith", "Harris", "M", 32));    // 4
        humans.add(new Human("Helen", "Smith", "Harris", "F", 30));       // 5
        bloodline.add(new Relatives(humans.get(2), humans.get(4), Relations.FATHER));
        bloodline.add(new Relatives(humans.get(3), humans.get(4), Relations.MOTHER));
        bloodline.add(new Relatives(humans.get(2), humans.get(5), Relations.FATHER));
        bloodline.add(new Relatives(humans.get(3), humans.get(5), Relations.MOTHER));

        bloodline.add(new Relatives(humans.get(4), humans.get(2), Relations.SON));
        bloodline.add(new Relatives(humans.get(4), humans.get(2), Relations.SON));
        bloodline.add(new Relatives(humans.get(5), humans.get(2), Relations.DAUGHTER));
        bloodline.add(new Relatives(humans.get(5), humans.get(2), Relations.DAUGHTER));

        bloodline.add(new Relatives(humans.get(4), humans.get(5), Relations.BROTHER));
        bloodline.add(new Relatives(humans.get(5), humans.get(4), Relations.SISTER));

        bloodline.add(new Relatives(humans.get(4), humans.get(0), Relations.GRANDSON));
        bloodline.add(new Relatives(humans.get(4), humans.get(1), Relations.GRANDSON));
        bloodline.add(new Relatives(humans.get(5), humans.get(0), Relations.GRANDDAUGHTER));
        bloodline.add(new Relatives(humans.get(5), humans.get(1), Relations.GRANDDAUGHTER));

        bloodline.add(new Relatives(humans.get(0), humans.get(4), Relations.GRANDFATHER));
        bloodline.add(new Relatives(humans.get(1), humans.get(4), Relations.GRANDMOTHER));
        bloodline.add(new Relatives(humans.get(0), humans.get(5), Relations.GRANDFATHER));
        bloodline.add(new Relatives(humans.get(1), humans.get(5), Relations.GRANDMOTHER));

        humans.add(new Human("Francine", "Peters", "Frederichs", "F", 30));       // 6
        bloodline.add(new Relatives(humans.get(4), humans.get(6), Relations.SPOUSE));
        bloodline.add(new Relatives(humans.get(6), humans.get(4), Relations.SPOUSE));

        humans.add(new Human("Adam", "Smith", "Jedidiahs", "M", 12));    // 7
        bloodline.add(new Relatives(humans.get(7), humans.get(4), Relations.SON));
        bloodline.add(new Relatives(humans.get(7), humans.get(6), Relations.SON));
        bloodline.add(new Relatives(humans.get(4), humans.get(7), Relations.FATHER));
        bloodline.add(new Relatives(humans.get(6), humans.get(7), Relations.MOTHER));

        bloodline.add(new Relatives(humans.get(2), humans.get(7), Relations.GRANDFATHER));
        bloodline.add(new Relatives(humans.get(5), humans.get(7), Relations.GRANDMOTHER));
        bloodline.add(new Relatives(humans.get(0), humans.get(7), Relations.GRAND_GRANDFATHER));
        bloodline.add(new Relatives(humans.get(1), humans.get(7), Relations.GRAND_GRANDMOTHER));

        bloodline.add(new Relatives(humans.get(7), humans.get(2), Relations.GRANDSON));
        bloodline.add(new Relatives(humans.get(7), humans.get(3), Relations.GRANDSON));
        bloodline.add(new Relatives(humans.get(7), humans.get(0), Relations.GRAND_GRANDSON));
        bloodline.add(new Relatives(humans.get(7), humans.get(1), Relations.GRAND_GRANDSON));

        bloodline.add(new Relatives(humans.get(7), humans.get(5), Relations.NEPHEW));
        bloodline.add(new Relatives(humans.get(5), humans.get(7), Relations.AUNT));


    }

}
