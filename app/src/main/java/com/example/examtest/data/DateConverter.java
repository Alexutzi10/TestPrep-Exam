package com.example.examtest.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static String fromDate(Date date) {
        if (date == null) {
            return null;
        }
        return FORMATTER.format(date);
    }

    public static Date toDate(String value) {
        try {
            return FORMATTER.parse(value);
        } catch (ParseException ex) {
            return null;
        }
    }
}
