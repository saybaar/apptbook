package edu.pdx.cs410J.lrs;

import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the command line parser, format checking,
 * and other tools in the {@link Project3} and {@link ApptBookUtilities} classes.
 */
public class Project3Test {
/*
    @Test
    public void ValidDateIsValid() {
        assertThat(ApptBookUtilities.parseDateTime("01/02/3456 12:34"), equalTo(true));
        assertThat(ApptBookUtilities.parseDateTime("5/6/0123 01:23"), equalTo(true));
        assertThat(ApptBookUtilities.parseDateTime("12/25/1994 5:15"), equalTo(true));
    }

    @Test
    public void Month13IsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("13/02/3456 1:00"), equalTo(false));
    }

    @Test
    public void Day0IsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("01/00/3456 1:00"), equalTo(false));
    }

    @Test
    public void Day34IsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("01/34/3456 12:12"), equalTo(false));
    }

    @Test
    public void WrongDelimiterIsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("01.02.3456 12.12"), equalTo(false));
    }

    @Test
    public void ValidTimeIsValid() {
        assertThat(ApptBookUtilities.parseDateTime("12/21/1221 16:34"), equalTo(true));
    }

    @Test
    public void LettersAreInvalidInDateTime() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/abcd 5:43"), equalTo(false));
    }

    @Test
    public void MidnightIsValid() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/1111 00:00"), equalTo(true));
    }

    @Test
    public void OneDigitHourIsValid() {
        assertThat(ApptBookUtilities.parseDateTime("2/3/4 1:23"), equalTo(true));
    }

    @Test
    public void Hour24IsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/1111 24:00"), equalTo(false));
    }

    @Test
    public void MissingDelimiterIsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("12/4/1000 2234"), equalTo(false));
    }

    @Test
    public void MissingMinutesIsInvalid() {
        assertThat(ApptBookUtilities.parseDateTime("12/21/1221 22:"), equalTo(false));
    }


    @Test
    public void DateTimeFixesSlashIssue() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/1111/1 22:22"), equalTo(false));
    }

    @Ignore
    @Test
    public void DateTimeFixesMinutesIssue() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/1111 22:2"), equalTo(false));
    }

    @Ignore
    @Test
    public void DateTimeWithExtraColons() {
        assertThat(ApptBookUtilities.parseDateTime("11/11/1111 22:22:22"), equalTo(false));
    }
*/

    @Test
    public void AMPMDatesParsedCorrectly() {
        try {
            assertThat(ApptBookUtilities.parseDateTime("11/11/1111 02:22 PM").toString(), containsString("Sat Nov 11 14:22"));
        } catch (ParseException e) {
            System.err.println("Parse exception in test");
            assert(false);
        }
    }
}