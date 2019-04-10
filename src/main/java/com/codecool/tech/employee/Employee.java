package com.codecool.tech.employee;

import java.math.BigDecimal;

public class Employee {
    private BigDecimal netSalary;

    public Employee(BigDecimal netSalary) {
        if (netSalary == null) {
            throw new IllegalArgumentException("Employee salary cannot be null");
        }
        if (netSalary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Employee salary cannot be lower than 0");
        }
        this.netSalary = netSalary;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }
}
