package com.strudelauxpommes.androidcomponents.demo.data_team.converter;

import android.arch.persistence.room.TypeConverter;

import com.strudelauxpommes.androidcomponents.demo.data_team.CalendarDate;


public class CalendarDateConverter {

    @TypeConverter
    public CalendarDate fromString(String value) {
        return CalendarDate.fromDatabaseString(value);
    }

    @TypeConverter
    public String toString(CalendarDate date) {
        return date.toDatabaseString();
    }

}
