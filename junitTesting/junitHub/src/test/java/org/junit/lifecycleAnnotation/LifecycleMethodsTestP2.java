package org.junit.lifecycleAnnotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LifecycleMethodsTestP2 {

    LifecycleMethods lc;
    Database db;

    @Test
    void validUsername() {
        assertTrue(lc.validUsername("harsh_799"));
    }

    @Test
    void validPassword() {
        assertTrue(lc.validPassword("1243289$"));
    }

    @Test
    void confirmPassword() {
        assertTrue(lc.confirmPassword("1243289$","1243289$"));
    }

    // 🏞️ @beforeEach() {it tells that before every test the flowing stuffs will execute}

    // Like for this earlier we used to create obj manually everytime, but now we're using beforeEach which will perform the set of instruction defined inside the method inside @beforeEach notatted method.

    @BeforeEach  //
    void instanceCreation(){
        lc = new LifecycleMethods();
    }

    // 🏞️ @afterEach() {it tells that after every test this following stuffs will execute every time}

    // We might use it in closing resouce

    @BeforeEach
    void createDB(){
        db = new Database();
    }

    @Test
    void insertData(){
        assertAll(
                ()->assertTrue(db.turnOn(),()->"DB is already in USE"),
                ()->assertTrue(db.addData("Harsh"))
                );
    }

    @AfterEach
    void closeDB(){
        db.turnOff();
        db = null;
    }

    /*
    - DB is running at xyz port
    - Harshis added successfully..
    - DB is turning Off..
     */

}


