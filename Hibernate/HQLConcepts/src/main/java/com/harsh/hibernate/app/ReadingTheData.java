package com.harsh.hibernate.app;

import com.harsh.hibernate.model.AccentureEmployee;
import com.harsh.hibernate.model.EmployeeCred;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;


// 💎 There are few ways to retrive the data
// 💎 When you're retriving through EmpId so it's sure that only one Data will come, OH DUMB for that use Hibernate get() method only.


public class ReadingTheData {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    // 💎 retriving all Data
    public static void readingAllEmployeeFromDB() {
        Session session = null;
        try {
            session = factory.openSession();

            Query<AccentureEmployee> allEmployee = session.createQuery("FROM AccentureEmployee", AccentureEmployee.class);

            List<AccentureEmployee> allEmployeeList = allEmployee.list();

            for (AccentureEmployee emp: allEmployeeList) {
                System.out.println("Emp Id: " + emp.getEmpId() + " Employee Name: " + emp.getEmpName() + " EmployeeCity: " + emp.getCity() + " Salary: " + emp.getSalary());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

    }

    // 💎 Retriving all the employee who lives in Pune
    public static void readingSpecificDataFromDB() {
        Session session = null;
        try {
            session = factory.openSession();

            Query<AccentureEmployee> puneEmployees = session.createQuery("FROM AccentureEmployee WHERE city= :empcity", AccentureEmployee.class);
            puneEmployees.setParameter("empcity","pune");

            List<AccentureEmployee> employeeList = puneEmployees.list(); // Returns a list which is having Accenture Employee who belongs to Pune

            if (employeeList == null) {
                System.out.println("There's no employee from PUNE");
                return;
            }

            for (AccentureEmployee employee : employeeList) {
                System.out.println("Emp Id: " + employee.getEmpId() + " Employee Name: " + employee.getEmpName() + " Employee City: " + employee.getCity() + " Salary: " + employee.getSalary());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // 💎 Retriving all the employee who lives in Pune and having sal> 60000
    public static void readingSpecificDataWithMultipleConditionsFromDB() {
        Session session = null;
        try {
            session = factory.openSession();

            Query<AccentureEmployee> puneEmployees = session.createQuery("FROM AccentureEmployee WHERE city= :empcity AND salary > :empSalary", AccentureEmployee.class);
            puneEmployees.setParameter("empcity","pune");
            puneEmployees.setParameter("empSalary",60000);

            List<AccentureEmployee> employeeList = puneEmployees.list(); // Returns a list which is having Accenture Employee who belongs to Pune

            if (employeeList.isEmpty()) {
                System.out.println("There's no employee from PUNE");
                return;
            }

            for (AccentureEmployee employee : employeeList) {
                System.out.println("Emp Id: " + employee.getEmpId() + " Employee Name: " + employee.getEmpName() + " Employee City: " + employee.getCity() + " Salary: " + employee.getSalary());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // 💎 Retriving Single Data w/o PK
    public static void readSingleDataWithoutPrimaryKey() {
        Session session = null;
        try {
            session = factory.openSession();
            Query<AccentureEmployee> query = session.createQuery("FROM AccentureEmployee e WHERE e.empName = :employeeName", AccentureEmployee.class).setParameter("employeeName","Durgesh");

            AccentureEmployee emp = query.uniqueResult();

            System.out.println("Emp Id: " + emp.getEmpId() + " Employee Name: " + emp.getEmpName() + " EmployeeCity: " + emp.getCity() + " Salary: " + emp.getSalary());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }


    public static void main(String[] args) {
        readingAllEmployeeFromDB();
        /*
        ✅ Emp Id: 1 Employee Name: Durgesh EmployeeCity: Pune Salary: 50000
        ✅ Emp Id: 2 Employee Name: Telusko EmployeeCity: banglore Salary: 75000
        ✅ Emp Id: 3 Employee Name: Abdul Bari sir EmployeeCity: Delhi Salary: 95000
        ✅ Emp Id: 4 Employee Name: Amit Bhaiya EmployeeCity: Pune Salary: 65000
         */
        readingSpecificDataFromDB();
        /*
        ✅ Emp Id: 1 Employee Name: Durgesh Employee City: Pune Salary: 50000
        ✅ Emp Id: 4 Employee Name: Amit Bhaiya Employee City: Pune Salary: 65000
         */
        readingSpecificDataWithMultipleConditionsFromDB(); // ✅ Emp Id: 4 Employee Name: Amit Bhaiya Employee City: Pune Salary: 65000
        readSingleDataWithoutPrimaryKey(); // ✅ Emp Id: 1 Employee Name: Durgesh EmployeeCity: Pune Salary: 120000
    }
}
