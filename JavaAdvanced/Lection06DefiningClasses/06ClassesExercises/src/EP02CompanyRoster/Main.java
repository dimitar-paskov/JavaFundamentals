package EP02CompanyRoster;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Department> register = new LinkedHashMap<>();



        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            Double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            register.putIfAbsent(department, new Department());

            Employee emp = null;
            if (data.length > 4){
                int age;
                String email;
                try{
                    age = Integer.parseInt(data[4]);
                    emp = new Employee(name, salary, position, department, age );
                }catch (NumberFormatException ex){
                    if (data.length > 5){
                        email = data[4];
                        age = Integer.parseInt(data[5]);
                        emp = new Employee(name, salary, position, department, email, age );
                    }else{
                        email = data[4];
                        emp = new Employee(name, salary, position, department, email);
                    }

                }

            }
            if (emp==null){
                emp = new Employee(name, salary, position, department);
            }

            register.get(department).add(emp);


        }

//        for (Map.Entry<String, Department> entry :
//                register.entrySet()) {
//            System.out.println(entry.getKey() + " ");
//            entry.getValue().getEmployees().stream().forEach(e-> System.out.println(e));
//        }

        Double max = Double.MIN_NORMAL;
        String key = "";

        for (Map.Entry<String, Department> entry :
                register.entrySet()) {

            Double average  = entry.getValue().getAverage();
            if (average > max){
                max = average;
                key = entry.getKey();
            }

        }

        System.out.println("Highest Average Salary: "+ key);
        register.get(key).getEmployees().stream()
                .sorted((emp1, emp2)-> emp2.getSalary().compareTo(emp1.getSalary()))
                .forEach(emp -> System.out.println(emp.getInfo()));


    }
}
