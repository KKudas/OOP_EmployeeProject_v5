/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version2;

/**
 *
 * @author User
 */
public class Employee {
    private int empID;
    private String empName;
    private Date empBirthDate;
    private Date empHiredDate;

    public Employee() {
    }

    public Employee(int empID, String empName, Date empBirthDate, Date empHiredDate) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empHiredDate = empHiredDate;
    }

    public Employee(String empName, Date empBirthDate) {
        this.empName = empName;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpBirthDate() {
        return empBirthDate.getDate();
    }

    public String getEmpHiredDate() { return empHiredDate.getDate(); }

}
