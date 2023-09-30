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
public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    EmployeeDate empBirthDate = new EmployeeDate();
    EmployeeDate empHiredDate = new EmployeeDate();
    private int totalPiecesFinished;
    private float ratePerPiece;
    
    //3 consttructors
    public PieceWorkerEmployee() {
    }

    public PieceWorkerEmployee(String empName, String BirthDate) {
        this.empName = empName;
        empBirthDate.arrangeBirthDate(BirthDate);
    }

    public PieceWorkerEmployee(int empID, String empName, String DateHired, String BirthDate, int totalPiecesFinished, float ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        empHiredDate.arrangeHiredDate(DateHired);
        empBirthDate.arrangeBirthDate(BirthDate);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    public double computeSalary(){
        int excessPieces;
        if(this.totalPiecesFinished > 100){
            excessPieces = this.totalPiecesFinished / 100;
            return (excessPieces * 10) + (this.totalPiecesFinished * this.ratePerPiece);
        } else {
            return this.totalPiecesFinished * this.ratePerPiece;
        }
    }
    
    public void displayInfo(double salary){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Date Hired: " + empHiredDate.getEmpHiredDate());
        System.out.println("Birth Date: " + empBirthDate.getEmpBirthDate());
        System.out.println("Total Pieces Finished: " + this.totalPiecesFinished);
        System.out.println("Rate Per Hour: " + this.ratePerPiece);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empBirthDate=" + empBirthDate +
                ", empHiredDate=" + empHiredDate +
                ", totalPiecesFinished=" + totalPiecesFinished +
                ", ratePerPiece=" + ratePerPiece +
                '}';
    }
}
