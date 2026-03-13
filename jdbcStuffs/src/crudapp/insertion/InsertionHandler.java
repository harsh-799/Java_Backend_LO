package crudapp.insertion;

import crudapp.insertion.InsertData;
import myjdbcutil.SectionNameVerifier;

import java.util.Scanner;

public class InsertionHandler {
    int choice;
    public static final Scanner sc = new Scanner(System.in);

    public InsertionHandler(int choice) {
        this.choice = choice;
        if (choice == 1) addNewSection();
        else addNewStudent();
    }

    public static void addNewSection(){
        System.out.println("Enter Section Name: ");
        String sectionName = sc.next();
        if (!SectionNameVerifier.verify(sectionName)) return;
        InsertData.insertNewSection(sectionName);
    }

    public static void addNewStudent(){
        System.out.print("Enter roll: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.next();
        System.out.print("Enter Section: ");
        String sectionName = sc.next();

        if (!SectionNameVerifier.verify(sectionName)) return;

        InsertData.insertNewStudent(rollNo,name,email,sectionName);
    }
}
