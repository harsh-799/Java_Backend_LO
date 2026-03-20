package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeletingData {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, 4);

            if (student != null){
                session.remove(student);
                transaction.commit();
                System.out.println("Student Deleted");
            } else {
                System.out.println("No Students found to be delete");
            }
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
