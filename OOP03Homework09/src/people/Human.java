package people;

import java.util.Objects;

public class Human {
    private final String firstName;
    private final String secondName;
    private final String patronymic;
    private final int age;
    private final String gender;


    public Human(String firstName, String secondName, String patronymic, String gender, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        if (gender.equals("M") || gender.equals("F")) this.gender = gender;
        else throw new IllegalStateException("Wrong gender!");
        if (age >= 0 && age < 123) this.age = age;
            // https://en.wikipedia.org/wiki/List_of_the_verified_oldest_people
        else throw new IllegalStateException("Wrong age. (only 0...122 full years allowed)");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, (%s, %d years)",
                secondName, firstName, patronymic, gender, age);
    }


}
