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

    Class c = AbstractAppointmentBook.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    //args: owner description beginTime endTime
      //beginTime and endTime each have mm/dd/yyyy hh:mm with leading 0s optional for mm, dd, hh
      //optional flags before args: -print -README
    List<String> flags = new ArrayList<>(2);
    List<String> options = new ArrayList<>(6);
    List<String> arguments = Arrays.asList(args);
    parseArguments(arguments, flags, options);

    if(flags.contains("-README")) {
      //print readme from inline
    }

    if(options.size() != 6) {
      System.err.println("Wrong number of options; expected: owner description beginDate beginTime endDate endTime");
      System.exit(1);
    }

    for(String flag : flags) {
      if(!(flag.equals("-print") || flag.equals("-README"))) {
        System.err.println("Unrecognized flag " + flag);
        System.exit(1);
      }
    }

    if(options.get(2).isEmpty()) {
      System.err.println("Description may not be empty");
      System.exit(1);
    }

    AppointmentBook apptBook = new AppointmentBook(options.get(0));
    Appointment appt = new Appointment(options.get(1), options.get(2), options.get(3), options.get(4), options.get(5));
    apptBook.addAppointment(appt);

    if(flags.contains("-print")) {
      System.out.println(appt.toString());
    }

    System.exit(0);
  }

  public static void parseArguments(List<String> arguments, List<String> flags, List<String> options) {
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

  private boolean isValidTime(String time) {
    //Check format first, then numerical constraints
    return false;
  }

  private boolean isValidDate(String date) {
    return false;
  }

}