package com.codecool.tech.salary;

import com.codecool.tech.employee.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SalaryCalculatorTest {
    private Employee employee3000net = new Employee(new BigDecimal(3000));
    private Employee employee4000net = new Employee(new BigDecimal(4000));
    private Employee employee5000net = new Employee(new BigDecimal(5000));
    private SalaryCalculator salaryCalculator = new SalaryCalculator();

    @Test
    public void calculateWholeSalaryTest() {
        BigDecimal expectedWholeSalaryFor3000net = new BigDecimal("3639.98");
        BigDecimal expectedWholeSalaryFor4000net = new BigDecimal("4819.98");
        BigDecimal expectedWholeSalaryFor5000net = new BigDecimal("6139.98");

        BigDecimal actualWholeSalaryFor3000net = salaryCalculator.calculateWholeSalary(employee3000net);
        BigDecimal actualWholeSalaryFor4000net = salaryCalculator.calculateWholeSalary(employee4000net);
        BigDecimal actualWholeSalaryFor5000net = salaryCalculator.calculateWholeSalary(employee5000net);

        assertEquals(expectedWholeSalaryFor3000net, actualWholeSalaryFor3000net);
        assertEquals(expectedWholeSalaryFor4000net, actualWholeSalaryFor4000net);
        assertEquals(expectedWholeSalaryFor5000net, actualWholeSalaryFor5000net);
    }

    @Test
    public void calculateTotalWholeSalaryTest() {
        List<Employee> employees = Arrays.asList(employee3000net, employee4000net, employee5000net);
        BigDecimal expectedTotalWholeSalary = new BigDecimal("14599.94");

        BigDecimal actualTotalWholeSalary = salaryCalculator.calculateTotalWholeSalary(employees);

        assertEquals(expectedTotalWholeSalary, actualTotalWholeSalary);
    }
}
