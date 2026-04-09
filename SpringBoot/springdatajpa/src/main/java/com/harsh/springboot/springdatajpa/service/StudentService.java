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

    @Transactional
    public void deleteByEmail(String email) {
        repo.deleteByStudentEmail(email);
    }
}

/*
🧠 WHY THIS HAPPENS

👉 Delete / Update operations in JPA require a transaction

Read (find) → no transaction needed
Write (update/delete) → transaction REQUIRED

🔍 YOUR CASE (When i was doing in SpringDataJpaApplication (SpringBoot first file)

You called:
repo.deleteByStudentEmail(...)

👉 But:

❌ No @Transactional
❌ Not inside Spring-managed method
❌ Probably calling from main() directly

🔥 ROOT CAUSE
No transaction started → EntityManager can't execute DELETE → Exception ❌

⚠️ IMPORTANT RULE
DELETE / UPDATE → ALWAYS NEED TRANSACTION
👉 Q: Why do we get “No EntityManager with transaction”?

👉 Answer:

Because update and delete operations require an active transaction, and if the method is not annotated with @Transactional or not called through a Spring-managed bean, the transaction is not created.

🧠 FINAL MEMORY
Read → No transaction
Write → Transaction REQUIRED

Now you must be wondering why we have not used transaction when we were using save()
✅ Yes, save() also requires a transaction
❗ But Spring Data JPA handles it automatically for you

🧠 WHY YOU DIDN’T SEE ERROR WITH save()

When you do:

repo.save(s);

👉 Spring internally wraps it like:

@Transactional (internally)
    ↓
save()

👉 So:

Transaction is automatically created ✅

⚠️ GOLD RULE
If YOU control method → use @Transactional
If Spring method → already handled (Like remember we have not used it in save() or deleteById() because internally Spring manages it, but once we use method whcih is controlled by US liek using custom property then We need to use @Transactional [Mostly in Update / delete]

 */
