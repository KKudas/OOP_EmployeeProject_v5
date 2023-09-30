/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class BasePlusCommisionEmployee {
    private int empID;
    private String empName;
    private double totalSales;
    private double baseSalary;
    EmployeeDate empBirthDate = new EmployeeDate();
    EmployeeDate empHiredDate = new EmployeeDate();
    
    
    //3 constructor
    public BasePlusCommisionEmployee() {
    }

    public BasePlusCommisionEmployee(String empName, String BirthDate) {
        this.empName = empName;
        empBirthDate.arrangeBirthDate(BirthDate);
    }

    public BasePlusCommisionEmployee(int empID, String empName, String DateHired, String BirthDate, double baseSalary, double totalSales) {
        this.empID = empID;
        this.empName = empName;
        this.baseSalary = baseSalary;
        this.totalSales = totalSales;
        empBirthDate.arrangeBirthDate(BirthDate);
        empHiredDate.arrangeHiredDate(DateHired);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeSalary(){
        double total;
        if (this.totalSales < 50000){
            total =  0.5 * this.totalSales;
        } else if (this.totalSales >= 50000 && this.totalSales < 100000){
            total = 0.20 * this.totalSales;
        } else if (this.totalSales >= 100000 && this.totalSales < 500000){
            total = 0.30 * this.totalSales;
        } else {
            total = 0.50 * this.totalSales;
        }
        return total + baseSalary;
    }


    public void displayInfo(double salary){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Date Hired: " + empHiredDate.getEmpHiredDate());
        System.out.println("Birth Date: " + empBirthDate.getEmpBirthDate());
        System.out.println("Total Salary: " + this.totalSales);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "BasePlusCommisionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalSales=" + totalSales +
                ", baseSalary=" + baseSalary +
                ", empBirthDate=" + empBirthDate.getEmpBirthDate() +
                ", empHiredDate=" + empHiredDate.getEmpHiredDate() +
                '}';
    }
}
