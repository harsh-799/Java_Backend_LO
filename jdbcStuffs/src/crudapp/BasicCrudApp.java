package crudapp;

import crudapp.deletion.DeletionHandler;
import crudapp.insertion.InsertionHandler;
import crudapp.selection.ShowingData;
import crudapp.updation.ModificationHandler;

import java.util.Scanner;

public class BasicCrudApp {

    public static final Scanner sc = new Scanner(System.in);

    public static void controller(int choice){
        switch (choice){
            case 1:
                ShowingData.showAllDataOfSchool();
                break;

            case 2:
                System.out.println("Show Specific Section Data: ");
                String sectionName = sc.next();
                ShowingData.showAllDataOfSection(sectionName);
                break;

            case 3:
                System.out.println("Choose from below");
                System.out.println("1. Insert New Section");
                System.out.println("2. Insert New Student");
                System.out.println("Enter your choice: ");

                int insertionChoice = sc.nextInt();
                if (insertionChoice == 1 || insertionChoice == 2){
                    InsertionHandler handler = new InsertionHandler(insertionChoice);
                }else {
                System.out.println("Invalid ");
                }
                break;

            case 4:
                ModificationHandler.updateStudentDetails();
                break;

            case 5:
                ModificationHandler.deleteSpecific();
                break;

            case 6:
                DeletionHandler.deleteRecordsOFSection();
                break;

            case 7:
                DeletionHandler.deleteSection();
                break;

        }


    }

    public static void dashboard(){

        System.out.println("1. Show All Data");
        System.out.println("2. Show All Data of Specific Section");
        System.out.println("3. Insert New data");
        System.out.println("4. Update Specific Data");
        System.out.println("5. Delete Specific Data");
        System.out.println("6. Delete Entire table Data");
        System.out.println("7. Delete Entire table");
        System.out.println("8. Exit");

        System.out.println("Enter the choice: ");

    }
    public static void main(String[] args) {
        int choice;
        while (true){
            dashboard();
            choice = sc.nextInt();
            if (choice == 8) break;
            controller(choice);
        }
        System.out.println("Exiting, Good Bye.");
    }
}
