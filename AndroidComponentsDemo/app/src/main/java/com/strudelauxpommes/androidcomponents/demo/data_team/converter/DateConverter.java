package com.strudelauxpommes.androidcomponents.demo.data_team.converter;

import android.arch.persistence.room.TypeConverter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by Thomas on 2017-11-19.
 */

public class DateConverter {
    @TypeConverter
    public LocalDateTime fromLong(String value) {
        return LocalDateTime.parse(value);
    }

    @TypeConverter
    public String toLong(LocalDateTime date) {
        return date.toString();
    }
}
