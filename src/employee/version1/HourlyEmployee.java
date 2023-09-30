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
public class HourlyEmployee {
    private int empID;
    private String empName;
    EmployeeDate empBirthDate = new EmployeeDate();
    EmployeeDate empHiredDate = new EmployeeDate();
    private float totalHoursWorked;
    private float ratePerHour; //salary 1
    
    //3 cosntructors di pa sure ang mga dates
    
    public HourlyEmployee() {
        
    }

    public HourlyEmployee(String empName, String BirthDate) {
        this.empName = empName;
        empBirthDate.arrangeBirthDate(BirthDate);
    }

    public HourlyEmployee(int empID, String empName, String DateHired, String BirthDate, float totalHoursWorked, float ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        empHiredDate.arrangeHiredDate(DateHired);
        empBirthDate.arrangeBirthDate(BirthDate);
        this.totalHoursWorked = totalHoursWorked; 
        this.ratePerHour = ratePerHour; //76.25/hr
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
    
    public double computeSalary(){
        double excessHoursTotal;
        
        if(this.totalHoursWorked > 40){
            excessHoursTotal = (this.totalHoursWorked - 40) * (1.5 * this.ratePerHour); // 8 hrs * 5 perWeek = 40hrs/week
            return excessHoursTotal + (40 * this.ratePerHour);
        } else {
            return this.totalHoursWorked * this.ratePerHour;
        }
    }
    
    public void displayInfo(double salary){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Date Hired: " + empHiredDate.getEmpHiredDate());
        System.out.println("Birth Date: " + empBirthDate.getEmpBirthDate());
        System.out.println("Total Hours Worked: " + this.totalHoursWorked);
        System.out.println("Rate Per Hour: " + this.ratePerHour);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empBirthDate=" + empBirthDate.getEmpBirthDate() +
                ", empHiredDate=" + empHiredDate.getEmpHiredDate() +
                ", totalHoursWorked=" + totalHoursWorked +
                ", ratePerHour=" + ratePerHour +
                '}';
    }
}
