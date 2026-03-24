package com.harsh.hibernate.mtm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProjectMTM {
    @Id
    int projectId;
    String projectName;

    // Earlier one project was linked to one person so we used simple object, but now one project can be linked to many employee so we need a collections.

    @ManyToMany(mappedBy = "projectListForEmployee")
    List<EmployeeMTM> employeeForThisProject = new ArrayList<>();

    public List<EmployeeMTM> getEmployeeForThisProject() {
        return employeeForThisProject;
    }

    public void setEmployeeForThisProject(List<EmployeeMTM> employeeForThisProject) {
        this.employeeForThisProject = employeeForThisProject;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // Helper methods
    public void addEmployee(EmployeeMTM emp) {
        employeeForThisProject.add(emp);
        emp.getProjectListForEmployee().add(this); // saving in the list of projects of emp instance from here
    }
}
