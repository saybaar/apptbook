package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookParser;
import edu.pdx.cs410J.ParserException;

import java.io.*;

import static edu.pdx.cs410J.lrs.ApptBookUtilities.isValidDateTime;

/**
 * Class for parsing appointment book files
 */
public class TextParser implements AppointmentBookParser {
    private FileReader r;

    /**
     * Creates a new TextParser with the given FileReader.
     * @param r The FileReader to use for this TextParser.
     */
    public TextParser(FileReader r) {
        this.r = r;
    }

    /**
     * Uses the TextParser's FileReader to read, parse, and return an AppointmentBook in the format specified by the
     * TextDumper class. Throws a ParserException if the format is incorrect or there is an error while reading.
     * @return The AppointmentBook object generated from the FileReader's file
     * @throws ParserException
     */
    @Override
    public AbstractAppointmentBook parse() throws ParserException {
        AppointmentBook apptBook;
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
                        throw new ParserException("File is bad - may be missing a field in an appointment record");
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
