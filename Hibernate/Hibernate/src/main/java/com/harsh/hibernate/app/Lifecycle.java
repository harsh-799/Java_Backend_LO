package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lifecycle {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Student student = new Student();
            student.setsId(5);
            student.setsName("Vansh");
            student.setsCity("Siliguri");

            System.out.println(transaction.isActive()); // ✅ true
            transaction.commit(); // 🚀 As soon as the transaction is commited it's state changes to false and it can't be no longer use to commit the changes, we need to make a new for doing transaction.
            System.out.println(transaction.isActive()); // ❌ false

            /*
            After commit:
            You cannot use the same transaction again
            You must call session.beginTransaction() to start a new one

            Think of Transaction like a train ticket:

            Before commit → ticket is valid
            After commit → journey completed
            Ticket still exists in your hand, but useless now
             */
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }
    }
}
