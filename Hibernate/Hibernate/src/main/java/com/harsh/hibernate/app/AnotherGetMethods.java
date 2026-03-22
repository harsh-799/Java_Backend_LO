package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnotherGetMethods {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void getMethod(){
        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.get(Student.class,1);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void loadMethod(){
        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.load(Student.class,1);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void loadMethodAccessingStuffs(){
        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.load(Student.class,1);

            System.out.println(student.getsId());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public static void loadMethodAccessingStuffsAllStuffs(){
        Session session = null;

        try {
            session = factory.openSession();

            Student student = session.load(Student.class,1);

            System.out.println(student);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
    public static void main(String[] args) {
        // getMethod();
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
    Student{sId=1, sName='Harsh', sCity='Gaya Ji'}

    See it's example of eager loading here at the .get() only the db is hitted.
         */

        // loadMethod(); // Constructor is called

        // loadMethodAccessingStuffs();
        /*
        Constructor is called
        1
         */

        loadMethodAccessingStuffsAllStuffs();
        /*
        Constructor is called
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
Student{sId=1, sName='Harsh', sCity='Gaya Ji'}

    SEE IN THIS TWO TIMES OBJ IS CREATED BECAUSE TWO TIMES CONSTRUCTOR IS CALLED.
    AT ONCE, WHILE CREATING THE PROXY OBJECT
    SECOND, WHEN ACCESSING THE DATA (MAPPING DONE AT THIS PHASE ONLY)
         */

    //     load() is deprecated so we'll use getReference().

    }
}
