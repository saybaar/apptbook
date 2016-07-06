package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointment;

public class Appointment extends AbstractAppointment {
  private String owner;
  private String description;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;

  public Appointment(String owner, String description, String startDate, String startTime, String endDate, String endTime) {
    this.owner = owner;
    this.description = description;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
  }

  @Override
  public String getBeginTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getEndTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getDescription() {
    return "This method is not implemented yet";
  }
}
