package com.harsh.hibernate.app;

import com.harsh.hibernate.model.Dog;
import com.harsh.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class DogDataRetrival {

    public static void getDogDetails() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            Dog dog = session.get(Dog.class, 1);

            if (dog == null) {
                System.out.println("Dog not found");
                return;
            }

            byte [] currentDogPfp = dog.getImages();
            if (!saveDogImageToLocalStorage(currentDogPfp)) {
                System.out.println("There's some issue in reading the image from DB");
                return;
            }

            System.out.println("Image successfully saved to Local Storage. ✅");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    public static boolean saveDogImageToLocalStorage(byte[] dogImageFromDB) {
        if (dogImageFromDB == null) {
            System.out.println("No image found in DB");
            return false;
        }

        try (FileOutputStream fos = new FileOutputStream("src/main/resources/assets/screenshots/dogFromDb.jpg")) {
            fos.write(dogImageFromDB);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        getDogDetails();
    }
}
