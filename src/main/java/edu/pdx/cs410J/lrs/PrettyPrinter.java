package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.*;

/**
 * Class for dumping appointment book files
 //TODO: Remember we need the duration of the appointment!
 */
public class PrettyPrinter implements AppointmentBookDumper {

    private String filePath;

    /**
     * Creates a new TextDumper that will write to the given file name/path.
     * @param filePath The (relative) filepath to write to
     */
    public PrettyPrinter(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Pretty-prints the given AppointmentBook to file at the location given by the PrettyPrinter's filePath string.
     * Will generate a system error if filePath contains a directory that does not exist.
     * @param apptBook The appointment book to dump
     * @throws IOException
     */
    @Override
    public void dump(AbstractAppointmentBook apptBook) throws IOException {
        if(filePath.equals("-")) {
            stdOutDump(apptBook);
        } else {
            fileDump(apptBook);
        }
    }

    public void fileDump(AbstractAppointmentBook apptBook) throws IOException {
        File file = new File(filePath);
        if(!file.isFile()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(dumpString(apptBook));
        } catch (IOException e) {
            throw new IOException("IOException while pretty-printing apptBook to file: " + e.getMessage());
        }
    }

    public void stdOutDump(AbstractAppointmentBook apptBook) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(dumpString(apptBook));
            bw.flush();
        } catch (IOException e) {
            throw new IOException("IOException while pretty-printing apptBook to stdout: " + e.getMessage());
        }
    }

    private String dumpString(AbstractAppointmentBook apptBook) {
        StringBuilder sb = new StringBuilder();
        sb.append("Appointment book for " + apptBook.getOwnerName() + ":");
        for(Appointment appt : ((AppointmentBook) apptBook).getAppointments()) {
            sb.append("\n\t - ");
            sb.append(appt.getDescription() + "\n\t\t");
            sb.append(appt.getBeginTimeString() + " to ");
            sb.append(appt.getEndTimeString() + " (");
            sb.append(appt.getDurationInMinutes() + " minutes)");
        }
        return sb.toString();
    }

}
