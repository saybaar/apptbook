package edu.pdx.cs410J.lrs;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the command line parser, format checking,
 * and other tools in the {@link Project1} class.
 */
public class Project1Test {

    @Test
    public void flagsAndArgsSeparatedCorrectly() {
        String[] args = {"-print", "one", "two", "three"};
        List<String> arguments = Arrays.asList(args);
        List<String> flags = new ArrayList<>();
        List<String> opts = new ArrayList<>();
        Project1.parseArguments(arguments, flags, opts);
        assertThat(flags, CoreMatchers.hasItem("-print"));
        assertThat(opts, CoreMatchers.hasItems("one", "three"));
        assert(!opts.contains("-print"));
    }

    @Test
    public void optsGetsAllArgsWithNoFlags () {
        String[] args = {"zero", "one", "two", "three"};
        List<String> arguments = Arrays.asList(args);
        List<String> flags = new ArrayList<>();
        List<String> opts = new ArrayList<>();
        Project1.parseArguments(arguments, flags, opts);
        assertThat(flags.size(), equalTo(0));
        assertThat(opts.size(), equalTo(4));
        assertThat(opts, CoreMatchers.hasItems("zero", "three"));
    }

    @Test
    public void flagsGetsAllArgsWithNoOpts () {
        String[] args = {"-zero", "-one", "-two", "-three"};
        List<String> arguments = Arrays.asList(args);
        List<String> flags = new ArrayList<>();
        List<String> opts = new ArrayList<>();
        Project1.parseArguments(arguments, flags, opts);
        assertThat(flags.size(), equalTo(4));
        assertThat(opts.size(), equalTo(0));
        assertThat(flags, CoreMatchers.hasItems("-zero", "-three"));
    }
}
