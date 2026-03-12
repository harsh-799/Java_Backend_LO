package org.junit.others;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTest {

    @Test
    void auth(){
        System.out.println("Okay you're");
    }

    // Now since these belongs to same Test we can group together Using @Nested Annotation.
    // @Test
    // void divide() {
    // }
    //
    // @Test
    // void testDivide() {
    // }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class DivisonTest {

        static Division d;

        @BeforeAll
        static void objectCreation(){
            d = new Division();
        }

        @Test
        @DisplayName("Int way")
        void divide() {
            assertEquals(5,d.divide(10,2));
        }

        @Test
        @DisplayName("Float way")
        void testDivide() {
            assertEquals(2.0,d.divide(10.0f,5.0f)); // Remember: Kavya mam concept by default . means to be double until we explictly write f, to make it float.
        }
    }

}
