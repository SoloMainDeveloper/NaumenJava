package org.example;

import java.util.ArrayList;

public class PracticeTask3 implements PracticeTask {
    private class Employee {
        private String fullName;
        private int age;
        private String department;
        private double salary;

        public Employee(String fullName, int age, String department, double salary) {
            setFullName(fullName);
            setAge(age);
            setDepartment(department);
            setSalary(salary);
        }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
    }

    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private String departmentToFind;

    public PracticeTask3(String departmentToFind){
        employees.add(new Employee("Alex Wavefighter", 32, "Accounting", 90000));
        employees.add(new Employee("Helen Lompur", 47, "HR", 86000));
        employees.add(new Employee("Dwight Shrute", 35, "Sales", 120000));
        employees.add(new Employee("Bob Odenkirk", 43, "Management", 200000));
        employees.add(new Employee("Olivia Jude", 22, "Sales", 70000));

        this.departmentToFind = departmentToFind;
    }

    public void run(){
        System.out.println("Задача 3");
        var result = getAverageSalaryInDepartment(departmentToFind);
        System.out.println("Средняя зарплата в department " + departmentToFind + ": "  + result + "\n");
    }

    private double getAverageSalaryInDepartment(String department){
        return employees.stream()
                .filter(x -> x.department.equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}
