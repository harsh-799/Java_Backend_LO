package registrationform;

import java.sql.*;

public class Model {
    private String name;
    private String age;
    private String city;
    private String skills;
    private String password;
    Connection conn;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Model() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh_db","root","ideapad");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("db connection err: "+ e);
        }
    }

    public boolean insertData() {
        try (
                PreparedStatement ps = conn.prepareStatement("INSERT INTO mvctask " +
                        "(name, age, city, skills, password) VALUES (?, ?, ?, ?, ?)");) {
            ps.setString(1, name);
            ps.setString(2, age);
            ps.setString(3, city);
            ps.setString(4, skills);
            ps.setString(5, password);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean getData(Model dbConnect, String resname, String respass) {
        boolean isValid = false;
        try (
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM mvctask " +
                        "WHERE name = ? AND password = ?");
        ) {
            ps.setString(1, resname);
            ps.setString(2, respass);

            try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()){
                    dbConnect.setName(rs.getString("name"));
                    dbConnect.setAge(rs.getString("age"));
                    dbConnect.setCity(rs.getString("city"));
                    dbConnect.setSkills(rs.getString("skills"));
                    isValid = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (isValid) return true;
        return false;
    }
}
