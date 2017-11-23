package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.converter.DateConverter;
import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Thomas on 2017-11-18.
 */
@Entity(primaryKeys = {"date","activite"})
public class ActiviteData {

    @TypeConverters({DateConverter.class})
    @NonNull
    private LocalDateTime date;
    @NonNull
    private String activite;
    private int intensite;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public int getIntensite() {
        return intensite;
    }

    public void setIntensite(int intensite) {
        this.intensite = intensite;
    }

}

