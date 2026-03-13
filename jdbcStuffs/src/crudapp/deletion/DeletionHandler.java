package crudapp.deletion;

import java.util.Scanner;

public class DeletionHandler {

    public static final Scanner sc = new Scanner(System.in);

    public static void deleteRecordsOFSection(){
        System.out.print("Enter section: ");
        String section = sc.next();
        DeleteData.deleteRecords(section);
    }

    public static void deleteSection(){
        System.out.print("Enter section: ");
        String section = sc.next();
        DeleteData.deleteTheSection(section);
    }

    public static void main(String[] args) {
        DeletionHandler.deleteRecordsOFSection();
        DeletionHandler.deleteSection();
    }


}
