package militaryElite;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        //Name: Pesho Peshev Id: 1 Salary: 22.22
        return String.format("Name: %s %s Id: %s Salary: %.2f",this.getFirstName(), this.getLastName(), this.getId(), this.getSalary());
    }
}
