package edu.pdx.cs410J.lrs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility methods for the CS410J appointment book project
 */
public class ApptBookUtilities {

    /**
     * Date/time parser used for both command line arguments and date/time strings read from file.
     * Expects to match dumpDateTime. 
     * @param dateTimeString A string date/time to check, expected format "MM/dd/yyyy HH:mm"
     * @return true if string is a valid date/time in "MM/dd/yyyy HH:mm" format, false otherwise
     */
    public static Date parseDateTime(String dateTimeString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        format.setLenient(false);
        return format.parse(dateTimeString);
    }

    /**
     *
     */
    public static String dumpDateTime(Date date)  {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        format.setLenient(false);
        return format.format(date);
    }

    public static String prettyDateTime(Date date) {
        return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(date);
    }
}
