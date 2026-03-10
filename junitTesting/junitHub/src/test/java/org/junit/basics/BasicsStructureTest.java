package org.junit.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicsStructureTest { // 📢 Also It's naming convention that, Test class will have same name of class with the Test word added in the last

    @Test // 💡 We must add @TestAnnotation to let platform know that this method is part of unit Testing
    void methodToTest() {
        System.out.println("Passed"); // ⚠️ NOTE: By default every Test is passed so we need to explictly write the edge Cases on which our Defined logic in BasicsStructure will fail.
    }

    void methodGoingToBeSkipped(){
        System.out.println("Passed?"); // This test will be skipped since we haven't written @Test annotation.
    }
}