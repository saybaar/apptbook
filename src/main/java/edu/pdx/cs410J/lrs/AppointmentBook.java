package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.Collection;
import java.util.List;

public class AppointmentBook extends AbstractAppointmentBook<Appointment> {
    private String owner;
    private List<Appointment> appts;

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
