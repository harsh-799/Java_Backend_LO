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
            emp1.setEmpId(510);
            emp1.setEmpName("Ramesh");

            // Employee 2
            EmployeeMTM emp2 = new EmployeeMTM();
            emp2.setEmpId(511);
            emp2.setEmpName("Suresh");

            // Project 1
            ProjectMTM project1 = new ProjectMTM();
            project1.setProjectId(310);
            project1.setProjectName("Farming SImulator");

            // Project 2
            ProjectMTM project2 = new ProjectMTM();
            project2.setProjectId(311);
            project2.setProjectName("Gujrat Titans");

            // 🏷️ List of Projects for emp1
            emp1.addProjects(project1);
            emp1.addProjects(project2);
            emp2.addProjects(project1);

            // 🏷️ Till now we have achieved one person can do many projects (Saving list of projects for Emp 1)


            // 🏷️ Now how project will now that i am connected to which employee so for specfic projects we need to create specific collN which contains which emp is using this project
            // Better Way of writing this implementation is:
            // project1.addEmployee(emp1);
            // project2.addEmployee(emp1);

            // These both not needed think why??

            // Because in the helper method of the emp we have set the emp for specific project in last line so doing this here makes it duplicate entry in the join table so ERROR: Duplicate entry '500-300'

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
