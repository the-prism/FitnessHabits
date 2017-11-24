package com.strudelauxpommes.androidcomponents.demo.data_team.util;


import com.strudelauxpommes.androidcomponents.demo.data_team.model.SerializableToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CalendarDate extends BaseModelObject implements SerializableToString {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Calendar date;

    public CalendarDate(Calendar date) {
        this.date = date;
    }

    public static CalendarDate fromDatabaseString(String string) {
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
            date.clear();
            assertThat(false);
        }
        return new CalendarDate(date);
    }

    public static CalendarDate now() {
        return new CalendarDate(Calendar.getInstance());
    }

    public static CalendarDate fromYearMonthDay(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return new CalendarDate(calendar);
    }

    public String toDatabaseString() {
        return format.format(date.getTime());
    }

    public long getTimeInMillis() {
        // utilité: pour la méthode CalendarView::setDate()
        return date.getTimeInMillis();
    }

    @Override
    public String encodeToString() {
        return toDatabaseString();
    }

}