package edu.pdx.cs410J.lrs;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link Appointment} class.
 */
public class AppointmentTest {

  Appointment defaultAppt = new Appointment("conquering", "01/02/3456 12:34", "9/8/7654 3:21");

  @Test
  public void appointmentToString() {
    assertThat(defaultAppt.toString(), containsString("conquering"));
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
