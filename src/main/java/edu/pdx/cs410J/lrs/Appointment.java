package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointment;

/**
 * Class for Appointment objects.
 */
public class Appointment extends AbstractAppointment {
  private String description;
  private String startDateTime;
  private String endDateTime;

  /**
   * Creates a new Appointment with the given string parameters.
   * @param description A description of the appointment
   * @param startDateTime Start date/time (MM/dd/yyyy HH:mm)
   * @param endDateTime End date/time
     */
  public Appointment(String description, String startDateTime, String endDateTime) {
    this.description = description;
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
  }

  /**
   * Returns a string with the beginning date and time
   * @return string with the beginning date and time
     */
  @Override
  public String getBeginTimeString() {
    return startDateTime;
  }

  /**
   * Returns a string with the ending date and time
   * @return string with the ending date and time
     */
  @Override
  public String getEndTimeString() {
    return endDateTime;
  }

  /**
   * Returns the appointment's description
   * @return the appointment's description
     */
  @Override
  public String getDescription() {
    return description;
  }
}
