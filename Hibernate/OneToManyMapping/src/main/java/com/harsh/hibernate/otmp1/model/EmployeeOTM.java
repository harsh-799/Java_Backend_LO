package com.harsh.hibernate.otmp1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// ✨ One Employee will have many projects.
// ✨ One Project will have only one employee.
// ✨ So this is ManyToOne (And it's valid case)
// Always the FK will be at Many side so here the many is AT Project because one employee can have many project.

@Entity
public class EmployeeOTM {
    @Id
    int empId;
    String empName;

    @OneToMany(mappedBy = "employee")
    // @JoinColumn(name = "project_id") Not here it'll be at many side and here many is at Project.
    // Now since one emp will have many project so for the project single obj is not sufficient we'll require an collecction.
    List<ProjectOTM> projectList;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<ProjectOTM> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectOTM> projectList) {
        this.projectList = projectList;
    }
}
