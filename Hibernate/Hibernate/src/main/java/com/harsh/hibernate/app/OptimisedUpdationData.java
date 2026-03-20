package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OptimisedUpdationData {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();

            Student student = session.get(Student.class, 1);

            student.setsCity("Gaya Ji");

            transaction = session.beginTransaction();
            transaction.commit(); // See Here, No where we have used merge() method the Hibernate will take care itself for tracking the changes. 👉 That’s it — no update(), merge() needed
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        /*
        The recommended approach is to first retrieve the entity and then modify it, as Hibernate uses dirty checking to automatically detect changes and update only modified fields.
         */
    }
}
