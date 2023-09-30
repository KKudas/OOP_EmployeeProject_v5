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
public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private float ratePerHour;
    
    //3 cosntructors di pa sure ang mga dates
    
    public HourlyEmployee() {
        
    }

    public HourlyEmployee(Name empName, Date BirthDate) {
        super(empName, BirthDate);
    }

    public HourlyEmployee(int empID, Name empName, Date DateHired, Date BirthDate, float totalHoursWorked, float ratePerHour) {
        super(empID, empName, DateHired, BirthDate);
        this.totalHoursWorked = totalHoursWorked; 
        this.ratePerHour = ratePerHour;
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
        System.out.println("Employee ID: " + super.getEmpID());
        System.out.println("Employee Name: " + super.getEmpName());
        System.out.println("Date Hired: " + super.getEmpHiredDate());
        System.out.println("Birth Date: " + super.getEmpBirthDate());
        System.out.println("Total Hours Worked: " + this.totalHoursWorked);
        System.out.println("Rate Per Hour: " + this.ratePerHour);
        System.out.println("Salary: " + salary);
    }

}
