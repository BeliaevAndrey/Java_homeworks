package service;

import people.Human;
import people.Relations;
import people.Relatives;

import java.util.*;

public class Controller {
    public Deque<Relatives> tree = new ArrayDeque<>();

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

    Deque<Relatives> searchByStatus(Human person, Relations status, List<Relatives> rltList) {
        Deque<Relatives> response = new ArrayDeque<>();
        for (Relatives r : rltList) {
            if (r.getFirst().equals(person) && r.getR().equals(status)) {
                response.add(r);
            }
        }
        return response;
    }

    public void buildTree(Human startPerson, List<Relatives> rltList) {
        tree.addAll(searchByStatus(startPerson, Relations.SPOUSE, rltList));
        Deque<Relatives> tmp = (searchByStatus(startPerson, Relations.FATHER, rltList));
        tree.addAll(tmp);
        for (Relatives persons : tmp) {
            buildTree(persons.getSecond(), rltList);
        }
    }
}
