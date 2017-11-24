package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Thomas on 2017-11-24.
 */

@Entity
public class ActiviteCategory {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;


    private int intensite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntensite(int intensite) {
        this.intensite = intensite;
    }

    public int getIntensite() {
        return intensite;
    }
}
