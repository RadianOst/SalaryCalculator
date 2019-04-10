package com.codecool.tech.salary;

import com.codecool.tech.employee.Employee;

import java.math.BigDecimal;
import java.util.List;

public class SalaryCalculator {
    private final BigDecimal FIRST_TAX_MULTIPLIER = new BigDecimal("1.18");
    private final BigDecimal SECOND_TAX_MULTIPLIER = new BigDecimal("1.32");
    private final BigDecimal FIRST_TAX_THRESHOLD = new BigDecimal(4000);
    private final BigDecimal HEALTH_INSURANCE = new BigDecimal("99.98");

    public BigDecimal calculateWholeSalary(Employee employee) {
        BigDecimal netSalary = employee.getNetSalary();
        if (netSalary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Employess net salary cannot be lower than 0");
        }

        BigDecimal partOfFirstTaxThreshold = netSalary;
        BigDecimal partOfSecondTaxThreshold = BigDecimal.ZERO;

        if (netSalary.compareTo(FIRST_TAX_THRESHOLD) > 0) {
            partOfFirstTaxThreshold = FIRST_TAX_THRESHOLD;
            partOfSecondTaxThreshold = netSalary.subtract(FIRST_TAX_THRESHOLD);
        }

        BigDecimal salaryAfterFirstTax = partOfFirstTaxThreshold.multiply(FIRST_TAX_MULTIPLIER);
        BigDecimal salaryAfterSecondTax = salaryAfterFirstTax.add(partOfSecondTaxThreshold.multiply(SECOND_TAX_MULTIPLIER));

        BigDecimal wholeSalary = salaryAfterSecondTax.add(HEALTH_INSURANCE);

        return wholeSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal calculateTotalWholeSalary(List<Employee> employees) {
        return employees.stream()
                .map(this::calculateWholeSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
