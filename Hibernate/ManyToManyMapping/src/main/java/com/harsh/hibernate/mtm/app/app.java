package com.harsh.hibernate.mtm.app;

import com.harsh.hibernate.mtm.model.EmployeeMTM;
import com.harsh.hibernate.mtm.model.ProjectMTM;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class app {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void part1() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Employee 1
            EmployeeMTM emp1 = new EmployeeMTM();
            emp1.setEmpId(500);
            emp1.setEmpName("Ghoda");

            // Employee 2
            EmployeeMTM emp2 = new EmployeeMTM();
            emp2.setEmpId(501);
            emp2.setEmpName("Haathi");

            // Project 1
            ProjectMTM project1 = new ProjectMTM();
            project1.setProjectId(300);
            project1.setProjectName("Laravel");

            // Project 2
            ProjectMTM project2 = new ProjectMTM();
            project2.setProjectId(301);
            project2.setProjectName("PHP");

            // 🏷️ List of Projects for emp1
            List<ProjectMTM> emp1Projects = new ArrayList<>();
            emp1Projects.add(project1);
            emp1Projects.add(project2);

            // 🏷️ Till now we have achieved one person can do many projects (Saving list of projects for Emp 1)
            emp1.setProjectListForEmployee(emp1Projects);

            // 🏷️ Now how project will now that i am connected to which employee so for specfic projects we need to create specific collN which contains which emp is using this project
            List<EmployeeMTM> listOfEmployeesOnThisProject = new ArrayList<>();
            listOfEmployeesOnThisProject.add(emp1);

            List<EmployeeMTM> listOfEmployeesOnThisProject2 = new ArrayList<>();
            listOfEmployeesOnThisProject2.add(emp1);

            project1.setEmployeeForThisProject(listOfEmployeesOnThisProject);
            project2.setEmployeeForThisProject(listOfEmployeesOnThisProject2);

            session.persist(project1);
            session.persist(project2);
            session.persist(emp1);
            session.persist(emp2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }
    }
    public static void main(String[] args) {
        part1();
    }
}
