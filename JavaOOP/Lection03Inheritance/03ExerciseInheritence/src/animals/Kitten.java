package animals;

public class Kitten extends Cat implements SoundProducible{
    public Kitten(String name, int age, String gender) throws ValidationException {
        super(name, age, gender);
        this.setGender();
    }


    public void setGender() throws ValidationException {
        super.setGender("Female");
    }

    @Override
    public String produceSound(){
        return "Miau";
    }
}
