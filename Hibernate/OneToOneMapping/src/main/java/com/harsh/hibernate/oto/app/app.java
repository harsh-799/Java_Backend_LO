package com.harsh.hibernate.oto.app;

import com.harsh.hibernate.oto.model.Employee;
import com.harsh.hibernate.oto.model.Project;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class app {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void part1() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Employee emp1 = new Employee();
            emp1.setEmpId(1);
            emp1.setEmpName("Harsh");

            Employee emp2 = new Employee();
            emp2.setEmpId(2);
            emp2.setEmpName("Kartik");

            Project project1 = new Project();
            project1.setPid(101);
            project1.setProjectName("LMS");

            Project project2 = new Project();
            project2.setPid(102);
            project2.setProjectName("Cyber Security");

            emp1.setProject(project1); // One Employee is linked with One project
            emp2.setProject(project2); // One Employee is linked with One project

            // If we don't Set the employee for the project then in project the column which is responsible for storing FK will be all empty means NULL.
            // See the faultImage for that.

            // To fix this we need to set the setters() for the emp from the projects. (See fault correct)
            project1.setEmployee(emp1);
            project2.setEmployee(emp2);

            session.persist(project1); // Saving Object First Because Emp is dependent on Project.
            session.persist(project2); // Saving Object First Because Emp is dependent on Project.
            session.persist(emp1);
            session.persist(emp2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }

    // ⚠️ Note: Since we're maintaining the OneToOne relationship so we can define FK anywhere, either in any table but now it;s there in both table so we'll use one table.

    // 🚀 For this we use the concept of mappedBy = (We define this in another table where we don't want Fk column.

    public static void part2() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Employee emp1 = new Employee();
            emp1.setEmpId(1);
            emp1.setEmpName("Harsh");

            Employee emp2 = new Employee();
            emp2.setEmpId(2);
            emp2.setEmpName("Kartik");

            Project project1 = new Project();
            project1.setPid(101);
            project1.setProjectName("LMS");

            Project project2 = new Project();
            project2.setPid(102);
            project2.setProjectName("Cyber Security");

            emp1.setProject(project1); // One Employee is linked with One project
            emp2.setProject(project2); // One Employee is linked with One project

            // If we don't Set the employee for the project then in project the column which is responsible for storing FK will be all empty means NULL.
            // See the faultImage for that.

            // To fix this we need to set the setters() for the emp from the projects. (See fault correct)
            project1.setEmployee(emp1);
            project2.setEmployee(emp2);

            session.persist(project1); // Saving Object First Because Emp is dependent on Project.
            session.persist(project2); // Saving Object First Because Emp is dependent on Project.
            session.persist(emp1);
            session.persist(emp2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }
    public static void main(String[] args) {
        // part1();
        part2();

    }
}
