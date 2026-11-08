/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {

    
    public static void main(String[] args) {
       
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("F01", "Ahmad", 5000, LocalDate.of(2020, 3, 1), 800));
        employees.add(new FullTimeEmployee("F02", "Sara", 7000, LocalDate.of(2018, 7, 15), 1200));
        employees.add(new ContractorEmployee("C01", "Omar", LocalDate.of(2022, 1, 10), 40, 120));
        employees.add(new ContractorEmployee("C02", "Lina", LocalDate.of(2021, 9, 5), 55, 160));

        Collections.sort(employees);
        System.out.println("--- Sorted by net salary (desc) ---");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getJoinDate().compareTo(b.getJoinDate());
            }
        });
        System.out.println("\n--- Sorted by join date (oldest first) ---");
        for (Employee e : employees) {
            System.out.println(e);
        }

        double performanceScore = 4.5;
        double totalTax = 0, totalBonus = 0;
        for (Employee e : employees) {
            totalTax += e.calculateTax();
            totalBonus += e.calculateBonus(performanceScore);
        }
        System.out.printf("%nTotal tax   : %.2f%n", totalTax);
        System.out.printf("Total bonus : %.2f%n", totalBonus);
        System.out.printf("Total cost  : %.2f%n", totalTax + totalBonus);
    }
    }
    

