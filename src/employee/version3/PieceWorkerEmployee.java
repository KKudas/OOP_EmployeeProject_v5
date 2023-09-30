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
public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private float ratePerPiece;
    
    //3 consttructors
    public PieceWorkerEmployee() {
    }

    public PieceWorkerEmployee(Name empName, Date BirthDate) {
        super(empName, BirthDate);
    }

    public PieceWorkerEmployee(int empID, Name empName, Date DateHired, Date BirthDate, int totalPiecesFinished, float ratePerPiece) {
        super(empID, empName, DateHired, BirthDate);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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
        System.out.println("Employee ID: " + super.getEmpID());
        System.out.println("Employee Name: " + super.getEmpName());
        System.out.println("Date Hired: " + super.getEmpHiredDate());
        System.out.println("Birth Date: " + super.getEmpBirthDate());
        System.out.println("Total Pieces Finished: " + this.totalPiecesFinished);
        System.out.println("Rate Per Hour: " + this.ratePerPiece);
        System.out.println("Salary: " + salary);
    }


}
