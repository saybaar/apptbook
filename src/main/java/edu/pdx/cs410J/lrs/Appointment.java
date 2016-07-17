package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointment;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Class for Appointment objects.
 */
public class Appointment extends AbstractAppointment implements Comparable<Appointment> {
  private String description;
  private Date startDateTime;
  private Date endDateTime;

  /**
   * Creates a new Appointment with the given string parameters.
   * @param description A description of the appointment
   * @param startDateTime Start date/time (MM/dd/yyyy HH:mm)
   * @param endDateTime End date/time
     */
  public Appointment(String description, Date startDateTime, Date endDateTime) {
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
    return DateFormat.getTimeInstance(DateFormat.SHORT).format(startDateTime);
  }

  /**
   * Returns a string with the ending date and time
   * @return string with the ending date and time
     */
  @Override
  public String getEndTimeString() {
    return DateFormat.getTimeInstance(DateFormat.SHORT).format(startDateTime);
  }

  /**
   * Returns the appointment's description
   * @return the appointment's description
     */
  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public int compareTo(Appointment other) {
    int startDateOrder = this.startDateTime.compareTo(other.startDateTime);
    int endDateOrder = this.endDateTime.compareTo(other.endDateTime);
    int descriptionOrder = this.description.compareTo(other.description);
    switch (startDateOrder) {
      case -1:
        return -1;
      case 1:
        return 1;
      default:
    }
    switch (endDateOrder) {
      case -1:
        return -1;
      case 1:
        return 1;
      default:
    }
    switch (descriptionOrder) {
      case -1:
        return -1;
      case 1:
        return 1;
      default:
    }
    return 0;
  }

  public long getDurationInMinutes() {
    return TimeUnit.MILLISECONDS.toMinutes(endDateTime.getTime() - startDateTime.getTime());
  }
}
