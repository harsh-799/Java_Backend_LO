package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertingData {
    public static void main(String[] args) {

        // Step 1️⃣: Make an entity (✅ Done already)

        // Step 2️⃣: Setup Config Files (✅ Done already)

        // Step 3️⃣: Create Config Object and Load the configuration
        Configuration config = new Configuration();
        config.configure(); // Loads the hibernate.cfg.xml if diff name mention Here ("diff Name")

        // Step 4️⃣: Create Session Factory
        SessionFactory factory = config.buildSessionFactory();

        // Step 5️⃣: Get Session from session factory
        Session session = factory.openSession();

        // Step 6️⃣: (Based on operation, Use transaction, Since We need to insert we'll do it)
        Transaction transaction = session.beginTransaction();

        // STep 7️⃣: Perform operation
        Student student = new Student();
        student.setsId(1);
        student.setsName("Harsh");
        student.setsCity("Gaya Ji");

        session.save(student); // 💥 Depreceated

        Student student1 = new Student();
        student1.setsId(2);
        student1.setsName("Varun");
        student1.setsCity("Sasaram");

        session.save(student1); // 💥 Depreceated

        // Step 8️⃣: Commit/ Rollback
        transaction.commit();

        // Step 9️⃣: Close the session
        session.close();

    }
}
