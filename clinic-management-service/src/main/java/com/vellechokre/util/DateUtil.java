package com.vellechokre.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

    /**
     * Get Formated Date as String in IST time Zone
     *
     * @param format
     * @return
     * @throws ParseException
     */
    public static String getCurrentString(final String format) {

        return stringFormatedDate(getCurrent(new Date(), ApplicationConstant.TIME_ZONE_IST),
                format);
    }

    /**
     * Get Date in Provided Time Zone
     *
     * @param date
     * @param timeZone
     * @return
     */
    public static Date getCurrent(final Date date, final String timeZone) {

        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return calendar.getTime();
    }

    /**
     * Method to convert given date in given string format. <br/>
     * In this method formated date contains special character present in format.
     *
     * @param date
     * @param format
     * @return string date
     */
    public static String stringFormatedDate(final Date date, final String format) {

        final SimpleDateFormat simpleDF = new SimpleDateFormat(format);
        return simpleDF.format(date);
    }

    /**
     * @return
     */
    public static Date getCurrentStart() {

        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("IST"));
        calendar.setTime(new Date());
        toBeginningOfTheDay(calendar);
        return calendar.getTime();
    }

    /**
     * @return
     */
    public static Date getCurrentEnd() {

        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("IST"));
        calendar.setTime(new Date());
        toEndOfTheDay(calendar);
        return calendar.getTime();
    }

    /**
     * @see https://www.mkyong.com/java/java-how-to-add-days-to-current-date/ this method will used
     *      to add or subtract days from given date here if operation is true then addition will be
     *      performed and if flase then subtration
     * @param date
     * @param days
     * @param operation
     * @return
     */
    public static Date modifyDays(final Date date, final int days, final boolean operation) {

        LocalDateTime localDateTime =
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // plus days
        if (operation) {
            localDateTime = localDateTime.plusDays(days);
        }
        // subtract days
        else {
            localDateTime = localDateTime.minusDays(days);
        }
        // convert LocalDateTime to date
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
