package com.strudelauxpommes.androidcomponents.demo.data_team;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CalendarDate {

    LocalDateTime date;
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CalendarDate(LocalDateTime date) {
        this.date = date;

    }

    public String toDatabaseString() {
        return format.format(date);
    }

    public static CalendarDate fromDatabaseString(String string) {
        LocalDateTime parsed = LocalDateTime.parse(string, format);
        return new CalendarDate(parsed);
    }

    public static CalendarDate now() {
        return new CalendarDate(LocalDateTime.now());
    }
}
