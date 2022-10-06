package people;

public class Relatives {

    private final Human first;
    private final Human second;
    private final Relations r;

    public Relatives(Human first, Human second, Relations r) {
        this.first = first;
        this.second = second;
        this.r = r;
    }

    public Human getFirst() {
        return first;
    }

    public Human getSecond() {
        return second;
    }

    public Relations getR() {
        return r;
    }

    @Override
    public String toString() {
        return String.format("%s %s of %s", first, r, second);
    }
}