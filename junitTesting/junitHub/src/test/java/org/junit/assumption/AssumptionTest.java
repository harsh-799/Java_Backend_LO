package org.junit.assumption;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionTest {
    // 🧾 Assumption is basically pre condition check before testing any functionality test in organized way, It Only run this test if a certain condition holds true.

    // PACKAGE: import static org.junit.jupiter.api.Assumptions.*;

    // ⚡ If the test doesn't pass the assume condN it doesn't fails the test cases like in assert() instead here it aborts the test. So the test here marked as skipped or ignore rather than Failed

    static Assumption as;
    static Assumption.Database db;

    @BeforeAll
    static void connectDB(){
        as = new Assumption();
        db = as.new Database();
    }

    @Test
    void addData(){
        assumeTrue(db.connectDB(),()->"DB is off");
        System.out.println("DB working fine");
        // SO here first we're adding checks (pre checks) through if DB Is on then only add the data.

    }

    @Test
    void addData1(){
        assumeTrue(db.disconnectDB(),()->"DB is OFF sar");
        System.out.println("DB working fine from 1");
        // So here too we're adding checks and here since DB is off next part of the test won't get executed,

        // 🖥️ OUTPUT: org.opentest4j.TestAbortedException: Assumption failed: DB is OFF sar
    }
}
