package myjdbcutil;

public class SectionNameVerifier {
    public static boolean verify(String sectionName){
        boolean validSectionName = sectionName.chars().anyMatch(Character::isLetter) && sectionName.chars().allMatch(c -> Character.isLetterOrDigit(c));

        if (validSectionName) return true;
        System.out.println("Invalid section Name");
        return false;

    }
}
