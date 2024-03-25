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

public class App {
    public static void main(String[] args){

    System.out.println("DBSALES JAVA TERMINAL APP");
    System.out.println("CCINFO-007\n");
    Scanner sc = new Scanner(System.in);  

    int stopper = 1;
    while(stopper == 1){

        System.out.println("===========================\n");
        System.out.println("1. Records Management");
        System.out.println("2. Transaction Management\n");
        System.out.println("===========================");
        
        System.out.print("Enter choice: ");
        int inputForMainMenu = sc.nextInt();
        if (inputForMainMenu == 1){
            System.out.println("1");
        }
        else if(inputForMainMenu == 2){
            System.out.println("2");
        }
        else{
            System.out.println("Invalid choice");
        }

    }
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
        }catch(Exception e){System.out.println(e);}*/

        

    
}
}
