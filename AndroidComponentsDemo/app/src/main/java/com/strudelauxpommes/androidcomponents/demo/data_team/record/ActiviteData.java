package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Ignore;

/**
 * Created by Thomas on 2017-11-24.
 */

public class ActiviteData {
    private String date;
    private int intensite;
    private int categoryId;
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
