package com.harsh.hibernate.model;

import jakarta.persistence.*;

@Entity
public class AccentureEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empId;
    String empName;
    String city;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    EmployeeCred myCredentials;

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public EmployeeCred getMyCredentials() {
        return myCredentials;
    }

    public void setMyCredentials(EmployeeCred myCredentials) {
        this.myCredentials = myCredentials;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
