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
public interface Taxable {
    double TAX_RATE = 0.15;
    double calculateTax();
}

