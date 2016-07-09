package edu.pdx.cs410J.lrs;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
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
        assertThat(opts, CoreMatchers.not(CoreMatchers.hasItem("-print")));
        assertThat(opts.get(0), equalTo("one"));
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

    @Test
    public void ValidDateIsValid() {
        assertThat(Project1.isValidDate("01/02/3456"), equalTo(true));
        assertThat(Project1.isValidDate("5/6/0123"), equalTo(true));
        assertThat(Project1.isValidDate("12/25/1994"), equalTo(true));
    }

    @Test
    public void Month13IsInvalid() {
        assertThat(Project1.isValidDate("13/02/3456"), equalTo(false));
    }

    @Test
    public void Day0IsInvalid() {
        assertThat(Project1.isValidDate("01/00/3456"), equalTo(false));
    }

    @Test
    public void Day34IsInvalid() {
        assertThat(Project1.isValidDate("01/34/3456"), equalTo(false));
    }

    @Test
    public void WrongDelimiterIsInvalid() {
        assertThat(Project1.isValidDate("01.02.3456"), equalTo(false));
    }

    @Test
    public void ValidTimeIsValid() {
        assertThat(Project1.isValidTime("16:34"), equalTo(true));
    }

    @Test
    public void AnotherValidTimeIsValid() {
        assertThat(Project1.isValidTime("5:43"), equalTo(true));
    }

    @Test
    public void MidnightIsValid() {
        assertThat(Project1.isValidTime("00:00"), equalTo(true));
    }

    @Test
    public void OneDigitHourIsValid() {
        assertThat(Project1.isValidTime("1:23"), equalTo(true));
    }

    @Test
    public void Hour24IsInvalid() {
        assertThat(Project1.isValidTime("24:00"), equalTo(false));
    }

    @Test
    public void MissingDelimiterIsInvalid() {
        assertThat(Project1.isValidTime("2234"), equalTo(false));
    }

    @Test
    public void MissingMinutesIsInvalid() {
        assertThat(Project1.isValidTime("22:"), equalTo(false));
    }

    @Ignore
    @Test
    public void OneDigitMinutesIsInvalid() {
        assertThat(Project1.isValidTime("22:6"), equalTo(false));
    }
}
