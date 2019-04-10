package com.codecool.tech;

import com.codecool.tech.employee.Employee;
import com.codecool.tech.salary.SalaryCalculator;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nothing to calculate. Please provide employees salaries as arguments.");
            return;
        }

        List<Employee> employees = new LinkedList<>();
        SalaryCalculator salaryCalculator = new SalaryCalculator();

        for (String arg : args) {
            try{
                employees.add(new Employee(new BigDecimal(arg)));
            } catch (NumberFormatException e) {
                System.out.println(String.format("\'%s\' is not a valid representation of a BigDecimal", arg));
            }

        }
        BigDecimal totalWholeSalaryOfAllEmployees = salaryCalculator.calculateTotalWholeSalary(employees);

        System.out.println(totalWholeSalaryOfAllEmployees);
    }
}
