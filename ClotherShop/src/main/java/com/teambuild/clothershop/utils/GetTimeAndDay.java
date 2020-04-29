package com.teambuild.clothershop.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GetTimeAndDay {
    public static String getTime() {
        LocalTime time = LocalTime.now(); // gets the current time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }

    public static String getDay() {
        LocalDate date = LocalDate.now(); // gets the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
