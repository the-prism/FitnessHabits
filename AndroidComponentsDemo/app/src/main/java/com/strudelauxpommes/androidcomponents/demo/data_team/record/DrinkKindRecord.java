package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.GeneralCategory;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


@Entity
public class DrinkKindRecord {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public Float volume;

    @NonNull
    public GeneralCategory topic; // alcool ou breuvage

}
