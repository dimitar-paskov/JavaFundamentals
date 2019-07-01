package EP08FamilyTree;

import java.time.LocalDate;

public class Person implements Comparable<Person>{

    String name;
    LocalDate birthdayDate;

    public Person(String name, LocalDate birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public Person(String name) {
        this.name = name;
        this.birthdayDate = LocalDate.MIN;
    }

    public Person(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
        this.name = "";
    }

    public boolean containsDate(LocalDate date){
        return  this.birthdayDate.equals(date);
    }

    public boolean containsPerson(String name){
        return  this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Override
    public int compareTo(Person p) {
        if (this.birthdayDate.isBefore(p.birthdayDate)){
            return -1;
        }
        if (this.birthdayDate.isAfter(p.birthdayDate)){
            return 1;
        }
        if (this.birthdayDate.equals(p.birthdayDate) && this.name.equals(p.name)){
            return 0;
        }
        return 1;
    }
}
