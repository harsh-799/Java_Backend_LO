package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UpdatingTheData {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void updatingDataBasedOnName() {

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            Query<AccentureEmployee> query = session.createQuery("FROM AccentureEmployee WHERE empName = :employeeName", AccentureEmployee.class);
            query.setParameter("employeeName","Amit ji");

            // List<AccentureEmployee> allResults = query.list();  No need to do this (List) if we're expecting single value like here.
            //
            // if (allResults.isEmpty()) {
            //     System.out.println("No employee found with the name " + "Amit bhaiya");
            //     return;
            // }
            // AccentureEmployee targetEmployee = allResults.get(0);
            // transaction = session.beginTransaction();
            // targetEmployee.setEmpName("Amit Ji");

            // AccentureEmployee emp = query.getSingleResult(); 🧩 Part of JPA IMPLEMENTATIOn
            AccentureEmployee emp = query.uniqueResult(); // 🧩 Part of Hibernate Implementation

            if (emp == null) {
                System.out.println("No result found with that name");
                return;
            }

            transaction = session.beginTransaction();
            emp.setEmpName("Amit jee");

            transaction.commit();
            System.out.println("Data updated Successfully. ✅");

            // ✨ In this we updated the userName using hibernate Dirty checking, Not explicitly using some methods and all.

            // allResults.forEach((x) -> System.out.println("EmpId: "+x.getEmpId() + ", Emp Name: "+x.getEmpName() + ", Emp Salary: "+x.getSalary() + ", EMployee City: "+ x.getCity()));
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void updatingDataBasedOnNameUsingHQL() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("UPDATE AccentureEmployee SET salary= :empIncrementedSalary WHERE city = :empCity");

            query.setParameter("empIncrementedSalary",120000);
            query.setParameter("empCity" ,"Pune");

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Updated " + rowsUpdated + " records ✅");
            } else {
                System.out.println("No records found");
            }

            transaction.commit();

            } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

    }
    public static void main(String[] args) {
        updatingDataBasedOnName();
        updatingDataBasedOnNameUsingHQL();
    }
}
