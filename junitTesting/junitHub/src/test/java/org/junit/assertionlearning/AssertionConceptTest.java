package org.junit.assertionlearning;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class AssertionConceptTest {

    // 💾 Package: import static org.junit.jupiter.api.Assertions.

    @Test
    void reverseNumber() {
        AssertionConcept ac = new AssertionConcept();
        int expected = 543;
        int actual = ac.reverseNumber(345);

        // 🛠️ assertEquals(expected, actual)
        assertEquals(expected,actual);
        assertEquals(321,ac.reverseNumber(123),"Failed due to wrong input");

        // 🛠️ assertNotEquals (expected, result)
        assertNotEquals(5671, ac.reverseNumber(123),"Failed due to wrong input");

        // 📝 Concept for giving message:

        // 🧪 When we use "" in the assertMethods() to show the failed case message, it's a bad way of doing as even if the test case didn't fail means it's passed then for them also the string object will be created but it'll not show since our tc is passed.

        // 🧪 Recommended way is to use () -> "error msg", now this will only execute when the tc is failed so string object will only be created when tc is getting failed.
    }

    @Test
    void isPalindrome() {
        // 🛠️ assertTrue (returning true/false) {Passes only when the returining value coming inside () is true.
        AssertionConcept ac = new AssertionConcept();
        assertTrue(ac.isPalindrome("Madam")); // ✅ Passes

        // 🛠️ assertFalse (returning true/false) {Passes only when the returining value coming inside () is true.
        assertFalse(ac.isPalindrome("harsh")); // ✅ Passes
        assertFalse(ac.isPalindrome("Madam")); // 🚫 Fails
    }

    @Test
    void nullChecker() {
        // 🛠️ assertNull (Pass the thing whose null/ not null state needs to be checked)
        assertNull(new AssertionConcept().nullChecker(1)); // ✅ Passes
        // assertNull(new AssertionConcept().nullChecker(2)); // 🚫 Fails

        // 🛠️ assertNotNull (Pass the thing which is returning non Null)
        assertNotNull(new AssertionConcept().nullChecker(2)); // ✅ Passes
        assertNotNull(new AssertionConcept().nullChecker(1)); // 🚫 Fails
    }


    @Test
    void divider() {
        // 🛠️ assertThrows (Exception class Name, () -> {Pass the case in which the stuffs inside this must throws exeptions})
        AssertionConcept ac = new AssertionConcept();
        assertThrows(ArithmeticException.class,() -> ac.divider(10,0));// ✅ Passes

        // assertThrows(ArithmeticException.class,() -> ac.divider(10,2));// 🚫 Fails (As expection is not thrown)
    }


    @Test
    void arrayChecker() {
        AssertionConcept ac = new AssertionConcept();

        // 🛠️ assertArrayEquals(expected, actual) {Pass the array}
        assertArrayEquals(new int[]{1,2,3},ac.arrayChecker()); // ✅ Passes
        // assertArrayEquals(new int[]{1,2,3,4},ac.arrayChecker()); // 🚫 Fails
    }

    @Test
    void usernameValidator(){
        AssertionConcept ac = new AssertionConcept();
        String username = "harsh_799";
        // 🛠️ assertAll((),()) {We can run multiple asserts at once).
        assertAll(
                ()->assertTrue(ac.validUsernameLength(username)),
                ()->assertTrue(ac.validUsernameSpecial(username))
        ); // ✅ Passes
    }

    @Test
    void performanceTester() {
        AssertionConcept ac = new AssertionConcept();
        // 🛠️ assertTimeout(Duration d, () -> {which needs to be test}) [Pass only when the thing which needs to be test should be execute within the given duration.] [Used to check the performance or unit test execution time]

        // assertTimeout(Duration.of(4,ChronoUnit.SECONDS),() -> ac.performanceTester()); // 🚫 Fails (As it needs to be execute in 4 sec but it's executing in 7 sec]
        assertTimeout(Duration.of(6,ChronoUnit.SECONDS),() -> ac.performanceTester()); // ✅ Passes
    }
}