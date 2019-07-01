package EP08FamilyTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//
//        List<Person> persons = new LinkedList<>();
//
//
//        String line = scanner.nextLine();
//        try {
//            LocalDate localDate = LocalDate.parse(line, formatter);
//            Person person = new Person(localDate);
//            persons.add(person);
//        }catch (DateTimeParseException ex){
//            Person person = new Person(line);
//            persons.add(person);
//        }
//
//
//        while (!"End".equals(line = scanner.nextLine())){
////            System.out.println(line);
//            String[] tokens = line.split(" - ");
//
//            if (tokens.length == 2){
//
//                boolean firstIsDate = false;
//                boolean secondIsDate = false;
//
//                try {
//                    LocalDate localDate = LocalDate.parse(tokens[0], formatter);
//                    firstIsDate = true;
//                }catch (DateTimeParseException ex){
//
//                }
//
//                try {
//                    LocalDate localDate = LocalDate.parse(tokens[1], formatter);
//                    secondIsDate = true;
//                }catch (DateTimeParseException ex){
//
//                }
//
//                if (firstIsDate && secondIsDate){
//                    LocalDate localDate1 = LocalDate.parse(tokens[0], formatter);
//                    LocalDate localDate2 = LocalDate.parse(tokens[1], formatter);
//
//                    if (persons.stream()
//                            .noneMatch(person -> person.containsDate(localDate1))){
//                        Person person = new Person(localDate1);
//                        persons.add(person);
//                    }
//
//                    if (persons.stream().noneMatch(person -> person.containsDate(localDate2))){
//                        Person person = new Person(localDate2);
//                        persons.add(person);
//                    }
//
//                }
//
//                if (firstIsDate && (!secondIsDate)){
//                    LocalDate localDate1 = LocalDate.parse(tokens[0], formatter);
//                    String name = tokens[1];
//
//                    if (persons.stream().noneMatch(person -> person.containsPerson(name))){
//                        Person person = new Person(name, localDate1);
//                        persons.add(person);
//                    }else{
//                        persons.stream().filter(person -> person.containsPerson(name)).forEach(person -> person.setBirthdayDate(localDate1));
//                    }
//                }
//
//                if ((!firstIsDate) && secondIsDate){
//                    LocalDate localDate2 = LocalDate.parse(tokens[1], formatter);
//                    String name = tokens[0];
//
//                    if (persons.stream().noneMatch(person -> person.containsPerson(name))){
//                        Person person = new Person(name, localDate2);
//                        persons.add(person);
//                    }else{
//                        persons.stream().filter(person -> person.containsPerson(name)).forEach(person -> person.setBirthdayDate(localDate2));
//                    }
//                }
//
//                if ((!firstIsDate) && (!secondIsDate)){
//                   String name1 = tokens[0];
//                   String name2 = tokens[1];
//
//                    if (persons.stream().noneMatch(person -> person.containsPerson(name1))){
//                        Person person = new Person(name1);
//                        persons.add(person);
//                    }
//
//                    if (persons.stream().noneMatch(person -> person.containsPerson(name2))){
//                        Person person = new Person(name2);
//                        persons.add(person);
//                    }
//
//
//                }
//
//
//
//            }else{
//                int index = line.lastIndexOf(" ");
//
//                String name = line.substring(0,index);
//                LocalDate date = LocalDate.parse(line.substring(index+1),formatter);
//
//                if (persons.stream().noneMatch(person -> person.containsPerson(name))){
//                    Person person = new Person(name, date);
//                    persons.add(person);
//                }
//                if (persons.stream()
//                        .noneMatch(person -> person.containsDate(date))){
//                    Person person = new Person(name, date);
//                    persons.add(person);
//                }
//
//                    persons.stream().filter(person -> person.containsPerson(name)).forEach(person -> person.setBirthdayDate(date));
//                    persons.stream().filter(person -> person.containsDate(date)).forEach(person -> person.setName(name));
//
//
//            }
//        }
//
//        Person it = persons.remove(0);
//        System.out.println(it.name + " " + formatter.format(it.birthdayDate));
//        System.out.println("Parents:");
//        persons.stream()
//                .filter(p->p.birthdayDate.isBefore(it.birthdayDate)).distinct()
//                .map(p-> String.format("%s %s",p.name, formatter.format(p.birthdayDate)))
//                .distinct()
//                .forEach(System.out::println);
//        System.out.println("Children:");
//        persons.stream()
//                .filter(p->p.birthdayDate.isAfter(it.birthdayDate)).distinct()
//                .map(p-> String.format("%s %s",p.name, formatter.format(p.birthdayDate)))
//                .distinct()
//                .forEach(System.out::println);
        System.out.println("a");
    }
}
