package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Integration tests for the {@link Project3} main class.
 */
public class Project3IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project3} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project3.class, args );
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testNoCommandLineArguments() {
        MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getErr(), containsString("Wrong number of options"));
    }

    @Test
    public void testExpectedCommandLineArguments() {
        MainMethodResult result = invokeMain("-print", "Caesar", "conquering", "01/02/3456", "12:34", "9/8/7654", "3:21");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getOut(), containsString("conquering from"));
    }

    @Test
    public void testWithoutPrint() {
        MainMethodResult result = invokeMain("Caesar", "conquering", "01/02/3456", "12:34", "9/8/7654", "3:21");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getOut(), equalTo(""));
    }

    @Test
    public void testTooFewCommandLineArguments() {
        MainMethodResult result = invokeMain("Caesar", "conquering", "12:34", "9/8/7654", "3:21");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getErr(), containsString("Wrong number of options"));
    }

    @Test
    public void testBadDateFormat() {
        MainMethodResult result = invokeMain("Caesar", "conquering", "1/2/3456", "12:34", "9/80/7654", "3:21");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getErr(), containsString("Invalid date/time format"));
    }

    @Test
    public void testFileFlagWithoutPath() {
        MainMethodResult result = invokeMain("-file");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getErr(), containsString("requires a value"));
    }
}