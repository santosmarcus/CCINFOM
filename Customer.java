import java.sql.*;
import java.util.Scanner;

import javax.swing.plaf.nimbus.State;

public class Customer {
    private static Scanner sc = new Scanner(System.in);

    private static int customerNo;
    private static String customerName;
    private static String contactLastName;
    private static String contactFirstName;
    private static String phone;
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
            phone = sc.nextLine();

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

                PreparedStatement ps;
                String add = "INSERT INTO customers " + "(customerNumber, customerName, contactLastName, contactFirstName, phone," +  
                                                        "addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) " + 
                                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                ps = con.prepareStatement(add);

                ps.setInt(1, customerNo);
                ps.setString(2, customerName);
                ps.setString(3, contactLastName);
                ps.setString(4, contactFirstName);
                ps.setString(5, phone);
                ps.setString(6, addressLine1);
                ps.setObject(7, addressLine2, Types.VARCHAR);
                ps.setString(8, city);
                ps.setObject(9, state, Types.VARCHAR);
                ps.setObject(10, postalCode, Types.VARCHAR);
                ps.setString(11, country);
                ps.setObject(12, salesRepEmpNo, Types.INTEGER);
                ps.setDouble(13, creditLimit);

                int x = ps.executeUpdate();

                if (x > 0){
                    System.out.println("\nSuccessfully inserted\n");
                } else{
                    System.out.println("Not inserted\n");
                }

                ps.close();
                con.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.print("Insert another record (Y/N): ");
            char stop = sc.next().charAt(0);

            if (stop == 'n' || stop == 'N'){
                stopper = 0;
            } else {
                System.out.println();
            }
        } while (stopper == 1);
    }

    public static void updateCustomer(){

        System.out.println("===========================");
        System.out.println("      UPDATE CUSTOMER      ");
        System.out.println("===========================\n");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");
        
            String selectCol = "SELECT * FROM customers WHERE customerNumber = ?";
            PreparedStatement ps = con.prepareStatement(selectCol);

            System.out.print("Enter customer number: ");
            int customerNo = sc.nextInt();
                            sc.nextLine();

            ps.setInt(1, customerNo);
            ResultSet rs = ps.executeQuery();

            if(rs.next() == true){
                customerNo = rs.getInt("customerNumber");
                customerName = rs.getString("customerName");
                contactLastName = rs.getString("contactLastName");
                contactFirstName = rs.getString("contactFirstName");
                phone = rs.getString("phone");
                addressLine1 = rs.getString("addressLine1");
                addressLine2 = (String) rs.getObject("addressLine2");
                city = rs.getString("city");
                state = (String) rs.getObject("state");
                postalCode = (String) rs.getObject("postalCode");
                country = rs.getString("country");
                salesRepEmpNo = (Integer) rs.getObject("salesRepEmployeeNumber");
                creditLimit = rs.getDouble("creditLimit");

                System.out.println("customerNumber: " + customerNo);
                System.out.println("customerName: " + customerName);
                System.out.println("contactLastName: " + contactLastName);
                System.out.println("contactFirstName: " + contactFirstName);
                System.out.println("phone: " + phone);
                System.out.println("addressLine1: " + addressLine1);
                System.out.println("addressLine2: " + addressLine2);
                System.out.println("city: " + city);
                System.out.println("state: " + state);
                System.out.println("postalCode: " + postalCode);
                System.out.println("country: " + country);
                System.out.println("salesRepEmployeeNumber: " + salesRepEmpNo);
                System.out.println("creditLimit: " + creditLimit);

                System.out.print("\nWant to update this record? (Y/N): ");
                char choice = sc.next().charAt(0);

                if (choice == 'y' || choice == 'Y'){

                    int stopper = 1;
                    do{
                        System.out.print("Enter column name to update: ");
                        String col_name = sc.next();
                        System.out.print("Enter updated value: ");
                        String new_value = sc.next();
                 
                        String updateQuery = "UPDATE customers SET " + col_name + " = ? " + "WHERE  customerNumber = ?";
                        PreparedStatement updatePs = con.prepareStatement(updateQuery);
                        updatePs.setString(1, new_value);     
                        updatePs.setInt(2, customerNo);

                        int x = updatePs.executeUpdate(); 

                        if(x == 1){
                            System.out.println("\nRecord updated\n");
                            System.out.print("Do you still want to keep updating the record "+ customerName +" (Y/N): ");
                            char stop = sc.next().charAt(0);

                            if(stop == 'n' || stop == 'N'){
                                stopper = 0;
                            } 
                        } else {System.out.println("Error updating\n");}
                        updatePs.close();
                    } while (stopper == 1); 
                } else {
                    System.out.println("\nNot updating...\n");
                }
            } else { 
                System.out.println("\nRecord does not exist. Going back to main menu...\n");
            }
            ps.close();
            con.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCustomer(){
        System.out.println("===========================");
        System.out.println("      DELETE CUSTOMER      ");
        System.out.println("===========================\n");

        int stopper = 1;
        do{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");
                
                System.out.print("Enter column to search for value of deletion: ");
                String col_name = sc.next();
    
                System.out.print("Enter value to delete: ");
                String value = sc.next();

                String delete = "DELETE FROM customers WHERE " + col_name + "= ?";
                PreparedStatement ps = con.prepareStatement(delete);

                ps.setString(1, value);

                int x = ps.executeUpdate();

                if(x > 0){
                    System.out.println("Record " + value +" deleted successfully\n");
                } else {
                    System.out.println("Record does not exist or cannot be deleted\n");
                }

                System.out.println("Do you want to delete another record? (Y/N):  ");
                char stop = sc.next().charAt(0);

                if(stop == 'n' || stop == 'N'){
                    stopper = 0;
                }
                ps.close();
                con.close();
            } catch(SQLException e){
                if(e.getErrorCode() == 1451){
                    System.out.println("Error: Cannot delete record because it is being used as a reference by other records");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } while (stopper == 1);
    }

    public static void customerViewOrders(){
        System.out.println("===========================");
        System.out.println("    VIEW CUSTOMER ORDERS   ");
        System.out.println("===========================\n");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");


            System.out.print("Enter product code to view: ");
            customerNo = sc.nextInt();
                        sc.nextLine();
           
            String view = "SELECT * FROM customers WHERE customerNumber = ?";
            //PreparedStatement ps = con.prepareStatement(view);
            //ps.setInt(1, customerNo);

            //esultSet rs = ps.executeQuery();


            System.out.print("Enter year to view: ");
            String view_year = sc.next();

            String view_record_given_year = "SELECT od.orderNumber, od.quantityOrdered, od.orderLineNumber, o.orderDate, o.customerNumber FROM products p RIGHT JOIN orderdetails od ON p.productCode = od.productCode "
                                            + "RIGHT JOIN orders o ON od.orderNumber = o.orderNumber "
                                            + "WHERE p.productCode = " + "'" + view_code +"'"
                                            + "AND YEAR(orderDate) = " + view_year;

            PreparedStatement view_record_year = con.prepareStatement(view_record_given_year);

            //view_record_year.setString(1, view_code);

            ResultSet view_given_year_rs = view_record_year.executeQuery();

            if(view_given_year_rs.next()){
            while (view_given_year_rs.next()) {
                
                String orderNumber = view_given_year_rs.getString("od.orderNumber");
                String quantityOrder = view_given_year_rs.getString("od.quantityOrdered");
                String orderLineNumber = view_given_year_rs.getString("od.orderLineNumber");
                String orderDate = view_given_year_rs.getString("o.orderDate");
                String customerNumber = view_given_year_rs.getString("o.customerNumber");

                System.out.println("\nCustomer: " + customerNumber);
                System.out.println("Order Number: "+ orderNumber);
                System.out.println("Quantity Ordered" + quantityOrder);
                System.out.println("Order Line Number: " + orderLineNumber);
                System.out.println("Date Order made: " + orderDate + "\n");
                
                System.out.println("List generated... going back to main menu\n");
            }
        }
            else{
                System.out.println("No orders made during this year with this product\n");
            }   
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
