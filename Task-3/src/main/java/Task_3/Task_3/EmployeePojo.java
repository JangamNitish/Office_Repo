package Task_3.Task_3;

//public class EmployeePojo {
//
//}
//package EmployeeDetails.EmployeeDetails;

public class EmployeePojo {
    private int employeeId;
    private String employeeName;
    private int salary;
    private String employeeType;
    public int getEmployeeId() {
        return employeeId;
    }
    public EmployeePojo(int employeeId,  String employeeName,int salary, String employeeType) {
        super();
        this.employeeId = employeeId;
        this.salary = salary;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public int getSalary() {
        return salary;
    }
}
