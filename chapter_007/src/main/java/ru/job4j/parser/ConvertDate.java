package ru.job4j.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertDate {

    private static final Map<String, String> MONTH_MAP = Map.ofEntries(
            Map.entry("янв", "январь"),
            Map.entry("фев", "февраль"),
            Map.entry("мар", "март"),
            Map.entry("апр", "апрель"),
            Map.entry("май", "май"),
            Map.entry("июн", "июнь"),
            Map.entry("июл", "июль"),
            Map.entry("авг", "август"),
            Map.entry("сен", "сентябрь"),
            Map.entry("окт", "октябрь"),
            Map.entry("ноя", "ноябрь"),
            Map.entry("дек", "декабрь")
    );

    private final DateFormat format;

    public ConvertDate() {
        this.format = new SimpleDateFormat("dd MMM yy, h:mm");
    }

    /**
     * Convert date to long.
     * @param date Date.
     * @return time.
     * @throws ParseException
     */
    public long convert(String date) throws ParseException {
        long time;
        if (date.contains("сегодня")) {
            time = this.convertTodayYesterdayDate(date, 0);
        } else if (date.contains("вчера")) {
            time = this.convertTodayYesterdayDate(date, 1);
        } else {
            time = this.convertDate(date);
        }
        return time;
    }

    public long convertDate(String date) throws ParseException {
        String htmlMonth = date.split(" ")[1];
        String dateCorrect = date.replace(htmlMonth, MONTH_MAP.get(htmlMonth));
        return this.format.parse(dateCorrect).getTime();
    }

    public long convertTodayYesterdayDate(String date, int day) {
        String[] time = date.split(" ")[1].split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        Calendar convertDate = new GregorianCalendar();
        convertDate.set(Calendar.DAY_OF_YEAR, convertDate.get(Calendar.DAY_OF_YEAR) - day);
        convertDate.set(Calendar.HOUR_OF_DAY, hours);
        convertDate.set(Calendar.MINUTE, minutes);
        return convertDate.getTimeInMillis();
    }
}
