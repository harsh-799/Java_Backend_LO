package basics;

import java.sql.*;

public class BasicConnections {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // JDBC REQUIRES 7️⃣ STEPS FOR PROPER WORKING

        // STEP 1️⃣ : Import the packages (import java.sql.*;)

        // STEP 2️⃣: Loading the Drivers (Mysql)
        Class.forName("com.mysql.cj.jdbc.Driver"); // 🧽 Throws ClassNotFoundException

        // STEP 3️⃣:  Establish the Connections
        String DatabaseName = "jdbc_learning";
        String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
        String username = "root";
        String password = "ideapad"; // It;s locally you can't heck me..
        Connection conn = DriverManager.getConnection(url,username,password); // 🧽 Throws Java SQLException

        // STEP 4️⃣: Create Statements
        Statement st = conn.createStatement();

        // STEP 5️⃣: Execute Query
        ResultSet rs = st.executeQuery("SELECT * FROM sampleData");

        // STEP 6️⃣: Processing the Data
        while (rs.next()){
            System.out.println("ID: "+rs.getInt(1) + ", Name: "+rs.getString(2) + ", Age: " + rs.getInt(3));
        }

        // STEP 7️⃣: Close the Connections
        rs.close();
        conn.close();


        /*
        OUTPUT 🖥️
        ID: 1, Name: Harsh, Age: 22
        ID: 2, Name: Varun, Age: 23
        ID: 3, Name: Motka, Age: 24

         */


    }
}
