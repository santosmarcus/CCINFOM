import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class App {
    public static void main(String[] args){
      
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

        
    }
}
