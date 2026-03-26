package com.harsh.hibernate.model;

import jakarta.persistence.*;

@Entity
public class EmployeeCred {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empNumber;

    @OneToOne
    AccentureEmployee employee;

    String password;

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public AccentureEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(AccentureEmployee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
