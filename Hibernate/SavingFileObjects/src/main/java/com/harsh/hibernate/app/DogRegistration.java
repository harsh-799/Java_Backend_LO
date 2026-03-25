package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Dog;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DogRegistration {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void saveDogDetails() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Dog dog1 = new Dog();
            dog1.setDogName("Mogu");
            dog1.setImages(dogImageReaderFromStorage());

            session.persist(dog1);
            transaction.commit();
            System.out.println("Dog details has been successfully added to DB. ✅");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static byte[] dogImageReaderFromStorage() {
        File f = new File("src/main/resources/assets/screenshots/dogimage.jpg");
        byte [] dogImage = new byte[(int)f.length()];  // Make the storer array length same as file
        try (FileInputStream fis = new FileInputStream(f)) {
            // int bytesRead = fis.read(dogImage); // Read till the dogImage buffer gets fill since here buffer array size is same as image so no need to use loop because in one run it'll read memory till the size of the image. ❌ No that's misconception
            int offset = 0;
            int bytesRead;

            while ((bytesRead = fis.read(dogImage,offset, dogImage.length - offset)) != -1) {
                offset += bytesRead;
            }

            if (offset != dogImage.length) {
                System.out.println("File read incomplete");
                return null;
            }

        } catch (IOException e) {
            System.out.println("File doesn't exists");
        }

        return dogImage;
    }

    public static void main(String[] args) {
        saveDogDetails();
    }
}
