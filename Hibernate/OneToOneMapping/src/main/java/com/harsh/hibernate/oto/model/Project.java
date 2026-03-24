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

    @OneToOne(mappedBy = "project") // 🧨 mappedBy means Don’t create FK here, it already exists on the other side. 👉 mappedBy is used to avoid duplicate foreign keys by marking one side as non-owner
    Employee employee;

    /*
    🎯 Final memory trick
    No mappedBy → 2 owners → 2 FK ❌
    With mappedBy → 1 owner → 1 FK ✅
     */

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
