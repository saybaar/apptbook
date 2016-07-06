package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointment;

public class Appointment extends AbstractAppointment {
  private String description;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;

  public Appointment(String description, String startDate, String startTime, String endDate, String endTime) {
    this.description = description;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
  }

  @Override
  public String getBeginTimeString() {
    return startDate + " " + startTime;
  }

  @Override
  public String getEndTimeString() {
    return endDate + " " + endTime;
  }

  @Override
  public String getDescription() {
    return description;
  }
}
