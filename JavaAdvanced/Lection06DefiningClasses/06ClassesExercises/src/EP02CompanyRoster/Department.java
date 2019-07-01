package EP02CompanyRoster;

import java.util.LinkedList;

public class Department {
    private LinkedList<Employee> employees;

    public Department() {
        this.employees = new LinkedList<>();
    }

    public void add(Employee employee){
        employees.add(employee);
    }

    public Double getAverage(){
        return employees.stream()
                .map(e->e.getSalary())
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }
}
