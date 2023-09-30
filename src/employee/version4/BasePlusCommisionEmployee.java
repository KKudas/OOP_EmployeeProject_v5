/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version4;

/**
 *
 * @author User
 */
public class BasePlusCommisionEmployee extends CommissionEmployee {
    private double baseSalary;
    
    
    //3 constructor
    public BasePlusCommisionEmployee() {
    }

    public BasePlusCommisionEmployee(Name empName, Date BirthDate) {
        super(empName, BirthDate);
    }

    public BasePlusCommisionEmployee(int empID, Name empName, Date DateHired, Date BirthDate, double baseSalary, double totalSales) {
        super(empID, empName, DateHired, BirthDate, totalSales);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    
    @Override
    public double computeSalary(){
        return (super.computeSalary() + this.baseSalary);
    }


    public void displayInfo(double salary){
        System.out.println("Employee ID: " + super.getEmpID());
        System.out.println("Employee Name: " + super.getEmpName());
        System.out.println("Date Hired: " + super.getEmpHiredDate());
        System.out.println("Birth Date: " + super.getEmpBirthDate());
        System.out.println("Total Salary: " + super.getTotalSales());
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Salary: " + salary);
    }

    
}
