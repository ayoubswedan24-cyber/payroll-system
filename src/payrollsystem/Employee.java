/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
 
import java.time.LocalDate;
/**
 *
 * @author pc
 */

   

import java.time.LocalDate;

public abstract class Employee implements Taxable, BonusCalculable, Comparable<Employee> {
    private final String id;
    private final String name;
    protected double baseSalary;
    private final LocalDate joinDate;

    public Employee(String id, String name, double baseSalary, LocalDate joinDate) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id is required");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name is required");
        if (baseSalary < 0) throw new IllegalArgumentException("baseSalary must be >= 0");
        if (joinDate == null) throw new IllegalArgumentException("joinDate is required");
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
    }

    public abstract double calculateNetSalary();

    @Override
    public int compareTo(Employee other) {
        return Double.compare(other.calculateNetSalary(), this.calculateNetSalary());
    }

    @Override
    public double calculateTax() {
        return calculateNetSalary() * TAX_RATE;
    }

    @Override
    public double calculateBonus(double performanceScore) {
        return 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public LocalDate getJoinDate() { return joinDate; }

    @Override
    public String toString() {
        return String.format("%s [id=%s, name=%s, joined=%s, net=%.2f]",
                getClass().getSimpleName(), id, name, joinDate, calculateNetSalary());
    }
}

