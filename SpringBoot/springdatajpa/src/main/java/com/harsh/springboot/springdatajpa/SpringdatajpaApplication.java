package com.harsh.springboot.springdatajpa;

import com.harsh.springboot.springdatajpa.model.Student;
import com.harsh.springboot.springdatajpa.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringdatajpaApplication.class, args);
        StudentRepo repo = context.getBean(StudentRepo.class);

        // 🔆 For Saving the data into DB
        saveData(context,repo);





    }

}
