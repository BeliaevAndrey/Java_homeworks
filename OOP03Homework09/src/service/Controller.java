package service;

import people.Human;
import people.Relations;
import people.Relatives;

import java.util.*;

public class Controller {
    public List<Relatives> tree = new ArrayList<>();

    public Controller() {
    }

    public List<Relatives> search(List<Relatives> listR, String surname, String name) {
        List<Relatives> cell = new ArrayList<>();
        for (Relatives r : listR) {
            if (r.getFirst().getSecondName().equals(surname) &&
                    r.getFirst().getFirstName().equals(name)) {
                cell.add(r);
            }
        }
        return cell;
    }

    List<Relatives> searchByStatus(Human person, Relations status, List<Relatives> rltList) {
        List<Relatives> response = new ArrayList<>();
        for (Relatives r : rltList) {
            if (r.getFirst().equals(person) && r.getR().equals(status)) {
                response.add(r);
            }
        }
        return response;
    }

    public void buildTree(Human startPerson, List<Relatives> rltList) {
        tree.addAll(searchByStatus(startPerson, Relations.SPOUSE, rltList));
        List<Relatives> tmp = (searchByStatus(startPerson, Relations.FATHER, rltList));
        tree.addAll(tmp);
        for (Relatives persons : tmp) {
            buildTree(persons.getSecond(), rltList);
        }
    }
}
