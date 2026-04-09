package com.harsh.springboot.springdatajpa.service;

import com.harsh.springboot.springdatajpa.model.Student;
import com.harsh.springboot.springdatajpa.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
🔥 KEY RULE (VERY IMPORTANT)
@Transactional works ONLY when:
✔ Method is inside Spring Bean (@Service)
✔ Called through Spring proxy

⚠️ WHY STATIC BREAKS IT

👉 Spring uses proxy mechanism (AOP)

👉 Static methods:

❌ Not proxied
❌ Not intercepted
❌ No transaction
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    @Transactional
    public void updateStudent(int id) {

        Optional<Student> res = repo.findById(id);

        if (res.isPresent()) {
            Student s = res.get();
            s.setStudentName("Priya Rajput");
            System.out.println("Data Saved !");
            System.out.println(s.getStudentName());
            System.out.println("From DB: " + repo.findById(4).get().getStudentName());
            return;
        }

        System.out.println("Id not found");
    }
}
