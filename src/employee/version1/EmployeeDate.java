/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author User
 */
public class EmployeeDate {
    private String empHiredDate;
    private String empBirthDate;

    public EmployeeDate() {
    }
    
    public EmployeeDate(String empHiredDate, String empBirthDate) {
        this.empHiredDate = empHiredDate;
        this.empBirthDate = empBirthDate;
    }

    public String getEmpHiredDate() {
        return empHiredDate;
    }

    public void setEmpHiredDate(String empHiredDate) {
        this.empHiredDate = empHiredDate;
    }

    public String getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(String empBirthDate) {
        this.empBirthDate = empBirthDate;
    }
    
    public void arrangeBirthDate(String birthStr){
        DateTimeFormatter doformat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
        LocalDate birth = LocalDate.parse(birthStr, doformat);
        this.empBirthDate = doformat.format(birth);
    }
    
    public void arrangeHiredDate(String hiredStr){
        DateTimeFormatter doformat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
        LocalDate hired = LocalDate.parse(hiredStr, doformat);
        this.empHiredDate = doformat.format(hired);
    }
}
