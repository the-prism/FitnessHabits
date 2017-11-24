package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.BaseRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



@Entity(primaryKeys = {"date"})
public class WeightRecord extends BaseRecord {

    @NonNull
    public CalendarDate date;

    public Float weight;
    public Float fat;

}
