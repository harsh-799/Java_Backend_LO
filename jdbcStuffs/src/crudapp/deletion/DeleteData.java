package crudapp.deletion;

import myjdbcutil.CrudJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteData {
    private static final Connection conn = CrudJDBC.connectDB();

    public static void deleteRecords(String sectionName){
        try{

            PreparedStatement checkIfRecordsExists = conn.prepareStatement("SELECT * from "+sectionName);

            ResultSet rs = checkIfRecordsExists.executeQuery();

            if (rs.next() == false){
                System.out.println("No Data available in the table");
                return;
            }

            PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE "+sectionName);

            ps.executeUpdate();

            System.out.println("Deleted Successfully.");

        }catch (SQLException e){
            if (e.getMessage().equals("Table '"+CrudJDBC.DatabaseName+"."+sectionName+"' doesn't exist"))
                System.out.println("There is No Section Named "+sectionName+" from before.");
            else System.out.println(e.getMessage());
        }
    }

    public static void deleteTheSection(String sectionName){
        try{
            PreparedStatement ps = conn.prepareStatement("DROP TABLE "+sectionName);

            ps.executeUpdate();

            System.out.println("Deleted Entriely successfully");

        }catch (SQLException e){
            if (e.getMessage().contains("Unknown table ")) System.out.println("No Section Exists from before Named "+sectionName);
            else System.out.println(e.getMessage());
        }
    }


}
