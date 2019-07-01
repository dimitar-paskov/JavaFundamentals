package EP07Google;

public class Company {
    String name;
    String department;
    Double salary;

    public Company(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.name, this.department, this.salary);
    }
}
