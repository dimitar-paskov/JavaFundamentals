package EP01OpinionPoll;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo(){
        return this.name + " - " + this.age;
    }
}
