package com.harsh.hibernate.caching;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class L1Cache {

    public static void accessingDiffStudents() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.get(Student.class, 1);
            System.out.println(student.getsName());

            Student student2 = session.get(Student.class, 2);
            System.out.println(student2.getsName());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        /* OUPUT
        Hibernate: 
    select
        s1_0.sId,
        s1_0.sCity,
        s1_0.sName 
    from
        students_table s1_0 
    where
        s1_0.sId=?
    Constructor is called
        ✅ Harsh

    Hibernate:
    select
        s1_0.sId,
        s1_0.sCity,
        s1_0.sName 
    from
        students_table s1_0 
    where
        s1_0.sId=?
    Constructor is called
    ✅ Varun

    SEE 2 times the query is there in terminal so 2 times we hit the DB when the student were diff, now lets try accessing the same student
        
         */
    }

    public static void accessingSameStudent() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.get(Student.class, 1);
            System.out.println(student.getsName());

            Student accessingSameStudent = session.get(Student.class, 1);
            System.out.println(accessingSameStudent.getsName());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        /*
        Hibernate:
    select
        s1_0.sId,
        s1_0.sCity,
        s1_0.sName
    from
        students_table s1_0
    where
        s1_0.sId=?
    Constructor is called
    ✅ Harsh
    ✅ Harsh

    See only 1 time query ran means for the second time the data is in L1 cache and we're not accessing the second time from DB instead we're getting it from L1 Cache memory.

    ⚠️ NOTE: L1 cache is session specific if we try to access it in another session for sure it'll hit the DB.
         */
    }

    public static void accessingWithoutClosingSession() {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.get(Student.class, 3);
            System.out.println(student.getsName());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) {
                forwardingToDiffMethod(session);
            }
        }
    }

    public static void forwardingToDiffMethod(Session passedSession){

        try {

            Student student = passedSession.get(Student.class, 3);
            System.out.println(student.getsName());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (passedSession != null) passedSession.close();
        }
        
        /*
        
    Hibernate: 
    select
        s1_0.sId,
        s1_0.sCity,
        s1_0.sName 
    from
        students_table s1_0 
    where
        s1_0.sId=?
    Constructor is called
    ✅ Anjali
    ✅Anjali
    
    See only one DB hit since we used session in diff methods instead of creating new session per method.
         */
    }
    public static void main(String[] args) {
        // accessingDiffStudents();
        // accessingSameStudent();
        // accessingWithoutClosingSession();
    }
}
