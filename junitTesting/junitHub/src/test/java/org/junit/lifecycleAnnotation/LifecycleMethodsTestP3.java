package org.junit.lifecycleAnnotation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// @TestInstance(TestInstance.Lifecycle.PER_METHOD) // Using this, Instance of the class will be created for every method so see no need of @BeforeEach in this case too.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Using this, Instance of class will be created only one Time.
public class LifecycleMethodsTestP3 {

    public LifecycleMethodsTestP3() {
        System.out.println("Object created..");
    }

    /*
    - Before diving into @beforeAll and @afterAll the working of the Test class must be clear.
    - suppose we're in this class LifecycleMethodsTestP3 RN now don't you have think we're not creating object so how all the test methods are getting invoked?
    - Reason is: As soon as the compiler sees anything with @Test annotation it creates object and run that method. See below for understanding:
     */

    @Test
    void checkingObjCreation(){
        System.out.println("Test ran successfully.");
    }

    @Test
    void checkingObjCreation1(){
        System.out.println("Test ran successfully.");
    }

    /*
    Object created..
    Test ran successfully.
    Object created..
    Test ran successfully.
    VERIFIED SUCCESSFULLY.
     */

    //  🧠 Now don't you think we're creating this class unnecessarily everytime, so for that we have two ways:
    // Way01: BeforeAll
    // Way02: Test instance

    static LifecycleMethodsTestP3 testObj;

    // @BeforeAll
    // public objCreation(){
    //     testObj = new LifecycleMethodsTestP3();
    // }

    // Now your thinking should be it's okay that beforeAll we're creating testObj but have u think how this method will be called objCreation()?
    // SO that's the reason for @beforeAll it should be static at that time current class obj is not created so it's not at all possible to call the non static method.
    // And you know very well for the Test cases method as soon as it sees @Test annotation it creates obj and execute that test case method.

    @BeforeAll
    public static void objCreation(){
        testObj = new LifecycleMethodsTestP3();
    }

    // Object created.. (This one is generated through the @BeforeAll annotation.
    // Object created..
    // Test ran successfully.
    // Object created..
    // Test ran successfully.

    @AfterAll
    public static void closingApp(){
        System.out.println("CLosing the app..");
    }

    /*
    Object created..
    Object created..
    Test ran successfully.
    Object created..
    Test ran successfully.
    CLosing the app..
     */
}
