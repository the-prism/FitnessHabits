package com.strudelauxpommes.androidcomponents.demo.data_team.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.CalendarDate;
import com.strudelauxpommes.androidcomponents.demo.view_team.*;



@Entity(primaryKeys = {"date"})
public class WeightRecord {

    @NonNull
    public CalendarDate date;

    @NonNull
    public Float weight;

}
