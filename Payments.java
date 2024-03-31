import java.sql.*;
import java.util.Scanner;

public class Payments {

    private static Scanner sc = new Scanner(System.in);

    private static int customerNumber;
    private static String CheckNumber;
    private static String paymentDate;
    private static double amount;

    public static void updatePayment(){

        System.out.println("===========================");
        System.out.println("       UPDATE PAYMENT      ");
        System.out.println("===========================\n");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","12345");
        
            String selectCol = "SELECT * FROM payments WHERE customerNumber = ?";
            PreparedStatement ps = con.prepareStatement(selectCol);

            System.out.print("Enter customer number: ");
            customerNumber = sc.nextInt();
                            sc.nextLine();

            ps.setInt(1, customerNumber);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("customerNumber: " + rs.getInt("customerNumber"));
                System.out.println("checkNumber: " + rs.getString("checkNumber"));
                System.out.println("paymentDate: " + rs.getString("paymentDate"));
                System.out.println("amount: " + rs.getString("amount"));


                System.out.print("\nWant to update this record? (Y/N): ");
                char choice = sc.next().charAt(0);

                if (choice == 'y' || choice == 'Y'){

                    int stopper = 1;
                    do{
                        System.out.print("Enter column name to update: ");
                        String col_name = sc.next();
                        System.out.print("Enter updated value: ");
                        String new_value = sc.next();
                 
                        String updateQuery = "UPDATE payments SET " + col_name + " = ? " + "WHERE  customerNumber = ?";
                        PreparedStatement updatePs = con.prepareStatement(updateQuery);
                        updatePs.setString(1, new_value);     
                        updatePs.setInt(2, customerNumber);

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
}
