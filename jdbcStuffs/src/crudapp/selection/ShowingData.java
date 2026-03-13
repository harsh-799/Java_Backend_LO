package crudapp.selection;

import myjdbcutil.CrudJDBC;
import myjdbcutil.SectionNameVerifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowingData {
    private static Connection conn = CrudJDBC.connectDB();

    public static void showAllDataOfSchool(){
        try {
            PreparedStatement ps = conn.prepareStatement("SHOW TABLES");
            ResultSet rs = ps.executeQuery();

            if (rs.next() == false){
                System.out.println("There is NO Section Added in School DB");
                return;
            }

            while (rs.next()){
                System.out.println(rs.getString(1));
            }

        }catch (SQLException e){
            System.out.println("Database error: "+e);
        }
    }

    public static void showAllDataOfSection(String sectionName){

        if (!SectionNameVerifier.verify(sectionName)) return;

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM "+sectionName);
            ResultSet rs = ps.executeQuery();
            boolean hasRecords = false;

            while (rs.next()){
                System.out.println("RollNo: "+ rs.getInt(1) + " Name: "+rs.getString(2) + " Email: "+rs.getString(2));
                hasRecords = true;
            }

            if (!hasRecords){
                System.out.println("No Records in the Section "+sectionName+", Kindly Add it");
                return;
            }

        }catch (SQLException e){
            if (e.getMessage().equals("Table '"+CrudJDBC.DatabaseName+"."+sectionName+"' doesn't exist"))
                System.out.println("There is No Section Named "+sectionName+" in School DB.");
            else System.out.println(e.getMessage());
        }
    }
}
