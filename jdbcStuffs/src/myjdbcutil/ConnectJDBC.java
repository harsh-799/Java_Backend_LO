package myjdbcutil;

import java.sql.*;

public class ConnectJDBC {
    public static Connection connectDB(){

        String DatabaseName = "jdbc_learning";
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
