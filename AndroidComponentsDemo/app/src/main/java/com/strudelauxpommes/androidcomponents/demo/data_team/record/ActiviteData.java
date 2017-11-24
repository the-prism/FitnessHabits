package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.converter.DateConverter;
import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Thomas on 2017-11-18.
 */
@Entity(primaryKeys = {"date","categoryId"} ,
        foreignKeys = @ForeignKey(entity = ActiviteCategory.class,
                parentColumns = "id",
                childColumns = "categoryId",
                onDelete = CASCADE))
public class ActiviteData {
    @NonNull
    private String date;
    @NonNull
    private String activite;
    private int intensite;
    private int categoryId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }
}

