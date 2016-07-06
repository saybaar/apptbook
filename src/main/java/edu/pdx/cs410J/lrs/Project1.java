package edu.pdx.cs410J.lrs;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
      System.out.print("readme here");
      System.exit(0);
    }

    //Check for wrong number of options:
    if(options.size() != 6) {
      System.err.println("Wrong number of options; expected: owner description beginDate beginTime endDate endTime");
      System.exit(1);
    }

    //Check for unrecognized flags:
    for(String flag : flags) {
      if(!(flag.equals("-print") || flag.equals("-README"))) {
        System.err.println("Unrecognized flag " + flag);
        System.exit(1);
      }
    }

    //Check for empty description:
    if(options.get(2).isEmpty()) {
      System.err.println("Description may not be empty");
      System.exit(1);
    }

    //Check validity of date and time:
    if(!isValidDate(options.get(2)) || !isValidDate(options.get(4))) {
      System.err.println("Invalid date format; expected: mm/dd/yyyy");
      System.exit(1);
    }
    if(!isValidTime(options.get(3)) || !isValidTime(options.get(5))) {
      System.err.println("Invalid time format; expected: hh:mm");
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

  /**
   * Adds the strings in arguments to the flags list until a string without a "-" prefix is
   * reached; adds the rest of the strings in arguments to the options list.
   * @param arguments the list of arguments to be separated
   * @param flags empty list to be filled with flags
   * @param options empty list to be filled with options
     */
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

  /**
   * Checks whether the given string is a valid time in HH:mm format.
   * @param time A string to be checked
   * @return true if the string is a valid time, false otherwise
     */
  public static boolean isValidTime(String time) {
    //Check format first, then numerical constraints
    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    format.setLenient(false);
    try {
      format.parse(time);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether the given string is a valid date in MM/dd/yyyy format.
   * @param date A string to be checked
   * @return true if the string is a valid date, false otherwise
     */
  public static boolean isValidDate(String date) {
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    format.setLenient(false);
    try {
      format.parse(date);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }

}