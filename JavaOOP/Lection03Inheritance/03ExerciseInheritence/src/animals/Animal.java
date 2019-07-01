package animals;

public class Animal implements SoundProducible{
    private String name;
    private  int age;
    private String gender;

    public Animal(String name, int age, String gender) throws ValidationException {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) throws ValidationException {
        if (name.trim().length() < 1){
            throw new ValidationException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) throws ValidationException {
        if (age < 0){
            throw new ValidationException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) throws ValidationException {
        if (gender.trim().length() < 1){
            throw new ValidationException("Invalid input!");
        }

        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))){
            throw new ValidationException("Invalid input!");
        }

        this.gender = gender;
    }

    public String produceSound(){
        return "Not implemented!";
    }
}
