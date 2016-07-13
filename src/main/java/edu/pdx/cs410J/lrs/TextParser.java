package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookParser;
import edu.pdx.cs410J.ParserException;

import java.io.*;

import static edu.pdx.cs410J.lrs.ApptBookUtilities.isValidDateTime;

public class TextParser implements AppointmentBookParser {
    FileReader r;

    public TextParser(FileReader r) {
        this.r = r;
    }

    @Override
    public AbstractAppointmentBook parse() throws ParserException {
        AppointmentBook apptBook = null;
        try (BufferedReader br = new BufferedReader(r)) {
            String line = br.readLine();
            if(line == null) {
                throw new ParserException("Given file is empty");
            }
            apptBook = new AppointmentBook(line);
            while(true) {
                line = br.readLine();
                if(line == null) {
                    break;
                }
                if(!line.isEmpty()) {
                    throw new ParserException("No blank line before appointment record");
                }
                String[] lines = new String[3];
                for (int i = 0; i < 3; i++) {
                    line = br.readLine();
                    if(line == null || line.isEmpty()) {
                        throw new ParserException("Missing field in appointment record");
                    } else {
                        lines[i] = line;
                    }
                }
                if(!isValidDateTime(lines[1]) || !isValidDateTime(lines[2])) {
                    throw new ParserException("Malformatted date in appointment record");
                }
                apptBook.addAppointment(new Appointment(lines[0], lines[1], lines[2]));
            }

        } catch (IOException e) {
            throw new ParserException("Error reading file");
        }
        return apptBook;
    }
}
