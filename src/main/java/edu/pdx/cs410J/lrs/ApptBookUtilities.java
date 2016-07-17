package edu.pdx.cs410J.lrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility methods for the CS410J appointment book project
 */
public class ApptBookUtilities {

    /**
     * @param dateTimeString A string date/time to check, expected format "MM/dd/yyyy HH:mm"
     * @return true if string is a valid date/time in "MM/dd/yyyy HH:mm" format, false otherwise
     */
    public static Date parseDateTime(String dateTimeString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        format.setLenient(false);

        return new Date();
        /*try {
            format.parse(dateTime);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), e.getErrorOffset());
        }
        return true;
        */
    }
}
