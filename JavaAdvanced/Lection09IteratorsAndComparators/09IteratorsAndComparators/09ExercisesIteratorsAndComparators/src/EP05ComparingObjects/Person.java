package EP05ComparingObjects;

public class Person implements Comparable<Person>{
    String name;
    Integer age;
    String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name)!=0
                ?this.name.compareTo(o.name)
                :this.age.compareTo(o.age)!=0
                ?this.age.compareTo(o.age)
                :this.town.compareTo(o.town);
    }
}
