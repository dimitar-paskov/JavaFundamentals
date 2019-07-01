package animals;

public class Tomcat extends Cat implements SoundProducible {
    public Tomcat(String name, int age, String gender) throws ValidationException {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "Give me one million b***h";
    }
}
