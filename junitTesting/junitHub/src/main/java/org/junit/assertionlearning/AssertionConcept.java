package org.junit.assertionlearning;

public class AssertionConcept {
    public int reverseNumber(int number){
        int revNumber = 0;
        while (number > 0){
            int lastDigit = number % 10;
            revNumber = revNumber * 10 + lastDigit;
            number /= 10;
        }

        return revNumber;
    }

    public boolean isPalindrome(String inputData){
        int stP = 0;
        int endP = inputData.length()-1;

        inputData = inputData.toLowerCase();

        while (stP < endP){
            if (inputData.charAt(stP) == inputData.charAt(endP)){
                stP++;
                endP--;
            } else {
                return false;
            }
        }
        return true;
    }

    public String nullChecker(int choice){
        switch (choice){
            case 1:
                return null;

            case 2:
                return "NonNullString";

            default:
                return null;
        }
    }

    public int divider(int divident, int divisor) throws ArithmeticException{
        return divident / divisor;
    }

    public int[] arrayChecker (){
        return new int[]{1,2,3};
    }

    public boolean validUsernameLength(String username){
        return username.length() > 6;
    }

    public boolean validUsernameSpecial(String username){
        return username.contains("_") || username.contains("-");
    }

    public void performanceTester() throws InterruptedException {
        Thread.sleep(5000);
    }

}
