package org.junit.lifecycleAnnotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifecycleMethodsTest {

    // 🚧 OLD WAY (Everytime we would need to declare something which we want for every test)
    @Test
    void validUsername() {
        LifecycleMethods lc = new LifecycleMethods();
        assertTrue(lc.validUsername("harsh_799"));
    }

    @Test
    void validPassword() {
        LifecycleMethods lc = new LifecycleMethods();
        assertTrue(lc.validPassword("1243289$"));
    }

    @Test
    void confirmPassword() {
        LifecycleMethods lc = new LifecycleMethods();
        assertTrue(lc.confirmPassword("1243289$","1243289$"));
    }

    /* 👀 Now lifecycle gave us few annotation which makes our work easier.*/

    // Switch to Part 2
}