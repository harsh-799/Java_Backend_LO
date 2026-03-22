package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// For removing some specific Records of the row (Using dirty caching)
public class DeletingDataV2 {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            Student studentToBeRemoved = session.get(Student.class, 4);
            studentToBeRemoved.setsCity(""); // 🗃️ This will not make it as empty it's just zero white space
            studentToBeRemoved.setsCity(null); // 🧩 This makes the property as empty

            // 🌱 session.merge(studentToBeRemoved); We don't need since dirty caching will do it's work.

            transaction.commit();
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }
    }
}
