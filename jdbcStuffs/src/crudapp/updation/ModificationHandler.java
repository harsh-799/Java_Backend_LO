package crudapp.updation;

import myjdbcutil.SectionNameVerifier;

import java.util.Scanner;

public class ModificationHandler {

    public static final Scanner sc = new Scanner(System.in);

    public static void updateStudentDetails(){
        System.out.print("Enter section: ");
        String section = sc.next();

        if (!SectionNameVerifier.verify(section)) return;

        System.out.print("Enter roll No: ");
        int roll = sc.nextInt();

        System.out.println("Enter updated email: ");
        String updatedEmail = sc.next();

        UpdateData.updateStudentDetails(section,roll,updatedEmail);
    }

    public static void deleteSpecific(){
        System.out.print("Enter section: ");
        String section = sc.next();
        boolean validSectionName = section.chars().anyMatch(Character::isLetter) && section.chars().allMatch(c -> Character.isLetterOrDigit(c));
        if (validSectionName) {
            System.out.print("Enter roll No: ");
            int roll = sc.nextInt();
            UpdateData.deleteSpecificStudent(section,roll);
        } else {
            System.out.println("Enter valid Section Name");
        }
    }
}
