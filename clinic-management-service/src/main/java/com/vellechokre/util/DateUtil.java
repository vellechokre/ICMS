package com.vellechokre.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

    /**
     * Sets a {@link Calendar} to midnight (00:00:00) at the date currently selected.
     *
     * @param calendar the {@link Calendar} which will be set to midnight
     * @throws NullPointerException if calendar is null
     */
    public static void toBeginningOfTheDay(Calendar calendar) {

        // Preconditions.checkNotNull(calendar, "Calendar");
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * Sets a {@link Calendar} to one second before midnight (23:59:59) at the date currently
     * selected.
     *
     * @param calendar the {@link Calendar} which will be set to one second before midnight
     * @throws NullPointerException if calendar is null
     */
    public static void toEndOfTheDay(Calendar calendar) {

        DateUtil.toBeginningOfTheDay(calendar);
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.SECOND, -1);
    }

    public static String dateToString(Date date, String format) {

        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date stringToDate(String date, String format) throws ParseException {

        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT;
        }
        return new SimpleDateFormat(format).parse(date);
    }
}
