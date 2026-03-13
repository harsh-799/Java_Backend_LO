package crudapp.insertion;

import myjdbcutil.CrudJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class InsertData {
    private static final Connection conn = CrudJDBC.connectDB();

    public static void insertNewSection(String sectionName){
        try {
            PreparedStatement ps = conn.prepareStatement("CREATE TABLE "+sectionName+ " (RollNo INT UNIQUE, Name VARCHAR(20), Email VARCHAR(20))"); // Skipping skl INjection checks for now.

            int changes = ps.executeUpdate(); // Doesn't matter here, because DDL Commands always return 0 - DDL (CREATE, ALTER, DROP)
            // - 🌟 DML (INSERT, UPDATE, DELETE): returns number of rows affected

            // 🌟 So these all are useless
            // if (changes!= 0){
            //     System.out.println("New Section Added");
            // }

            System.out.println("New Section Added Named "+sectionName);

        }catch (SQLException e){
            if (e.getMessage().equals("Table '"+sectionName+"' already exists")) System.out.println("Section "+sectionName+" is already in School DB.");
            else System.out.println(e.getMessage());
        }
    }

    public static void insertNewStudent(int rollNo, String name, String email, String sectionName){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO "+sectionName+" VALUES (?, ?, ?)");

            ps.setInt(1,rollNo);
            ps.setString(2,name);
            ps.setString(3,email);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Data Added successfully");
            } else {
                System.out.println("Can;t add data");
            }
        }
        catch(SQLException e){
            String errMsg = e.getMessage();
            if (errMsg.contains("Duplicate entry"))  System.out.println("There is Alreayd student present with RollNo " + rollNo+" in the section "+sectionName);
            else if (errMsg.contains("doesn't exist")) System.out.println("There is no Section Named "+sectionName+" in School DB, Kindly Add Section First");
            else System.out.println(e.getMessage());
        }
    }
}
