package zad3;
public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setLastName(lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }



    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {


        if (lastName.length()<= 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }


        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return String.format("%sWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f%n",
                super.toString(),
                this.weekSalary,
                this.workHoursPerDay,
                (this.weekSalary / (7* this.workHoursPerDay)));
    }
}
