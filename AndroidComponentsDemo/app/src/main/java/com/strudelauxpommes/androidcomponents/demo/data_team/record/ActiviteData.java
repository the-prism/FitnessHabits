package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.NO_ACTION;

/**
 * Created by Thomas on 2017-11-18.
 */
@Entity(primaryKeys = {"date", "categoryId"},
        foreignKeys = @ForeignKey(entity = ActiviteCategory.class,
                parentColumns = "id",
                childColumns = "categoryId",
                onDelete = NO_ACTION))
public class ActiviteData {
    @NonNull
    private String date;
    @Ignore
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}

