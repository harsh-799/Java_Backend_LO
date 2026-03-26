package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DeletingTheData {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void deletingEmployee() {

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("DELETE FROM AccentureEmployee WHERE empName = :employeeName AND salary > :employeeSalary").setParameter("employeeName","Amit jee").setParameter("employeeSalary",60000);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated != 0) {
                System.out.println(rowsUpdated + " employee removed successfully.");
                // return; Never do that because we'll never reach to transactioncommit

            } else {
                System.out.println("No employee found ");
            }

            transaction.commit();
            /* ❌ ERROR
            Mar 26, 2026 3:26:50 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
            WARN: SQL Error: 1451, SQLState: 23000
            Mar 26, 2026 3:26:50 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
            ERROR: Cannot delete or update a parent row: a foreign key constraint fails             (`hibernate_learning`.`employeecred`, CONSTRAINT `FKthg412d9rrdrfqpp2igiu1aka` FOREIGN KEY          (`employee_empId`) REFERENCES `accentureemployee` (`empId`))

            REASON: You might be wondering Hey we have used Cascade type as ALL it should the child too but why it's not doing here??
            - The main concept is ENtity and HQL both are different stuffs, The cascade rule is implemented by Entity one Not HQL.
            - Way 1: Or the ANother way is using Loop (We'll cover both.
            - Way 2: SO for HQL we need to explicitly remove the child first then Parent.

             */
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void seeingWay1() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM AccentureEmployee WHERE city = :empCity").setParameter("empCity","Pune");

            List<AccentureEmployee> employeeGoingToBeRemoved = query.list();

            if (employeeGoingToBeRemoved.isEmpty()) {
                System.out.println("No Employee Found in the city Pune");
                return;
            }

            for (AccentureEmployee emp : employeeGoingToBeRemoved) {
                session.remove(emp);
            }

            transaction.commit();
            System.out.println(employeeGoingToBeRemoved.size() + " removed.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
    public static void main(String[] args) {
        // deletingEmployee();
        seeingWay1();
    }
}
