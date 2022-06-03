package lection04interfacesandabstraction;


public class Rebel implements Buyer, Person{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void buyFood() {
        this.food +=5;

    }

    @Override
    public int getFood() {
        return this.food;
    }
}
