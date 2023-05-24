package Employee.MainClass;

import Employee.Pojo.Employee;
import Employee.Methods.EmployeeMethods;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static Hashtable<Integer, Employee> hashTable=new Hashtable<>();
    public static Scanner scanner=new Scanner(System.in);
  public static void main(String[] args) {
        EmployeeMethods employeeMethods=new EmployeeMethods();
        int again;
        do{
            System.out.println("1--> create   2--> modify 3--> delete 4--> list if employees  5--> search List");
            int choice=scanner.nextInt();
            switch (choice) {
                case 1 -> employeeMethods.createEmployee();
                case 2 -> {
                    if (!(hashTable.isEmpty())) {
                        employeeMethods.modify();
                    } else {
                        System.out.println("There are no employees in the list to modify");
                    }
                }
                case 3 -> {
                    if (!(hashTable.isEmpty())) {
                        employeeMethods.delete();
                    } else {
                        System.out.println("There are no employees in the list to delete");
                    }
                }
                case 4 ->{
                    if (!(hashTable.isEmpty())) {
                        employeeMethods.listOfEmployees();
                    }
                    else{
                        System.out.println("The list is empty");
                    }
                }
                case 5 ->{
                    if (!(hashTable.isEmpty())) {
                        employeeMethods.search();
                    }
                    else{
                        System.out.println("The list is empty");
                    }
                }

                default -> System.out.println("enter a valid choice");
            }
            System.out.println("1-->to do other operations 2--> Exit");
            again=scanner.nextInt();
        }while (again==1);

    }

}
