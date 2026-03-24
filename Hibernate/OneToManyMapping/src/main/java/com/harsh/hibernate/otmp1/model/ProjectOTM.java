package com.harsh.hibernate.otmp1.model;


// And One project will have only one Employee

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectOTM {
    @Id
    int pid;
    String projectName;

    @ManyToOne() // Since one project will have only one employee so Many to One.
    @JoinColumn(name = "empKey")
    // @JoinColumn(name = "empKey", nullable = false) We use this one when we don't want the empKey should be empty.
    EmployeeOTM employee;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public EmployeeOTM getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeOTM employee) {
        this.employee = employee;
    }
}
