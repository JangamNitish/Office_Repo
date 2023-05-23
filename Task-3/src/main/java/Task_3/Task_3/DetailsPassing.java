package Task_3.Task_3;


import java.util.Scanner;
import java.util.logging.Logger;


public class DetailsPassing {
    static Logger log = Logger.getLogger("DetailsPassing");
    

    public static void main(String[] args) throws Exception {
        Connector con = new Connector();
        int choice;
        do {
        	 System.out.println("1--> insert 2--> Update  3-->Delete  4--> jason format");
            Scanner scanner = new Scanner(System.in);
            int key=scanner.nextInt();
            switch (key) {
            case 1:{
            	 System.out.println("ID");
                int employeeId=scanner.nextInt();
                scanner.nextLine();
                System.out.println("name");
                String employeeName=scanner.nextLine();
                System.out.println("salary");
                int salary=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type");
                String employeeType=scanner.nextLine();

                EmployeePojo aE=new EmployeePojo(employeeId,employeeName,salary,employeeType);
                con.createDetails(aE);
                con.addToSubTables();

                log.info("Details are added");
                break;

                
            }
                
            case 2:{
                System.out.println("Updating");
                System.out.println("ID");
                int employeeId=scanner.nextInt();
                scanner.nextLine();
                System.out.println("name");
                String employeeName=scanner.nextLine();
                System.out.println("salary");
                int salary=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type");
                String employeeType=scanner.nextLine();
                EmployeePojo aE=new EmployeePojo(employeeId,employeeName,salary,employeeType);
                con.updateDetails(aE);
                con.addToSubTables();
                
                log.info("Deatils are updated");
                break;

            }
            case 3:{
                System.out.println("ID to delete");
                int id=scanner.nextInt();
                con.deleteDetails(id);
                log.info("Details are deleted");
                con.addToSubTables();
                break;

            }
            case 4:{
                con.displayJason();
                break;

                
            }
            default:
                System.out.println("Enter valid choice");
                break;
            }
            System.out.println("5--> continue 2--> Exit");
            choice=scanner.nextInt();

            
        }while(choice==5);
            
    
    }

}