package Employee.Pojo;

import Employee.Types.Emply;

public class Employee {
    private int employeeId;
    private String employeeName;
    private Emply employeeType;
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Emply getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;

    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeType(Emply employeeType) {
        this.employeeType = employeeType;
    }


}
