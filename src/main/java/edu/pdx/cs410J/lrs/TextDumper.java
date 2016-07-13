package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lydia on 7/9/16.
 */
public class TextDumper implements AppointmentBookDumper {

    String filePath;

    public TextDumper(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void dump(AbstractAppointmentBook apptBook) throws IOException {
        File file = new File(filePath);
        if(!file.isFile()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(apptBook.getOwnerName(), 0, apptBook.getOwnerName().length());
            for(Appointment appt : ((AppointmentBook) apptBook).getAppointments()) { //TODO: again, is this okay?
                StringBuilder sb = new StringBuilder();
                sb.append("\n\n");
                sb.append(appt.getDescription() + "\n");
                sb.append(appt.getBeginTimeString() + "\n");
                sb.append(appt.getEndTimeString());
                bw.write(sb.toString(), 0, sb.toString().length());
            }
        } catch (IOException e) {
            throw new IOException("IOException while dumping apptBook");
        }
    }
}
