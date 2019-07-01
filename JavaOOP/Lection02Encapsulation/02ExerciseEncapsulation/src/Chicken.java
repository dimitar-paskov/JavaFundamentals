import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) throws ValidationException {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) throws ValidationException {
        if (name == null || name.isEmpty() || name.trim().length() < 1) {
            throw new ValidationException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) throws ValidationException {
        if (age < 0 || age > 15) {
            throw new ValidationException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2;
        } else if (this.age < 12) {
            return 1;
        }else{
            return 0.75;
        }

    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",this.name, this.age, formatter.format(this.productPerDay()));
    }
}
