package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LifecycleV2 {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, 4);

            student.setsName("Dogesh Babu");

            session.close();
            session.merge(student);
            transaction.commit();
            /*
            java.lang.IllegalStateException: org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl@6f91fbda is closed
            Session is closed so we can't do anything so now it's in 🔌 DETACHED STATE
            🧠 Important Concept

            👉 merge() does NOT magically revive a closed session

            👉 Once you call session.close(), that session is dead
            👉 You cannot reuse it for merge() or anything else

            ✅ Correct approach (Reopen session)

            Yes — you must open a new session to reattach the object.
         */
        }catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }

        /*
        In Hibernate, a Detached entity is an object that was previously persistent but is no longer associated with a session. Hibernate does not track changes in this state, and to persist modifications, the entity must be reattached using methods like merge() or update().
         */
    }
}
