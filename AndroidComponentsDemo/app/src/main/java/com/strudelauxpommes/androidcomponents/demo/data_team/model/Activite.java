package com.strudelauxpommes.androidcomponents.demo.data_team.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;

import java.util.Date;

/**
 * Created by Thomas on 2017-11-18.
 */
@Entity
public class Activite {
    @PrimaryKey
    private Date date;
    @PrimaryKey
    private String activite;
    private int intensite;

    public void setDate(Date date) {
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
