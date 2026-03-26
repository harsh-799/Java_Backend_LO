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

            Query<AccentureEmployee> query = session.createQuery("FROM AccentureEmployee WHERE city = :empCity", AccentureEmployee.class).setParameter("empCity","Pune");

            List<AccentureEmployee> employeeGoingToBeRemoved = query.list();

            if (employeeGoingToBeRemoved.isEmpty()) {
                System.out.println("No Employee Found in the city Pune");
                transaction.rollback();
                return; // DW about session because finally executes before returning so session will be closed automatically.
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

    // I have re-inserted the data before proceeding further.
    /*
    🧠 Strategy (VERY IMPORTANT)

    👉 Since HQL does NOT apply cascade, we do:

    Step 1: Delete child
    Step 2: Delete parent

    Now we can do it using two ways here:
    either do it using subquery
    do it using Storing the ID which needs to be deleted in a list and delete them first from child and then parent
     */

    public static void seeingWay2() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            List<Integer> idsOfEmployeeGoingToBeRemoved = session.createQuery("SELECT e.empId FROM AccentureEmployee e WHERE e.city = :employeeCity", Integer.class).setParameter("employeeCity","pune").list();

            if (idsOfEmployeeGoingToBeRemoved.isEmpty()) {
                System.out.println("No employee found");
                transaction.rollback();
                return;
            }

            // Till now we got the ID's of all employee who needs to be deleted.

            // FIrst we'll delete it from CHild
            Query query = session.createQuery("DELETE FROM EmployeeCred ec WHERE ec.employee.empId IN (:empRemovingIDList)").setParameter("empRemovingIDList",idsOfEmployeeGoingToBeRemoved); // THis is 🔥 Damn important how i am accessing the ID from cred table

            int rowsAffectedInCHild = query.executeUpdate();

            // Second we'll delete
            Query query1 = session.createQuery("DELETE FROM AccentureEmployee WHERE empId IN (:empRemovingList)").setParameter("empRemovingList",idsOfEmployeeGoingToBeRemoved);

            int rowsAffectedInParent = query1.executeUpdate();

            if (rowsAffectedInCHild == 0 && rowsAffectedInParent == 0) {
                System.out.println("No EMployee found from Pune");
                transaction.rollback();
                return;
            }

            if (rowsAffectedInCHild != rowsAffectedInParent) {
                System.out.println("Some Data inconsistency, exiting the program");
                transaction.rollback();
                return;
            }

            System.out.println(idsOfEmployeeGoingToBeRemoved.size() + " deleted.");
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    /*
    🧠 When to use this approach
    | Situation            | Use                      |
| -------------------- | ------------------------ |
| Few records          | Loop + `remove()`        |
| Many records         | Bulk delete ✅ |
| Performance critical | Bulk delete ✅            |

     */
    public static void main(String[] args) {
        deletingEmployee();
        seeingWay1();
        seeingWay2();
    }
}
