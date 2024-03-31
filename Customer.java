import java.sql.*;
import java.util.Scanner;

import javax.swing.plaf.nimbus.State;

public class Customer {
    private static Scanner sc = new Scanner(System.in);

    private static int customerNo;
    private static String customerName;
    private static String contactLastName;
    private static String contactFirstName;
    private static String contactNo;
    private static String addressLine1;
    private static String addressLine2;
    private static String city;
    private static String state;
    private static String postalCode;
    private static String country;
    private static Integer salesRepEmpNo;
    private static double creditLimit;

    public static void createCustomer(){
        System.out.println("===========================");
        System.out.println("      CREATE CUSTOMER      ");
        System.out.println("===========================\n");

        int stopper = 1;
        do{    
            System.out.print("Enter customer number: ");
            customerNo = sc.nextInt();
                        sc.nextLine();
            
            System.out.print("Enter customer name: ");
            customerName = sc.nextLine();

            System.out.print("Enter contact's last name: ");
            contactLastName = sc.nextLine();

            System.out.print("Enter contact's first name: ");
            contactFirstName = sc.nextLine();

            System.out.print("Enter contact number: ");
            contactNo = sc.nextLine();

            System.out.print("Enter address line 1: ");
            addressLine1 = sc.nextLine();

            System.out.print("Enter address line 2: ");
            addressLine2 = sc.nextLine();

            System.out.print("Enter city: ");
            city = sc.nextLine();

            System.out.print("Enter state: ");
            state = sc.nextLine();

            System.out.print("Enter postal code: ");
            postalCode = sc.nextLine();

            System.out.print("Enter country: ");
            country = sc.nextLine();

            System.out.print("Enter sales representative number: ");
            try {   
                salesRepEmpNo = Integer.parseInt(sc.nextLine());
             } catch (NumberFormatException nfe) {
                salesRepEmpNo = null;
             }

            System.out.print("Enter credit limit: ");
            creditLimit = sc.nextDouble();

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");

                PreparedStatement stmt;
                String add = "INSERT INTO customers " + "(customerNumber, customerName, contactLastName, contactFirstName, phone," +  
                                                        "addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) " + 
                                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                stmt = con.prepareStatement(add);

                stmt.setInt(1, customerNo);
                stmt.setString(2, customerName);
                stmt.setString(3, contactLastName);
                stmt.setString(4, contactFirstName);
                stmt.setString(5, contactNo);
                stmt.setString(6, addressLine1);
                stmt.setObject(7, addressLine2, Types.VARCHAR);
                stmt.setString(8, city);
                stmt.setObject(9, state, Types.VARCHAR);
                stmt.setObject(10, postalCode, Types.VARCHAR);
                stmt.setString(11, country);
                stmt.setObject(12, salesRepEmpNo, Types.INTEGER);
                stmt.setDouble(13, creditLimit);

                int x = stmt.executeUpdate();

                if (x > 0){
                    System.out.println("\nSuccessfully inserted\n");
                } else{
                    System.out.println("Not inserted\n");
                }

                stmt.close();
                con.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.print("Insert another record (Y/N): ");
            char insert_loop = sc.next().charAt(0);

            if (insert_loop == 'n' || insert_loop == 'N'){
                stopper = 0;
            } else {
                System.out.println();
            }

        } while (stopper == 1);
    }

    public static void updateCustomer(){

        //Statement st_for_noOfCols = null;
        //ResultSet rs_for_noOfCols = null;
        //ResultSet rs_for_query = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");

            String selectCol = "SELECT * FROM products WHERE customerNumber = ?";
            PreparedStatement pstmt = con.prepareStatement(selectCol);

            System.out.print("Enter customer number: ");
            int customerNo = sc.nextInt();
                            sc.nextLine();

            pstmt.setInt(1, customerNo);

            ResultSet rs = pstmt.executeQuery(selectCol);

            if (){
                while(rs.next()){

                            }
            } else {
                System.out.println("\nRecord does not exist. Going back to main menu...\n");
            }

            


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}