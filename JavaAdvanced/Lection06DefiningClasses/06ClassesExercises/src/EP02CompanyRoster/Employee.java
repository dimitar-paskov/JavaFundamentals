package EP02CompanyRoster;
public class Employee {

    private static final String notAvailable = "n/a";

    private String name;
    private Double salary;
    private String position;
    private String department;

    public Double getSalary() {
        return salary;
    }

    private String email;
    private Integer age;

    public Employee(String name, Double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    public Employee(String name, Double salary, String position, String department, String email, Integer age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = notAvailable;
        this.age = -1;
    }

    public String getInfo(){
        return String.format("%s %.2f %s %d",this.name, this.salary, this.email, this.age);
    }
}
