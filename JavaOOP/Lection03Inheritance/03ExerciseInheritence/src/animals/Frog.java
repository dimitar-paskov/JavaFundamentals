package animals;

public class Frog extends Animal implements SoundProducible{
    public Frog(String name, int age, String gender) throws ValidationException {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "Frogggg";
    }
}
