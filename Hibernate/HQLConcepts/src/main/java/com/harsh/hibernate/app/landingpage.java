package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.model.EmployeeCred;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class landingpage {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void addingDetails() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            AccentureEmployee emp1 = new AccentureEmployee();
            emp1.setEmpName("Durgesh");
            emp1.setCity("Pune");

            AccentureEmployee emp2 = new AccentureEmployee();
            emp2.setEmpName("Telusko");
            emp2.setCity("banglore");

            AccentureEmployee emp3 = new AccentureEmployee();
            emp3.setEmpName("Abdul Bari sir");
            emp3.setCity("Delhi");

            EmployeeCred emp1Cred = new EmployeeCred();
            emp1Cred.setPassword("Durgesh@123");

            EmployeeCred emp2Cred = new EmployeeCred();
            emp2Cred.setPassword("Telusko#$EDon");

            EmployeeCred emp3Cred = new EmployeeCred();
            emp3Cred.setPassword("AbdulSirJavaKing");

            emp1.setMyCredentials(emp1Cred);
            emp1Cred.setEmployee(emp1);

            emp2.setMyCredentials(emp2Cred);
            emp2Cred.setEmployee(emp2);

            emp3.setMyCredentials(emp3Cred);
            emp3Cred.setEmployee(emp3);

            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);
            transaction.commit();
            System.out.println("Employee "+ emp1.getEmpName() + " data is saved. ✅");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void main(String[] args) {
        addingDetails();
    }
}
