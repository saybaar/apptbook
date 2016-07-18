package edu.pdx.cs410J.lrs;

import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link Appointment} class.
 */
public class AppointmentTest {
  Appointment getDefaultAppt() {
    Date start = null, end = null;
    try {
      start = ApptBookUtilities.parseDateTime("01/02/3456 12:34");
      end = ApptBookUtilities.parseDateTime("9/8/7654 3:21");
    } catch (ParseException e) {    }
    return new Appointment("conquering", start, end);
  }

  @Test
  public void appointmentToString() {
    assertThat(getDefaultAppt().toString(), containsString("conquering"));
  }

  @Test
  public void dateTest() {
    assertThat(getDefaultAppt().getBeginTimeString(), containsString("12:34"));
  }

  @Ignore
  @Test(expected = UnsupportedOperationException.class)
  public void getBeginTimeStringNeedsToBeImplemented() {
    //Appointment appointment = new Appointment();
    //appointment.getBeginTimeString();
  }

  @Ignore
  @Test
  public void initiallyAllAppointmentsHaveTheSameDescription() {
    //Appointment appointment = new Appointment();
    //assertThat(appointment.getDescription(), containsString("not implemented"));
  }

  @Ignore
  @Test
  public void forProject1ItIsOkayIfGetBeginTimeReturnsNull() {
    //Appointment appointment = new Appointment();
    //assertThat(appointment.getBeginTime(), is(nullValue()));
  }
}
