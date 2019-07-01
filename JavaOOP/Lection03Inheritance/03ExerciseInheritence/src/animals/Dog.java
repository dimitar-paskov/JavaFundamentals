package animals;

public class Dog extends Animal implements SoundProducible {
    public Dog(String name, int age, String gender) throws ValidationException {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "BauBau";
    }
}
