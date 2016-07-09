package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class for AppointmentBook objects.
 */
public class AppointmentBook extends AbstractAppointmentBook<Appointment> {
    private String owner;
    private List<Appointment> appts;

    /**
     * Creates a new AppointmentBook owned by "owner".
     * @param owner The owner of this book
     */
    public AppointmentBook(String owner) {
        this.owner = owner;
        this.appts = new ArrayList<Appointment>();
    }

    /**
     * Returns the owner of this book.
     * @return The name of this book's owner
     */
    @Override
    public String getOwnerName() {
        return owner;
    }

    /**
     * Returns the Appointments in this book.
     * @return List of this book's Appointments
     */
    @Override
    public Collection<Appointment> getAppointments() {
        return appts;
    }

    /**
     * Adds an Appointment to this book.
     * @param appointment The appointment to be added
     */
    @Override
    public void addAppointment(Appointment appointment) {
        appts.add(appointment);
    }
}
