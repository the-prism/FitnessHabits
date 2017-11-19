package com.strudelauxpommes.androidcomponents.demo.data_team.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Thomas on 2017-11-19.
 */

public class DateConverter {
    @TypeConverter
    public Date fromLong(long value) {
        return new Date(value);
    }

    @TypeConverter
    public long toLong(Date date) {
        return date.getTime();
    }
}
