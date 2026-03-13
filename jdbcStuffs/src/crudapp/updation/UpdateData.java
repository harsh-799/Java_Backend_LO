package crudapp.updation;

import myjdbcutil.CrudJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    private static final Connection conn = CrudJDBC.connectDB();

    public static void updateStudentDetails(String sectionName, int roll, String updatedEmail){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE "+sectionName+" SET Email = ? WHERE rollNo = ?");

            ps.setString(1,updatedEmail);
            ps.setInt(2,roll);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Data modified successfully");
            } else {
                System.out.println("No data with roll: "+roll+" is found.");
            }
        }catch (SQLException e){
            if (e.getMessage().equals("Table '"+CrudJDBC.DatabaseName+"."+sectionName+"' doesn't exist"))
                System.out.println("There is No Section Named "+sectionName+" in DB.");
            else System.out.println(e.getMessage());
        }
    }

    public static void deleteSpecificStudent(String sectionName, int roll){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM "+sectionName+" WHERE ROLLNO = ?");

            ps.setInt(1,roll);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Data deleted" );
            } else {
                System.out.println("No rollNo. "+roll+" found to delete in the section "+sectionName);
            }
        }catch(SQLException e){
            if (e.getMessage().equals("Table '"+CrudJDBC.DatabaseName+"."+sectionName+"' doesn't exist"))
                System.out.println("There is No Section Named "+sectionName+" in DB.");
            else System.out.println(e.getMessage());
        }

    }
}
