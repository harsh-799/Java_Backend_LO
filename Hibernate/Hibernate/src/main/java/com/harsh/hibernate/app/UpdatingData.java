package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatingData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Student student = new Student();
            // student.setsId(2);
            // We can't skip value otherwise in DB it'll be null
            // student.setsCity("Dehri");

            student.setsName("Harsh");
            student.setsCity("Tekari");
            student.setsId(1);

            session.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close(); // Remember we close it only when shutting the app since it's very large object
        }

        /*
        ⚠️ Problem with this approach

        👉 Hibernate treats it like:
        “Replace everything for this ID”

        So:
        Missing fields → become null ❌

        Risk of overwriting data ❌
        Not safe for partial updates ❌
        */
    }
}
