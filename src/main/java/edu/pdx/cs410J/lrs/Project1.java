package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project1 {

  public static void main(String[] args) {
      //args: owner description beginTime endTime
      //beginTime and endTime each have mm/dd/yyyy hh:mm with leading 0s optional for mm, dd, hh
      //optional flags before args: -print -README
    List<String> flags = new ArrayList<>(2);
    List<String> options = new ArrayList<>(6);
    List<String> arguments = Arrays.asList(args);
    parseArguments(arguments, flags, options);

    if(options.size() != 5) {

    }

    for(String arg : arguments) {
      if(!(arg.equals("-print") || arg.equals("-README"))) {

      }
    }

    AppointmentBook apptBook = new AppointmentBook();
    Appointment appt = new Appointment(options.get(0), options.get(1), options.get(2), options.get(3), options.get(4), options.get(5));
    apptBook.addAppointment(appt);

    Class c = AbstractAppointmentBook.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }
    System.exit(1);
  }

  private static void parseArguments(List<String> arguments, List<String> flags, List<String> options) {
    int index = 0;
    while(index < arguments.size()) {
      if(arguments.get(index).startsWith("-")) {
        flags.add(arguments.get(index));
        index++;
      } else {
        break;
      }
    }
    while(index < arguments.size()) {
      options.add(arguments.get(index));
      index++;
    }
  }

}