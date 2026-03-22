package com.harsh.hibernate.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 🚢 The Class which needs to be mapped must be declared with the @Entity Annotation.
@Table(name = "students_table") // 🧵 We can change the table Name in DB using @Table(name = "") if we don't provide that it'll keep the table name same as className.
@Cacheable // 🏷️ Must be defined so that for Hibernate can know that this class supports caching stuffs in better words (enables L2 cache for this entity)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) // 🏷️ The Cache type is only for read (defines caching behavior (read-only, read-write, etc.))
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
