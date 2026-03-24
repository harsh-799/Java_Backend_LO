package com.harsh.hibernate.mtm.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

/*
- Now our case is many employee will be having many project
- Many project can be assigned to many employee.
- So it's no more ManyToOne case because both side many-many is required.
- read readmepls.md why for manyToMany new table is required.
 */

@Entity
public class EmployeeMTM {
    @Id
    int empId;
    String empName;

    // Now since one Employee will have many projects, so for storing the Projects we need collection.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "emp_project_relation",
            joinColumns = @JoinColumn(name = "emp_id"), // For Renaming the column in which all the employee FK will be stored and it belongs to employee (this) table.
            inverseJoinColumns = @JoinColumn(name = "project_id"), // renames the column in which all the project FK will be stored and it's name is described using @JoinColumn
            uniqueConstraints = @UniqueConstraint(columnNames = {"emp_id", "project_id"})
    )
    List<ProjectMTM> projectListForEmployee = new ArrayList<>();

    public List<ProjectMTM> getProjectListForEmployee() {
        return projectListForEmployee;
    }

    public void setProjectListForEmployee(List<ProjectMTM> projectListForEmployee) {
        this.projectListForEmployee = projectListForEmployee;
    }

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

    // Helper methods
    public void addProjects(ProjectMTM project) {
        projectListForEmployee.add(project); // Added projects here in the projectListForEmployee collections
        project.getEmployeeForThisProject().add(this); // added curr Emp obj to Project class which is having collN where we storing EMp using that current Instance project.

    }
}
