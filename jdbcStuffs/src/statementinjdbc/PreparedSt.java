package statementinjdbc;

import myjdbcutil.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedSt {
    public static void main(String[] args) {
        Connection conn = ConnectJDBC.connectDB();
        Scanner sc = new Scanner(System.in);

        // STEP 4️⃣: Create preparedStatement() {with query}
        int id = sc.nextInt();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM statementInJDBC WHERE ID=?");
            ps.setInt(1,id);
        } catch (SQLException e) {
            System.out.println(e);
        }

        // STEP 5️⃣: Execute the preparedStatement()
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        // STEP 6️⃣: Consume the Value
        while (true){
            try {
                if (rs.next() == false) break;
            } catch (SQLException e) {
                System.out.println(e);
            }
            System.out.println("DATA FOUND, BELOW ARE THE DETAILS..");
            try {
                System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Sal: "+rs.getInt(3));
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        /* 🖥️ OUTPUT
        2
        DATA FOUND, BELOW ARE THE DETAILS..
        ID: 2, Name: Varun, Sal: 70000
         */
    }
}
