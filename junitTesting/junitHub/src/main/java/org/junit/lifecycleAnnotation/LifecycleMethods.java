package org.junit.lifecycleAnnotation;

class Database{

    boolean isRunning = false;

    public boolean turnOn(){
        System.out.println("DB is running at xyz port");
        if (!isRunning) {
            isRunning = true;
            return true;
        }
        return false;
    }

    public boolean turnOff(){
        if (isRunning) {
            System.out.println("DB is turning Off..");
            return true;
        }
        return false;
    }

    public boolean addData(String data){
        if (isRunning){
            System.out.println(data + "is added successfully..");
            return true;
        }
        return false;
    }
}

public class LifecycleMethods {

    // For BeforeEach
    public boolean validUsername(String username) {
        return username.length() > 6 && username.length() < 15 && username.contains("_");
    }

    public boolean validPassword(String password) {
        return password.length() > 6 && password.length() < 15 && password.contains("$");
    }

    public boolean confirmPassword(String oldPassword, String password) {
        return oldPassword == password;
    }
}
