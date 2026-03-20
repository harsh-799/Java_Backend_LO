package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RetrievingData {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = null;
        // Since for retrival we don't do any operation so we don't need transaction

        try {
            session = factory.openSession();
            Student student = session.get(Student.class, 100); // We're getting the data from DB where sid = 1 now the Hibernate will map on it;s itself and return us a new object with that mapped data. and if no records is found it returns null

            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("No records found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
