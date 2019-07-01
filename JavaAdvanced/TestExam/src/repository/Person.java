package repository;

public class Person {
    String name;
    int age;
    String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nAge: %s%nBirthday: %s", this.name, this.age, this.birthDate);
    }
}
