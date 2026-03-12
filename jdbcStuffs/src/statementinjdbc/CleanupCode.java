package statementinjdbc;

import myjdbcutil.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CleanupCode {
    public static void main(String[] args) {
        Connection conn = ConnectJDBC.connectDB();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM statementInJDBC WHERE ID=?");

            ps.setInt(1,2);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            while (rs.next()){
                System.out.println("Data found successfully, below are the details: ");
                found = true;
                System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Sal: "+rs.getInt(3));
            }

            if (!found) System.out.println("No data with ID: 2 is in DB");

            // MORE OPTIMAL THINKING SHOULD BE SINCE WE'RE SEARCHING THROUGH ID AND WE KNOW ID IS UNIQUE FOR EVERYONE SO WE DON'T NEED TO APPLY LOOP HERE.

            if (rs.next()){
                System.out.println("Data found successfully, below are the details: ");
                System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Sal: "+rs.getInt(3));
            } else {
                System.out.println("No data with ID: 2 is in DB");
            }
            // 🖥️ Here the output will be:
            /*
            Data found successfully, below are the details:
            ID: 2, Name: Varun, Sal: 70000
            No data with ID: 2 is in DB

            🧠 Reason: ResultSet has cursor once the cursor we use next() cursor go to the next row since we don't have any value or any other row so it shows No data with ID: 2 is in DB
             */


            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Database error: "+e);
        }

    }
}
