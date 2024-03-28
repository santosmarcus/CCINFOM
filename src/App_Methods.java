import java.sql.*;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;


public class App_Methods {
    static Scanner sc = new Scanner(System.in);

    public static void product_insert(){
  
        System.out.println("Enter product id: ");
        String product_code = sc.next();
        System.out.println("Enter product name: ");
        String product_name = sc.next();
        System.out.println("Enter product line: ");
        String product_line = sc.next();
        System.out.println("Enter product scale: ");
        String product_scale = sc.next();
        System.out.println("Enter product vendor: ");
        String product_vendor = sc.next();
        System.out.println("Enter product description: ");
        String product_desc = sc.next();
        System.out.println("Enter product quantity in stock: ");
        int product_stock = sc.nextInt();
        System.out.println("Enter product price: ");
        double product_price = sc.nextDouble();
        System.out.println("Enter product MSRP: ");
        double product_MSRP = sc.nextDouble();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbsales","root","12345"
            );
         PreparedStatement stmt;
         String q1 = "INSERT INTO products" + "(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP)"
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         stmt = con.prepareStatement(q1);
         stmt.setString(1, product_code);
         stmt.setString(2, product_name);
         stmt.setString(3, product_line);
         stmt.setString(4, product_scale);
         stmt.setString(5, product_vendor);
         stmt.setString(6, product_desc);
         stmt.setInt(7, product_stock);
         stmt.setDouble(8, product_price);
         stmt.setDouble(9, product_MSRP);

         int x = stmt.executeUpdate();
         if(x > 0){
            System.out.println("Successfully inserted\n");
         }
         else{
            System.out.println("Not inserted\n");
         }
         con.close();
        } catch(Exception e){System.out.println(e);}

}   // end of Product
    public static void product_update(){

       // Statement stmt_for_query = null;
        Statement st_for_noOfCols = null;
        ResultSet rs_for_noOfCols = null;
        ResultSet rs_for_query = null;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbsales","root","12345"
            );

        String query_for_cols = "SELECT * FROM products";
        
        st_for_noOfCols = con.createStatement();
        rs_for_noOfCols = st_for_noOfCols.executeQuery(query_for_cols);

        ResultSetMetaData rsmd = (ResultSetMetaData) rs_for_noOfCols.getMetaData();
        int no_of_cols = rsmd.getColumnCount();
        
        System.out.println(no_of_cols);


        String query_test = "SELECT * FROM products WHERE productCode = ?";
        PreparedStatement ps_stmt = con.prepareStatement(query_test);
       
        System.out.println("Enter product code");
        String product_code = sc.next();
        ps_stmt.setString(1, product_code);
        rs_for_query = ps_stmt.executeQuery();

            //if statement for found record




            // produces the entire record
       while(rs_for_query.next()){
            String get_code = rs_for_query.getString("productCode");
            String get_name = rs_for_query.getString("productName");
            System.out.println("This is product code got: " + get_code);
            System.out.println("This is product name got: " + get_name);

       }
       



        

        } catch(Exception e){System.out.println(e);}


    }


     {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbsales","root","12345"
            );
         
        if(con == null){
            System.out.println("Not Connected");
        }
        else{
            System.out.println("Connected");
        }

        
        con.close();
        } catch(Exception e){System.out.println(e);}
    
    }
}

