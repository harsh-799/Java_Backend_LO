package org.junit.lifecycleAnnotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifecycleMethodsTestP2 {

    LifecycleMethods lc;

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
    @Test
    @BeforeEach  //
    void instanceCreation(){
        lc = new LifecycleMethods();
    }
}