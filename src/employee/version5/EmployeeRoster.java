package employee.version5;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;


    public EmployeeRoster(){
        empList = new ArrayList<>();
    }

    public void addEmp(Employee emp){
        empList.add(emp);
    }

//    Counts how many employee type is in the list
    public int countEmp(String type){
        int count = 0;
        for (Employee emp : empList) {
            String empType = emp.getClass().getSimpleName();
            if (empType.equals(type)) {
                count++;
            }
        }
        return count;
    }

//    Displays all employee type
    public void displayEmpType(){
//        int i;
//        System.out.println("Employee Types:");
//        for (i = 0; i < this.count; i++) {
//            Employee employee = empList[i];
//            String employeeType = employee.getClass().getSimpleName();
//            System.out.println(empList[i].getEmpName() + ": " + employeeType);
//        }
        for (Employee emp : empList) {
            String empType = emp.getClass().getSimpleName();
            System.out.println(emp.getEmpName() + ": " + empType);
        }
    }

    public Employee removeEmp(int id){
        int i;
        for(i = 0; i < empList.size(); i++){
            Employee temp = empList.get(i);
            if(temp.getEmpID() == id){
                empList.remove(i);
                return temp;
            }
        }
        System.out.println("Employee with ID " + id+ " not found");
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
        int i;
        for(i = 0; i < empList.size(); i++){
            Employee temp = empList.get(i);
            if(temp.getEmpID() == id){
                return temp;
            }
        }
        System.out.println("Employee not found");
        return null;
    }
    public void searchEmp(String find){
        int i;
        for(i = 0; i < empList.size(); i++){
            Employee temp = empList.get(i);
            String holdID = Integer.toString(temp.getEmpID());
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
        for(i = 0; i < empList.size(); i++){
            Employee temp = empList.get(i);
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
