package org.junit.others;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestss {

    static Division d;

    @BeforeAll
    static void objCreation(){
        d = new Division();
    }

    @RepeatedTest(5)
    void testingDivisible(RepetitionInfo repetitionInfo){
        System.out.println("this test will execite for 5 times");

        int currentRepeatition = repetitionInfo.getCurrentRepetition();
        switch (currentRepeatition){
            case 1:
                assertEquals(10,d.divide(20,2));
                break;

            case 2:
                assertEquals(20,d.divide(100,5));
                break;

            case 3:
                assertEquals(2,d.divide(4,2));
                break;

            case 4:
                assertEquals(1,d.divide(2,2));
                break;

            case 5:
                assertEquals(16,d.divide(4,4));
                break;
        }
    }
}
