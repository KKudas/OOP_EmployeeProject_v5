package employee.version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int count;

    public EmployeeRoster(){
        empList = new Employee[10];
        this.count = 0;
    }

    public EmployeeRoster(int max){
        empList = new Employee[max];
        this.count = 0;
    }

    public void addEmp(Employee emp){
        if(this.count < empList.length){
            empList[this.count] = emp;
            this.count++;
        } else {
            System.out.println("Roster is full. Cannot insert emp");
        }
    }

//    Counts how many employee type is in the list
    public int countEmp(String type){
        int i;
        int flag = 0;
        for(i = 0; i < this.count; i++){
            Employee employee = empList[i];
            String employeeType = employee.getClass().getSimpleName();
            if(employeeType.equals(type)){
                flag++;
            }
        }
        return flag;
    }

//    Displays all employee type
    public void displayEmpType(){
        int i;
        System.out.println("Employee Types:");
        for (i = 0; i < this.count; i++) {
            Employee employee = empList[i];
            String employeeType = employee.getClass().getSimpleName();
            System.out.println(empList[i].getEmpName() + ": " + employeeType);
        }
    }

    public Employee removeEmp(int id){
        int i;
        for (i = 0; i < this.count; i++) {
            if (empList[i].getEmpID() == id) {
                Employee temp = empList[i];
                for (int j = i; j < this.count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[this.count - 1] = null;
                this.count--;
                return temp;
            }
        }
        if(i == this.count){
            System.out.println("Employee doesn't exist!");
        }
        return null;
    }

    public void updateEmp(int id, String empName) {
        int i, j;
        String[] result = empName.split(" ");
        Employee.Name tempName = new Employee.Name();
        //search for emp
        Employee temp = findEmployeeById(id);

        if(temp != null){
            if(result.length == 2){ //F L
                tempName.setFirstName(result[0]);
                tempName.setLastName(result[1]);
                temp.setEmpName(tempName);
            } else if(result.length == 3){ //F M L
                tempName.setFirstName(result[0]);
                tempName.setMiddleName(result[1]);
                tempName.setLastName(result[2]);
                temp.setEmpName(tempName);
            } else { //F M L S
                tempName.setFirstName(result[0]);
                tempName.setMiddleName(result[1]);
                tempName.setLastName(result[2]);
                tempName.setSuffix(result[3]);
                temp.setEmpName(tempName);
            }
            System.out.println("Employee has now been updated");
        } else {
            System.out.println("Employee not found");
        }
    }


    public void updateEmp(int id, String empName, Date birth, boolean choose) {
        Employee temp = findEmployeeById(id);
        if(temp != null){
            updateEmp(id, empName);
            //true if birthday, false if hired??
            if(choose){
                temp.setEmpBirthDate(birth);
            } else {
                temp.setEmpHiredDate(birth);
            }
        }
    }

    public void updateEmp(int id, String empName, Date birth, Date hired) {
        Employee temp = findEmployeeById(id);
        if(temp != null){
            updateEmp(id, empName);
            temp.setEmpBirthDate(birth);
            temp.setEmpHiredDate(hired);
        }
    }
    private Employee findEmployeeById(int id) {
        for (int i = 0; i < this.count; i++) {
            Employee temp = empList[i];
            if (temp.getEmpID() == id) {
                return temp;
            }
        }
        return null; // Employee not found
    }
    public void searchEmp(String find){
        int i;
        for(i = 0; i < this.count; i++){
            Employee temp = empList[i];
            String holdID = Integer.toString(empList[i].getEmpID());
            if(find.equals(temp.getEmpName())){
                printWithFormat(temp);
            } else if (find.equals(holdID)) {
                printWithFormat(temp);
            } else if (find.equals(temp.getEmpBirthDate())){
                printWithFormat(temp);
            } else if (find.equals(temp.getEmpHiredDate())) {
                printWithFormat(temp);
            }
        }
    }

    public void displayAllEmp(){
        System.out.println("ID  |  Name  |  Type  |  Salary");
        int i;
        double salary = 0.0;
        for(i = 0; i < this.count; i++){
            Employee temp = empList[i];
            if (temp instanceof HourlyEmployee) {
                HourlyEmployee hold = (HourlyEmployee) temp;
                salary = hold.computeSalary();
            } else if (temp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee hold = (PieceWorkerEmployee) temp;
                salary = hold.computeSalary();
            } else if (temp instanceof CommissionEmployee) {
                CommissionEmployee hold = (CommissionEmployee) temp;
                salary = hold.computeSalary();
            } else if (temp instanceof BasePlusCommisionEmployee) {
                BasePlusCommisionEmployee hold = (BasePlusCommisionEmployee) temp;
                salary = hold.computeSalary();
            }

            String print = String.format("| %2d | %-24s | %-23s | P%-12.2f |",
            temp.getEmpID(), temp.getEmpName(), temp.getClass().getSimpleName(), salary);
            System.out.println(print);
        }
    }

    private static void printWithFormat(Employee emp){
        String print = String.format("| %2d | %-24s | %-23s |",
        emp.getEmpID(), emp.getEmpName(), emp.getClass().getSimpleName());
        System.out.println(print);
    }

}
