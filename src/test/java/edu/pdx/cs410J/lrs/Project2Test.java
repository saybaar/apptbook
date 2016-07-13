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
 * and other tools in the {@link Project2} and {@link ApptBookUtilities} classes.
 */
public class Project2Test {

    @Test
    public void ValidDateIsValid() {
        assertThat(ApptBookUtilities.isValidDateTime("01/02/3456 12:34"), equalTo(true));
        assertThat(ApptBookUtilities.isValidDateTime("5/6/0123 01:23"), equalTo(true));
        assertThat(ApptBookUtilities.isValidDateTime("12/25/1994 5:15"), equalTo(true));
    }

    @Test
    public void Month13IsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("13/02/3456 1:00"), equalTo(false));
    }

    @Test
    public void Day0IsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("01/00/3456 1:00"), equalTo(false));
    }

    @Test
    public void Day34IsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("01/34/3456 12:12"), equalTo(false));
    }

    @Test
    public void WrongDelimiterIsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("01.02.3456 12.12"), equalTo(false));
    }

    @Test
    public void ValidTimeIsValid() {
        assertThat(ApptBookUtilities.isValidDateTime("12/21/1221 16:34"), equalTo(true));
    }

    @Test
    public void LettersAreInvalidInDateTime() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/abcd 5:43"), equalTo(false));
    }

    @Test
    public void MidnightIsValid() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/1111 00:00"), equalTo(true));
    }

    @Test
    public void OneDigitHourIsValid() {
        assertThat(ApptBookUtilities.isValidDateTime("2/3/4 1:23"), equalTo(true));
    }

    @Test
    public void Hour24IsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/1111 24:00"), equalTo(false));
    }

    @Test
    public void MissingDelimiterIsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("12/4/1000 2234"), equalTo(false));
    }

    @Test
    public void MissingMinutesIsInvalid() {
        assertThat(ApptBookUtilities.isValidDateTime("12/21/1221 22:"), equalTo(false));
    }


    @Test
    public void DateTimeFixesSlashIssue() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/1111/1 22:22"), equalTo(false));
    }

    @Ignore
    @Test
    public void DateTimeFixesMinutesIssue() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/1111 22:2"), equalTo(false));
    }

    @Ignore
    @Test
    public void DateTimeWithExtraColons() {
        assertThat(ApptBookUtilities.isValidDateTime("11/11/1111 22:22:22"), equalTo(false));
    }

}