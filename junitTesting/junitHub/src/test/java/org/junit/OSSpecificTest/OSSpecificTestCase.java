package org.junit.OSSpecificTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OSSpecificTestCase {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void installDiffOS(){
        // We're making this Test cases to just execute on Windows OS since we can't install diff OS on mac's
        System.out.println("Test case running on windows..");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void glassBlurEffect(){
        System.out.println("Test case running on Mac OS");
    }

    /* OUTPUT
    Test case running on windows..
    Disabled on operating system: Windows 11
     */

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX}) // For grouping DIff OS
    public void chnageKernelVersion(){
        System.out.println("Kernel Version is getting chnaged on "+OS.current());
    }

    // OUTPUT: Kernel Version is getting chnaged on WINDOWS
}
