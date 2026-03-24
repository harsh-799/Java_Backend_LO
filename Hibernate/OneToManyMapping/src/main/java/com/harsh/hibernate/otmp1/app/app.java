package com.harsh.hibernate.otmp1.app;

import com.harsh.hibernate.otmp1.model.EmployeeOTM;
import com.harsh.hibernate.otmp1.model.ProjectOTM;
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
            EmployeeOTM emp = new EmployeeOTM();
            emp.setEmpId(50);
            emp.setEmpName("Dogesh");

            EmployeeOTM emp1 = new EmployeeOTM();
            emp1.setEmpId(51);
            emp1.setEmpName("Monkesh");

            ProjectOTM project = new ProjectOTM();
            project.setPid(1000);
            project.setProjectName("AI Chatbot");

            ProjectOTM project1 = new ProjectOTM();
            project1.setPid(1001);
            project1.setProjectName("Insight IQ");

            ProjectOTM project2 = new ProjectOTM();
            project2.setPid(1002);
            project2.setProjectName("Stand for stray's");

            List<ProjectOTM> projectListforEmp1 = new ArrayList<>();
            projectListforEmp1.add(project);
            projectListforEmp1.add(project1);

            emp.setProjectList(projectListforEmp1); // This alone is not sufficient because the OWNER is now Project so we need to set from there to get the Fkey. (Refer Fault.img )


            // Setting Emp with the projects
            project.setEmployee(emp);
            project1.setEmployee(emp);

            session.persist(project);
            session.persist(project1);
            session.persist(project2);
            session.persist(emp);

            session.persist(emp1);

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
