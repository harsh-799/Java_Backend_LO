package org.junit.assumption;

public class Assumption {
    class Database {
        boolean connectDB(){
            return true;
        }

        boolean disconnectDB(){
            return false;
        }
    }
}
