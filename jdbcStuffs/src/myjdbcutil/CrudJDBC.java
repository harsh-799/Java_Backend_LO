package myjdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrudJDBC {

    public static String DatabaseName = "mps";

    public static Connection connectDB(){

        String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
        String username = "root";
        String password = "ideapad"; // It;s locally you can't heck me..

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            System.out.println(e);
        }finally {
            return conn;
        }
    }
}
