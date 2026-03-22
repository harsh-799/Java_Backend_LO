package com.harsh.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 🚢 The Class which needs to be mapped must be declared with the @Entity Annotation.
@Table(name = "students_table") // 🧵 We can change the table Name in DB using @Table(name = "") if we don't provide that it'll keep the table name same as className.
public class Student {
    @Id // 🔦 We use @Id annotation to mark the field which will be PK in the table.
    private int sId;
    private String sName; // 📘 Now by default, the name of the column in table will be set as same as described here to change that We needed @Column(name="").
    private String sCity;

    // 🔒 We need one default constructor for hibernate..
    public Student(){
        System.out.println("Constructor is called");
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sCity='" + sCity + '\'' +
                '}';
    }
}
