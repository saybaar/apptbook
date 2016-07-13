package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project2 {

    public static void main(String[] args) {

        Class c = AbstractAppointmentBook.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

        //args: owner description beginTime endTime
        //beginTime and endTime each have mm/dd/yyyy hh:mm with leading 0s optional for mm, dd, hh
        //optional flags before args: -print -README -file filepath
        boolean shouldPrint = false;
        boolean fileMode = false;
        String filePath = null;
        String owner = null;
        String description = null;
        String beginDateString = null;
        String beginTimeString = null;
        String endDateString = null;
        String endTimeString = null;

        int i = 0;
        for(; i < args.length && args[i].startsWith("-"); i++) {
            if (args[i].equals("-README")) {
                printReadMe();
                System.exit(0);
            } else if (args[i].equals("-print")) {
                shouldPrint = true;
            } else if (args[i].equals("-file")) {
                i++;
                fileMode = true;
                try {
                    filePath = args[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("-file flag requires a value");
                    System.exit(1);
                }
            } else {
                System.err.println("Unrecognized flag: " + args[i]);
                System.exit(1);
            }
        }
        for(; i < args.length; i++) {
            if(owner == null) {
                owner = args[i];
            } else if(description == null) {
                description = args[i];
            } else if(beginDateString == null) {
                beginDateString = args[i];
            } else if(beginTimeString == null) {
                beginTimeString = args[i];
            } else if(endDateString == null) {
                endDateString = args[i];
            } else if(endTimeString == null) {
                endTimeString = args[i];
            }
        }

        //Check for wrong number of options:
        List<String> necessaryOptionsList = Arrays.asList(owner, description, beginDateString, beginTimeString, endDateString, endTimeString);
        for(String option : necessaryOptionsList) {
            if (option == null) {
                System.err.println("Wrong number of options; expected: owner description beginDate beginTime endDate endTime");
                System.exit(1);
            }
        }

        //Check for empty description:
        if(description.isEmpty()) {
            System.err.println("Error: Description may not be empty");
            System.exit(1);
        }

        //Check validity of date and time:
        if(!ApptBookUtilities.isValidDateTime(beginDateString + " " + beginTimeString) || !ApptBookUtilities.isValidDateTime(endDateString + " " + endTimeString)) {
            System.err.println("Invalid date/time format; expected: mm/dd/yyyy hh:mm");
            System.exit(1);
        }

        //The AppointmentBook we will be working with
        AppointmentBook apptBook = null;

        //If we are in fileMode, parse apptBook from the given file if it exists, or create a new AppointmentBook if not
        if(fileMode) {
            FileReader reader = null;
            try {
                reader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                apptBook = new AppointmentBook(owner);
            }

            if (apptBook == null) { //i.e. reader creation was successful, so the file exists
                TextParser parser = new TextParser(reader);
                try {
                    apptBook = (AppointmentBook) parser.parse(); //TODO: is this okay?
                } catch (ParserException e) {
                    System.err.println("Parser exception - " + e.getMessage());
                    System.exit(1);
                }
            }
            //If not in fileMode, always create a new AppointmentBook
        } else {
            apptBook = new AppointmentBook(owner);
        }

        //Check that the owner from command line is the same as the owner of apptBook; this may not be true if apptBook was read from file
        if(!apptBook.getOwnerName().equals(owner)) {
            System.err.println("Error: Owner of this appointment does not own the given AppointmentBook");
            System.exit(1);
        }

        //Add the specified appointment to apptBook
        Appointment appt = new Appointment(description, beginDateString + " " + beginTimeString, endDateString + " " + endTimeString);
        apptBook.addAppointment(appt);

        //Print if -print flag is enabled
        if(shouldPrint) {
            System.out.println(appt.toString());
        }

        //If we are in fileMode, write apptBook to the given filepath
        if(fileMode) {
            TextDumper dumper = new TextDumper(filePath);
            try {
                dumper.dump(apptBook);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }

        System.exit(0);
    }

    private static void printReadMe() {
        System.out.print("\n\n" +
                "Lydia Simmons - CS510J Advanced Java, Project 2\n\n" +
                "Usage: [-README] [-print] [-file filepath] owner description startDate startTime endDate endTime\n\n" +
                "Creates an Appointment with the given parameters. If -print is enabled, prints the Appointment to" +
                "the console. If -file is enabled, adds the Appointment to a new or existing appointment book stored" +
                "at filepath. Will not add appointments to an existing file if the owner does not match.\n\n");
    }

}