package Employee.Methods;
import Employee.Pojo.Employee;
import Employee.Types.Emply;
import Employee.Types.ContractEmployee;
import Employee.Types.PartTimeEmployee;
import Employee.Types.PermenantEmployee;
import java.util.Map;
import static Employee.MainClass.Main.scanner;
import static Employee.MainClass.Main.hashTable;
public class EmployeeMethods {

    public void createEmployee() {
        Employee employee=new Employee();
        System.out.println("Enter Employee ID");
        int id =scanner.nextInt();
        employee.setEmployeeId(id);
        scanner.nextLine();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        employee.setEmployeeName(name);
        Emply t = typeSelection();
        employee.setEmployeeType(t);
        hashTable.put(id,employee);
        System.out.println("Employee has been created");
    }

    public  Emply typeSelection(){
        System.out.println("employee Type");
        System.out.println("Select Type 1)PartTime 2)Permanent 3)Contract");
        int i = scanner.nextInt();
        Emply type;
        if(i==1) {
            type = new PartTimeEmployee();

        }
        else if(i==2){
            type = new PermenantEmployee();
        }
        else{
            type = new ContractEmployee();
        }
        return type;

    }
    public void modify(){
        Employee employee=new Employee();
        System.out.println("enter id of employee to modify");
        int id=scanner.nextInt();
        if(hashTable.containsKey(id)) {
            System.out.println("1-->modify name 2-->modify type");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    employee.setEmployeeId(id);
                    System.out.println("Enter a new name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    employee.setEmployeeName(name);
                    Emply t = hashTable.get(id).getEmployeeType();
                    employee.setEmployeeType(t);
                    hashTable.put(id, employee);
                    System.out.println("name has Modified");
                }
                case 2 -> {
                    employee.setEmployeeId(id);
                    String name = hashTable.get(id).getEmployeeName();
                    employee.setEmployeeName(name);
                    Emply t = typeSelection();
                    employee.setEmployeeType(t);
                    hashTable.put(id, employee);
                    System.out.println("Modified");
                }
                default -> System.out.println("Enter valid choice");
            }
        }
        else {
            System.out.println("Employee is not in the list");
        }
    }
    public void delete(){
        System.out.println("enter id of employee to delete");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(hashTable.containsKey(id)){
            hashTable.remove(id);
            System.out.println("Removed");
        }
        else {
            System.out.println("Employee is not in the list");
        }
    }
    public void listOfEmployees(){

        for(Map.Entry<Integer,Employee> details:hashTable.entrySet()){
            System.out.println(details.getKey());
            System.out.println(details.getValue().getEmployeeId() +" "+ details.getValue().getEmployeeName() +" "+ details.getValue().getEmployeeType().type());
        }
    }
    public void search(){
        System.out.println("Enter the employee id to search");
        int id=scanner.nextInt();
        if(hashTable.containsKey(id)){
            System.out.println("Employee found");
            System.out.println("ID "+ hashTable.get(id).getEmployeeId() +" NAME "+ hashTable.get(id).getEmployeeName() +" TYPE "
                    + hashTable.get(id).getEmployeeType().type());

        }
        else{
            System.out.println("Employee not found");
        }


    }

}
