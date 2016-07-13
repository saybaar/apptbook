package edu.pdx.cs410J.lrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Utility methods for the CS410J appointment book project
 */
public class ApptBookUtilities {

    /**
     * @param dateTime A string date/time to check, expected format "MM/dd/yyyy HH:mm"
     * @return true if string is a valid date/time in "MM/dd/yyyy HH:mm" format, false otherwise
     */
    public static boolean isValidDateTime(String dateTime) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        format.setLenient(false);
        try {
            format.parse(dateTime);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
