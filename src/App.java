/*
CCINFOM Java App Project using DBSALES database. 

Group Code: CCINFO-007
MEMBER 1: DE GUZMAN, Evan
MEMBER 2: SANTOS, Marcus
MEMBER 3: MAULION, Ian
MEMBER 4: Tumabaga, Myrine

 */

import java.sql.*;
import java.util.Scanner;


// will put method for doing products since may choices rin sya. 


public class App {

    public static void main(String[] args){
    
    System.out.println("DBSALES JAVA TERMINAL APP");
    System.out.println("CCINFO-007\n");
    Scanner sc = new Scanner(System.in);  
   
    int stopper = 1;
    while(stopper == 1){
     

        System.out.println("===========================\n");
        System.out.println("1. Records Management");
        System.out.println("2. Transaction Management");
        System.out.println("3. Exit Program\n");
        System.out.println("===========================");
        
        System.out.print("Enter choice:");
        int inputForMainMenu = sc.nextInt();
        System.out.println("===========================");
        if (inputForMainMenu == 1){
                System.out.println("\n1. Products");
                System.out.println("2. Customers");
                System.out.println("3. Employee");
                System.out.println("4. Office\n");
                System.out.println("===========================");
                System.out.print("Enter choice:");

                int recordsInput = sc.nextInt();
                switch (recordsInput) {
                    case 1: //products
                        System.out.println("===========================\n");
                        System.out.println("1. Create a new Product");
                        System.out.println("2. Update a record of a Product");
                        System.out.println("3. Delete a record of a Product");
                        System.out.println("4. View a Product and Order List\n");
                        System.out.println("===========================");
                        System.out.print("Enter choice:");
                        int productsInput = sc.nextInt();
                        switch (productsInput) {
                            case 1: // Create new product
                            
                                break;
                        
                            case 2: // Update record of Product
                                break;
                            
                            case 3: //delete a record of product
                                break;
                            case 4: // View product and order list given a  specific year
                                break;
                            default:
                               break; 
                            }
                        break;
                    case 2: // customers 
                    // since this is not mine anymore, edit the menu as you please
                        System.out.println("===========================\n");
                        System.out.println("1. Create a new Customer");
                        System.out.println("2. Update a record of Customer");
                        System.out.println("3. Delete a record of Customer");
                        System.out.println("4. View a Customer and order list of Customer\n");
                        System.out.println("===========================");
                        System.out.print("Enter choice:");
                        int customersInput = sc.nextInt();
                        switch (customersInput) {
                            case 1:
                                
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                break;
                          
                        }
                        break;
                    case 3: // employee 
                    // since this is not mine anymore, edit the menu as you please
                        System.out.println("===========================\n");
                        System.out.println("1. Create a new Employee");
                        System.out.println("2. Update a record of Employee");
                        System.out.println("3. Delete a record of Employee");
                        System.out.println("4. View an Employee and Customer list \n");
                        System.out.println("===========================");
                        System.out.print("Enter choice:");
                        int employeesInput = sc.nextInt();
                        switch (employeesInput) {
                            case 1:
                                
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                break;
                            }
                        break;
                    case 4: //office
                    // since this is not mine anymore, edit the menu as you please
                        System.out.println("===========================\n");
                        System.out.println("1. Create a new Office");
                        System.out.println("2. Update a record of an Office");
                        System.out.println("3. Delete a record of an Office");
                        System.out.println("4. View an Office and list of Employees \n");
                        System.out.println("===========================");
                        System.out.print("Enter choice:");
                        int officesInput = sc.nextInt();
                        switch (officesInput) {
                            case 1:
                                
                                break;
                        
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                break;
                            }
                        break;
                    default:
                        break;
                }

        }
        else if(inputForMainMenu == 2){
                System.out.println("2");
        }
        else if(inputForMainMenu == 3){
                System.out.println("Ending program...");
                stopper = 0;
        }
        else{
                System.out.println("Invalid choice");
        }
        }// end of while loop
    sc.close();


/* 
        try{
            System.out.println("Customer Number" + "  ---  " +  "Customer Name" + "  ---  " + "Contact Last Name");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbsales","root","12345"
            );
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");
            while(rs.next())
            System.out.println(rs.getInt(1) + "  ---  " + rs.getString(2)+"  ---  "+rs.getString(3));
            con.close();
        }catch(Exception e){System.out.println(e);}
*/
        

    
}
}
