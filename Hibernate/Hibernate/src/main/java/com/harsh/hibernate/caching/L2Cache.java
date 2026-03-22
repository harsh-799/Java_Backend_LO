package com.harsh.hibernate.caching;

import com.harsh.hibernate.model.Student;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class L2Cache {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = null;
        Session session2 = null;

        try {
            session = factory.openSession();

            Student student1 = session.get(Student.class, 1);
            System.out.println(student1);

            session.close();

            session2 = factory.openSession();
            Student student2 = session2.get(Student.class, 1);

            System.out.println(student2);

            // Now we're in different session, so according to our old L1 Cache COncept the Query should be triggered two times because L1 cache is PER Session. But here we're seeing working of L2 which works across diff session.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session2 != null) session2.close();
        }

        /*
        Hibernate:
    select
        student0_.sId as sid1_0_0_,
        student0_.sCity as scity2_0_0_,
        student0_.sName as sname3_0_0_
    from
        students_table student0_
    where
        student0_.sId=?

    Constructor is called
    Student{sId=1, sName='Harsh', sCity='Gaya Ji'}
    Constructor is called
    Student{sId=1, sName='Harsh', sCity='Gaya Ji'}

    See for them diff session too the query is invoked just one time means only 1 DB HIT that's the magic of L2 Cache
         */
    }
}
