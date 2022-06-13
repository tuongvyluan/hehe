package utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class MyUtils {

    public static LocalDate convertDateToLocalDate(Date dateToConvert) {
        LocalDate lDate = null;
        lDate = new Timestamp(dateToConvert.getTime()).toLocalDateTime().toLocalDate();
        return lDate;
    }
}
