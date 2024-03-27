import java.sql.*;



public class App_Methods {


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

