package EP07EqualityLogic;

import java.util.Comparator;
import java.util.Objects;

public class Person{
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public static Comparator<Person> comparator1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int result;

            if (o1.name.equals(o2.name)){
                return o1.age.compareTo(o2.age);
            }else{
                return o1.name.compareTo(o2.name);
            }
        }
    };
//
//    public static Comparator<Person> comparator2 = new Comparator<Person>() {
//        @Override
//        public int compare(Person o1, Person o2) {
//            return o1.age - o2.age;
//        }
//    };


}
