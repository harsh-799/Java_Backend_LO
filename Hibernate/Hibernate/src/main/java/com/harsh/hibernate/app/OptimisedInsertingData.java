package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OptimisedInsertingData {
    public static void main(String[] args) {

        // Here we're creating everything at once using method chanining.
        // Build the factory, since factory is big don't create obj (trick to remember)
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Student student = new Student();

            student.setsId(3);
            student.setsName("Anjali");
            student.setsCity("Buxar");

            session.persist(student);

            transaction.commit();
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close(); // ❗ SessionFactory is heavy + created once per app, and it's closed only when app is shut dow.
        }
    }
}
