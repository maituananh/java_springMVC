package com.teambuild.clothershop.utils;

import com.teambuild.clothershop.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetTimeAndDay {
    public static String getTime() {
        LocalTime time = LocalTime.now(); // gets the current time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }

    public static String getDay() {
        LocalDate date = LocalDate.now(); // gets the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static List<Integer> compareDate(List<Product> productList) {
        List<Integer> idProductNew = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date dateNow = new java.sql.Date(millis);
        for (int i = 0; i < productList.size(); i++) {
            String stringDate = productList.get(i).getCreated_date();
            try {
                Date date = formatter.parse(stringDate);
                long diffInMillies = Math.abs(dateNow.getTime() - date.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if (diff <= 30) {
                    idProductNew.add(productList.get(i).getIdProduct());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return idProductNew;
    }
}
