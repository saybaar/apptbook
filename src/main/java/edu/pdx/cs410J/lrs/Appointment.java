package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointment;

/**
 * Class for Appointment objects.
 */
public class Appointment extends AbstractAppointment {
  private String description;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;

  /**
   * Creates a new Appointment with the given string parameters.
   * @param description A description of the appointment
   * @param startDate Start date (MM/dd/yyyy)
   * @param startTime Start time (HH:mm)
   * @param endDate End date (MM/dd/yyyy)
     * @param endTime End time (HH:mm)
     */
  public Appointment(String description, String startDate, String startTime, String endDate, String endTime) {
    this.description = description;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
  }

  /**
   * Returns a string with the beginning date and time
   * @return string with the beginning date and time
     */
  @Override
  public String getBeginTimeString() {
    return startDate + " " + startTime;
  }

  /**
   * Returns a string with the ending date and time
   * @return string with the ending date and time
     */
  @Override
  public String getEndTimeString() {
    return endDate + " " + endTime;
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
