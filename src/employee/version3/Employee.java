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
public class Employee {
    private int empID;
    private Name empName;
    private Date empBirthDate;
    private Date empHiredDate;

    public Employee() {
    }

    public Employee(int empID, Name empName, Date empBirthDate, Date empHiredDate) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empHiredDate = empHiredDate;
    }

    public Employee(Name empName, Date empBirthDate) {
        this.empName = empName;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName.getFullName();
    }

    public String getEmpBirthDate() {
        return empBirthDate.getDate();
    }

    public String getEmpHiredDate() {
        return empHiredDate.getDate();
    }

    public static class Name {
        private String firstName;
        private String middleName;
        private String lastName;
        private String suffix;

        public Name() {
        }

        public Name(String firstName, String middleName, String lastName, String suffix) { //F M L, S
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.suffix = suffix;
        }

        public Name(String firstName, String middleName, String lastName) { //F M L
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.suffix = null;
        }

        public Name(String firstName, String lastName) { //F L
            this.firstName = firstName;
            this.middleName = null;
            this.lastName = lastName;
            this.suffix = null;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getSuffix() {
            return suffix;
        }

        public String getFullName(){
            StringBuilder fullName = new StringBuilder();

            fullName.append(this.firstName + " ");
            if(this.middleName != null){
                fullName.append(this.middleName + " ");
            }

            fullName.append(this.lastName);

            if(this.suffix != null){
                fullName.append(", " + this.suffix);
            }

            return fullName.toString();
        }
    }
}
