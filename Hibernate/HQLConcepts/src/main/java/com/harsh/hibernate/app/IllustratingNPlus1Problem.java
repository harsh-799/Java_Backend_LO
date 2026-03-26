package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class IllustratingNPlus1Problem {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        Session session = factory.openSession();
        try {
            // 🏷️ Now suppose if i want people from Pune and there credentials too
            List<AccentureEmployee> employeeListFromPune = session.createQuery("FROM AccentureEmployee e WHERE e.city = :empCity", AccentureEmployee.class).setParameter("empCity","Pune").list();

            // System.out.println(employeeListFromPune); // [com.harsh.hibernate.model.AccentureEmployee@7769d9b6, com.harsh.hibernate.model.AccentureEmployee@4a520f05] SO till now we have all the employee Object who are from pune.

            // 🔦 Now suppose if we wanna to see there credentials so what we need to do.
            for (AccentureEmployee emp: employeeListFromPune) {
                // emp.getEmpId();
                // emp.getEmpName();
                // emp.getSalary(); These all won't execute the Query because this all are already loaded into the memory.
                // emp.getMyCredentials().getPassword(); // Now this comes through the another table so this is not loaded

                System.out.println(emp.getMyCredentials().getPassword());
            }

            /*
            Hibernate: (FIRST TIME)
    select
        ae1_0.empId,
        ae1_0.city,
        ae1_0.empName,
        ae1_0.salary
    from
        AccentureEmployee ae1_0
    where
        ae1_0.city=?
Hibernate: (SECOND TIME)
    select
        ec1_0.empNumber,
        e1_0.empId,
        e1_0.city,
        e1_0.empName,
        e1_0.salary,
        ec1_0.password
    from
        EmployeeCred ec1_0
    left join
        AccentureEmployee e1_0
            on e1_0.empId=ec1_0.employee_empId
    where
        ec1_0.employee_empId=?
Hibernate: (THIRD TIME)
    select
        ec1_0.empNumber,
        e1_0.empId,
        e1_0.city,
        e1_0.empName,
        e1_0.salary,
        ec1_0.password
    from
        EmployeeCred ec1_0
    left join
        AccentureEmployee e1_0
            on e1_0.empId=ec1_0.employee_empId
    where
        ec1_0.employee_empId=?
Durgesh@123
AmitTheLegend123
             */

            // So for the first time ALl the employee gets loaded from pune
        //  Now after that for each there credentials gets loaded and for each of them query runs.

        //     SO total 3 Employees are there:
        //     First Query: TO Get all employee
        //     Then N queries: For getting there password
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
