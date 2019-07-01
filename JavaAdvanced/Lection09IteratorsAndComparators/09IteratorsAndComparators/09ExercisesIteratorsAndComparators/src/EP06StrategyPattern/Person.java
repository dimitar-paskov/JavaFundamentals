package EP06StrategyPattern;

import java.util.Comparator;

public class Person{
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static Comparator<Person> comparator1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.length()!=o2.name.length()
                    ?o1.name.length()-o2.name.length()
                    :o1.name.toUpperCase().charAt(0) - o2.name.toUpperCase().charAt(0);

        }
    };

    public static Comparator<Person> comparator2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    };



}
