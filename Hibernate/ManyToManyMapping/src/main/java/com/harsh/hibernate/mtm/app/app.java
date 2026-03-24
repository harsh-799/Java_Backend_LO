package com.harsh.hibernate.mtm.app;

import com.harsh.hibernate.mtm.model.EmployeeMTM;
import com.harsh.hibernate.mtm.model.ProjectMTM;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class app {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void part1() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Removing the element since we know if we use Cascade.ALL all elements gets deleted but we haven't used .ALL so lets see if our work flow is okay or not.

            EmployeeMTM empToRemove = session.get(EmployeeMTM.class, 510);
            session.remove(empToRemove);

            // empToRemove = null; // Saving at java end
            /*
            👉 ❌ Not needed
            Why?
            👉  Hibernate already scheduled delete
            👉 Java GC will handle memory automatically
             */

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }
    }
    public static void main(String[] args) {
        part1();
    }
}
