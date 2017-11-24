package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.GeneralCategory;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


@Entity
public class DrinkKindRecord {

    @PrimaryKey
    public int id;

    public String name;

    public Float volume;

    public VolumeMeasureUnit measureUnit;

    @NonNull
    @PrimaryKey
    public GeneralCategory category; // alcool ou breuvage

}
