package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//
        List<String> names = Arrays.asList("jan", "anna", "daniel", "arek", "jan", "mateusz", "dominik", "anna");

        List<String> sortedNames = names.stream()
                .filter(s1 -> s1.length()<7)
                .collect(Collectors.toList());

        System.out.println(sortedNames);


        List<Employee> someCompanyEmployee = Arrays.asList(
                new Employee("Daniel", "Karaś", 2500),
                new Employee("Anna", "Karaś", 3300),
                new Employee("Lukasz", "Karaś", 3100),
                new Employee("Kasia", "Dworzańska", 2400),
                new Employee("Lukasz", "Moszczynski", 2700),
                new Employee("Wojciech", "Pędziwiatr", 7500)
        );


        List<Employee> sortedBySalary = someCompanyEmployee.stream()
                .filter(l -> l.getLastName().equals("Karaś"))
                .sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
                .collect(Collectors.toList());


        List<Integer> collect = someCompanyEmployee.stream()
                .map(s -> s.getLastName().length())
                .collect(Collectors.toList());

        someCompanyEmployee.stream()
                .peek(p -> p.getFirstName())
                .forEach(System.out::println);

        List<Employee> collect1 = someCompanyEmployee.stream()
                .sorted((s1, s2) -> s2.getSalary() - s1.getSalary())
                .limit(3)
                .collect(Collectors.toList());

        List<Employee> collect2 = someCompanyEmployee.stream()
                .filter(s1 -> s1.getSalary() >= 2500)
                .sorted((s1, s2) -> s2.getSalary() - s1.getSalary())
                .collect(Collectors.toList());

        System.out.println(collect2.toString());
    }
}
