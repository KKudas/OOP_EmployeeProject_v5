/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version3;

/**
 *
 * @author User
 */
public class CommissionEmployee extends Employee {
    private double totalSales;
    
    //3 constructors

    public CommissionEmployee() {
    }

    public CommissionEmployee(Name empName, Date BirthDate) {
        super(empName, BirthDate);
    }

    public CommissionEmployee(int empID, Name empName, Date DateHired, Date BirthDate, double totalSales) {
        super(empID, empName, DateHired, BirthDate);
        this.totalSales = totalSales;
    }
    

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    
    
    public double computeSalary(){
        double rate;
        if (this.totalSales < 50000){
            rate = 0.05;
        } else if (this.totalSales >= 50000 && this.totalSales < 100000){
            rate = 0.20;
        } else if (this.totalSales >= 100000 && this.totalSales < 500000){
            rate = 0.30;
        } else {
            rate = 0.50;
        }
        return rate * this.totalSales;
    }

    
    public void displayInfo(double salary){
        System.out.println("Employee ID: " + super.getEmpID());
        System.out.println("Employee Name: " + super.getEmpName());
        System.out.println("Date Hired: " + super.getEmpHiredDate());
        System.out.println("Birth Date: " + super.getEmpBirthDate());
        System.out.println("Total Sales: " + this.totalSales);
        System.out.println("Salary: " + salary);
    }

}
