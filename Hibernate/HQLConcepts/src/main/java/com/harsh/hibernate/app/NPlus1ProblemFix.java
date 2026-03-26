package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NPlus1ProblemFix {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = factory.openSession();

        try {
            List<AccentureEmployee> empList = session.createQuery("Select e FROM AccentureEmployee e JOIN FETCH e.myCredentials WHERE e.city = :empCity", AccentureEmployee.class).setParameter("empCity","Pune").list();

            System.out.println(empList); // [com.harsh.hibernate.model.AccentureEmployee@773f3360, com.harsh.hibernate.model.AccentureEmployee@4c13ca07]

            // Now lets try getting there password and see if N More queries gets executed or not.

            for (AccentureEmployee emp: empList) {
                System.out.println(emp.getMyCredentials().getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        /*

Hibernate:  (Query 1)
    select
        ae1_0.empId,
        ae1_0.city,
        ae1_0.empName,
        mc1_0.empNumber,
        mc1_0.password,
        ae1_0.salary
    from
        AccentureEmployee ae1_0
    join
        EmployeeCred mc1_0
            on ae1_0.empId=mc1_0.employee_empId
    where
        ae1_0.city=?
[com.harsh.hibernate.model.AccentureEmployee@773f3360, com.harsh.hibernate.model.AccentureEmployee@4c13ca07]
Durgesh@123
AmitTheLegend123

🔥 SEE it got executed in single query only so N queries saved means N times we hitted Less DB.
         */
    }
}
