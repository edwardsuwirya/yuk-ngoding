package com.enigmacamp.yukngoding.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {
    public static Date stringToDate(String format, String sDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(sDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDate periodCalculationWorkDay(String startDate, int duration){
        if (duration == 0) {
            throw new RuntimeException("Duration is zero");
        }
        Calendar cal = Calendar.getInstance();
        Date courseStartDate = DateUtil.stringToDate("yyyy-MM-dd", startDate);
        cal.setTime(courseStartDate);

        while (duration > 1) {
            cal.add(Calendar.DATE, 1);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SUNDAY && dayOfWeek != Calendar.SATURDAY) {
                duration--;
            }

        }
        return LocalDate.ofInstant(cal.toInstant(), ZoneId.systemDefault());
    }
}
