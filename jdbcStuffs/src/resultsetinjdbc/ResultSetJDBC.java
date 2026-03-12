package resultsetinjdbc;

import myjdbcutil.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetJDBC {
    public static void attempt1() {
        Connection conn = ConnectJDBC.connectDB();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from statementInJDBC");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Sal: " + rs.getInt(3));
            }

            /*
            OUTPUT
            ROW 1: ID: 1, Name: Harsh, Sal: 20000
            ROW 2: ID: 2, Name: Varun, Sal: 70000
            ROW 3: ID: 3, Name: MOTKA, Sal: 90000
            ROW 4: ID: 4, Name: Golu, Sal: 50000
            ROW 5: ID: 5, Name: Pappu, Sal: 65000
             */

            // So, now our cursor is at the next row to the last row which is ROW 6.

            rs.first(); // Will lead to exception java.sql.SQLException: Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY.

            /*
            ⚠️ Why rs.first() fails
            🔒 By default, a PreparedStatement creates a forward-only ResultSet (TYPE_FORWARD_ONLY). That means:
            - You can only move forward with rs.next().
            - Methods like rs.first(), rs.previous(), rs.absolute(n) are not supported unless you explicitly request a scrollable type.

             */
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void attempt2() {
        Connection conn = ConnectJDBC.connectDB();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM statementInJDBC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Sal: " + rs.getInt(3));
            }

            /*
            OUTPUT
            ROW 1: ID: 1, Name: Harsh, Sal: 20000
            ROW 2: ID: 2, Name: Varun, Sal: 70000
            ROW 3: ID: 3, Name: MOTKA, Sal: 90000
            ROW 4: ID: 4, Name: Golu, Sal: 50000
            ROW 5: ID: 5, Name: Pappu, Sal: 65000
             */

            // 📦 So, now our cursor is at the next row to the last row which is ROW 6.

            rs.first(); // ⚠️ Will work fine, and it'll move the cursor to the first Row (MIND IT NOT BEFORE THE FIRST ROW)

            if (rs.next()) System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Sal: "+rs.getInt(3)); // ID: 2, Name: Varun, Sal: 70000
            if (rs.previous()) System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Sal: "+rs.getInt(3)); // ID: 1, Name: Harsh, Sal: 20000

            // MOST IMPORTANT:
            // ✨ Don't relate the ResultSet cursor with the Iterator cursor both works very differently resultSet cursor goes rows to rows whereas iterator one goes in between two elements.

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /*
    | Method        | Meaning              |
| ------------- | -------------------- |
| `next()`      | Move to next row     |
| `previous()`  | Move to previous row |
| `first()`     | Move to first row    |
| `last()`      | Move to last row     |
| `absolute(n)` | Move to nth row      |

     */

    public static void main(String[] args) {
        // attempt1();
        // attempt2();
    }
}

