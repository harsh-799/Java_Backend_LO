package com.harsh.springboot.springdatajpa;

import com.harsh.springboot.springdatajpa.model.Student;
import com.harsh.springboot.springdatajpa.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication {

    public static void saveData(ApplicationContext context, StudentRepo repo) {
        Student s1 = context.getBean(Student.class);
        s1.setStudentName("Harsh Anand");
        s1.setStudentEmail("harshxyz@gmail.com");
        s1.setStudentMobileNumber(9876543210L);

        Student s2 = context.getBean(Student.class);
        s2.setStudentName("Ananya Sharma");
        s2.setStudentEmail("ananya.sharma@gmail.com");
        s2.setStudentMobileNumber(9123456780L);

        Student s3 = context.getBean(Student.class);
        s3.setStudentName("Rohit Verma");
        s3.setStudentEmail("rohit.verma@yahoo.com");
        s3.setStudentMobileNumber(9988776655L);

        Student s4 = context.getBean(Student.class);
        s4.setStudentName("Priya Singh");
        s4.setStudentEmail("priya.singh@outlook.com");
        s4.setStudentMobileNumber(9090909090L);

        Student s5 = context.getBean(Student.class);
        s5.setStudentName("Aman Gupta");
        s5.setStudentEmail("aman.gupta@gmail.com");
        s5.setStudentMobileNumber(9191919191L);

        // 📝 For saving the object/data into DB
        repo.save(s1);
        repo.save(s2);
        repo.save(s3);
        repo.save(s4);
        repo.save(s5);

    }

    public static void getDataAll(ApplicationContext context, StudentRepo repo) {
        List<Student> allStudents = repo.findAll();

        System.out.println(allStudents); // ✅ [Student{studentId=1, studentName='Harsh Anand', studentEmail='harshxyz@gmail.com', studentMobileNumber=9876543210}, Student{studentId=2, studentName='Ananya Sharma', studentEmail='ananya.sharma@gmail.com', studentMobileNumber=9123456780}, Student{studentId=3, studentName='Rohit Verma', studentEmail='rohit.verma@yahoo.com', studentMobileNumber=9988776655}, Student{studentId=4, studentName='Priya Singh', studentEmail='priya.singh@outlook.com', studentMobileNumber=9090909090}, Student{studentId=5, studentName='Aman Gupta', studentEmail='aman.gupta@gmail.com', studentMobileNumber=9191919191}]
    }

    private static void getDataId(ApplicationContext context, StudentRepo repo) {
        Optional<Student> studResult = repo.findById(30);

        if (studResult.isPresent()) System.out.println(studResult);
        else System.out.println("No Student found");

        // When id is 30
        // No Student found

        // WHen id is 3
        // ✅ Optional[Student{studentId=3, studentName='Rohit Verma', studentEmail='rohit.verma@yahoo.com', studentMobileNumber=9988776655}]
        // 2026
    }

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringdatajpaApplication.class, args);
        StudentRepo repo = context.getBean(StudentRepo.class);

        // 🔆 For Saving the data into DB
        // saveData(context,repo);

        // 🔆 For Retriving the data
        // getDataAll(context,repo);

        // 🔆 For Retriving of Specific Data using (PK)
        // getDataId(context,repo);
    }

}
