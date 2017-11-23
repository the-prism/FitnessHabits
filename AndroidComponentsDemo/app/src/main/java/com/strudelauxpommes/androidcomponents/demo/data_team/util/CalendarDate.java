package com.strudelauxpommes.androidcomponents.demo.data_team.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class CalendarDate {

    LocalDate date;
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CalendarDate(LocalDate date) {
        this.date = date;
    }

    public String toDatabaseString() {
        return format.format(date);
    }

    public static CalendarDate fromDatabaseString(String string) {
        LocalDate parsed = LocalDate.parse(string, format);
        return new CalendarDate(parsed);
    }

    public static CalendarDate now() {
        return new CalendarDate(LocalDate.now());
    }

    public static CalendarDate fromYearMonthDay(int year, int month, int day) {
        return new CalendarDate(LocalDate.of(year, month, day));
    }

    public long getTimeInMillis() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, date.getYear());
        calendar.set(Calendar.MONTH, date.getMonthValue());
        calendar.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());

        return calendar.getTimeInMillis();
    }



}
