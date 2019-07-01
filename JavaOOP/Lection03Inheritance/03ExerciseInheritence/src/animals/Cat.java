package animals;

public class Cat extends Animal implements SoundProducible{
    public Cat(String name, int age, String gender) throws ValidationException {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "MiauMiau";
    }
}
