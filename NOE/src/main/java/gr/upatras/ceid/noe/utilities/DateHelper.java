package gr.upatras.ceid.noe.utilities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateHelper {

    public static Date dateFromSQLDateTime(String datetime) {
        return new Date();
    }

    public static LocalTime localTimeFromSQLDateTime(String datetime) {
        return LocalTime.parse(datetime);
    }

    public static LocalDateTime localDateTimeFromSQLDateTime(String datetime) {
        return LocalDateTime.parse(datetime);
    }

    public static int calculateDuration(LocalTime start, LocalTime end) {
        return 0;
    }
}
