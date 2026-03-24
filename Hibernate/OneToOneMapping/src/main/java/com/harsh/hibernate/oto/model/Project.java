package com.harsh.hibernate.oto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


// ✨ One Employee will have one project.
// ✨ One Project will have one employee.
// ✨ So this is OneToOne.

@Entity
public class Project {
    @Id
    int pid;
    String projectName;

    @OneToOne
    Employee employee;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
