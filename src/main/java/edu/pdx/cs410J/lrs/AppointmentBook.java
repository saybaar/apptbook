package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.*;

public class AppointmentBook extends AbstractAppointmentBook<Appointment> {
    private String owner;
    private SortedSet<Appointment> appts;

    public AppointmentBook(String owner) {
        this.owner = owner;
        this.appts = new TreeSet<Appointment>();
    }

    @Override
    public String getOwnerName() {
        return owner;
    }

    @Override
    public Collection<Appointment> getAppointments() {
        return appts;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appts.add(appointment);
    }
}
