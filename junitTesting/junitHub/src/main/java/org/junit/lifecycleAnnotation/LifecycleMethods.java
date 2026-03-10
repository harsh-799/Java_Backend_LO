package org.junit.lifecycleAnnotation;

public class LifecycleMethods {

    // For BeforeEach
    public boolean validUsername(String username){
        return username.length() > 6 && username.length() < 15 && username.contains("_");
    }

    public boolean validPassword(String password){
        return password.length() > 6 && password.length() < 15 && password.contains("$");
    }

    public boolean confirmPassword(String oldPassword,String password){
        return oldPassword == password;
    }
}
