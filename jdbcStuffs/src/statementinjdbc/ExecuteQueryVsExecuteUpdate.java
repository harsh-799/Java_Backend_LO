package statementinjdbc;

import myjdbcutil.ConnectJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryVsExecuteUpdate {

    // There are mainly three ways to execute the Queries:
    // 1. executeQuery() {Only for Select, Doesn't do any changes in Table, Returns a ResultSet}
    // 2. executeUpdate() {Used in INSERT, UPDATE, DELETE, CREATE, DROP, it does changes in Table, Returns a int value shows no of rows affected}
    // 3. execute() {It's a single handely which can perform both of the above method we'll see it's working}
    public static void execQuery(){
        
        Connection conn = ConnectJDBC.connectDB();

        Statement st = null;
        try {
             st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }

        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * from statementInJDBC");
        } catch (SQLException e) {
            System.out.println(e);
        }

        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                System.out.println("ID: "+rs.getInt(1) + ", Name: "+rs.getString("NAME") + ", Sal: "+rs.getInt(3));
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        /*
        OUTPUT:
        ID: 1, Name: Harsh, Sal: 20000
        ID: 2, Name: Varun, Sal: 70000
        ID: 3, Name: MOTKA, Sal: 90000
         */
    }

    public static void execUpdate()  {

        Connection conn = ConnectJDBC.connectDB();
        Statement st = null;

        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }

        int rowsAffected = 0;
        try {
            rowsAffected = st.executeUpdate("INSERT INTO statementInJDBC (Id,Name,Salary) VALUES (4,'Golu',50000)");
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (rowsAffected!=0){
            System.out.println("Data updated successfully..");
        } else {
            System.out.println("Some Issues while entering Data");
        }

        /*
        OUTPUT
        ID: 1, Name: Harsh, Sal: 20000
        ID: 2, Name: Varun, Sal: 70000
        ID: 3, Name: MOTKA, Sal: 90000

        Data updated successfully..

        ID: 1, Name: Harsh, Sal: 20000
        ID: 2, Name: Varun, Sal: 70000
        ID: 3, Name: MOTKA, Sal: 90000
        ID: 4, Name: Golu, Sal: 50000
         */
    }

    public static void exec(){
        Connection conn = ConnectJDBC.connectDB();

        Statement st = null;
        boolean isResultSet = false;

        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            isResultSet = st.execute("INSERT INTO statementInJDBC VALUES (5, 'Pappu', 65000)");
        } catch (SQLException e) {
            System.out.println(e);
        }

        if(isResultSet){
            ResultSet rs = null;
            try {
                rs = st.getResultSet();
            } catch (SQLException e) {
                System.out.println(e);
            }

            while(true){
                try {
                    if (rs.next() == false) break;
                } catch (SQLException e) {
                    System.out.println(e);
                }
                try {
                    System.out.println("ID: "+rs.getInt(1) + ", Name: "+rs.getString(2) + ", Sal: "+rs.getInt(3));
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else {
            int rowsAffected = 0;
            try {
                rowsAffected = st.getUpdateCount();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (rowsAffected != 0){
                System.out.println("Data changed successfully..");
            } else {
                System.out.println("There might be some issues");
            }
        }
    //     Data inserted successfully.
    }
    public static void main(String[] args) {
        // execQuery();
        // execUpdate();
        // execQuery();
        // exec();
    }
}
