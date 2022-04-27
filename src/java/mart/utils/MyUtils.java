/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Luan Tuong Vy
 */
public class MyUtils {
    
    public static LocalDate convertDateToLocalDate(Date dateToConvert) {
        LocalDate lDate = null;
        lDate = new Timestamp(dateToConvert.getTime()).toLocalDateTime().toLocalDate();
        return lDate;
    }
}
