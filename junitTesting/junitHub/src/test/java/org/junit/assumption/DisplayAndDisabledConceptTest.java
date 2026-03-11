package org.junit.assumption;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayAndDisabledConceptTest {

    @Test
    @DisplayName("Testing Method") // 🔑 This name will be shown when we
    void methodWillBeTested() {
        System.out.println("Method is testing");
    }

    @Test
    void withoutName(){
        System.out.println("Method is testing");
    }

    @Test
    @Disabled
    void uiChanger() {
    }
}