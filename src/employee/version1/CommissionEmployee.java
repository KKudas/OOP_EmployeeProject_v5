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
public class CommissionEmployee {
    private int empID;
    private String empName;
    EmployeeDate empBirthDate = new EmployeeDate();
    EmployeeDate empHiredDate = new EmployeeDate();
    private double totalSales;
    
    //3 constructors

    public CommissionEmployee() {
    }

    public CommissionEmployee(String empName, String BirthDate) {
        this.empName = empName;
        empBirthDate.arrangeBirthDate(BirthDate);
    }

    public CommissionEmployee(int empID, String empName, String DateHired, String BirthDate, double totalSales) {
        this.empID = empID;
        this.empName = empName;
        empHiredDate.arrangeHiredDate(DateHired);
        empBirthDate.arrangeBirthDate(BirthDate);
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

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    
    public double computeSalary(){
        //RATE
        //              INCREASE|CONDITION
        //LOW SALES:        5%  | < 50k
        //TYPICAL SALES:    20% | >= 50k but < 100k
        //                  30% | >= 100k but < 0.5M
        //HIGH SALES:       50% | >= 0.5M
        if (this.totalSales < 50000){
            return 0.5 * this.totalSales;
        } else if (this.totalSales >= 50000 && this.totalSales < 100000){
            return 0.20 * this.totalSales;
        } else if (this.totalSales >= 100000 && this.totalSales < 500000){
            return 0.30 * this.totalSales;
        } else {
            return 0.50 * this.totalSales;
        }
    }
    
    public void displayInfo(double salary){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Date Hired: " + empHiredDate.getEmpHiredDate());
        System.out.println("Birth Date: " + empBirthDate.getEmpBirthDate());
        System.out.println("Total Sales: " + this.totalSales);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empBirthDate=" + empBirthDate.getEmpBirthDate() +
                ", empHiredDate=" + empHiredDate.getEmpHiredDate() +
                ", totalSales=" + totalSales +
                '}';
    }
}
