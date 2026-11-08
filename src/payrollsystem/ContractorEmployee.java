/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

/**
 *
 * @author pc
 */


import java.time.LocalDate;

public class ContractorEmployee extends Employee {

    private int hourlyRate;
    private int hoursWorked;

    public ContractorEmployee(String id, String name, LocalDate joinDate,
                              int hourlyRate, int hoursWorked) {
        super(id, name, 0, joinDate);
        if (hourlyRate < 0 || hoursWorked < 0)
            throw new IllegalArgumentException("rate and hours must be >= 0");
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateNetSalary() {
        return (double) hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus(double performanceScore) {
        return performanceScore > 4.0 ? 500 : 0;
    }
}

