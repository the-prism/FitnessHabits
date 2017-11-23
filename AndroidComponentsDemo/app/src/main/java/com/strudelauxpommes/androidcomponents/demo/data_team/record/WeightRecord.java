package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;




@Entity(primaryKeys = {"date"})
public class WeightRecord {

    @NonNull
    public CalendarDate date;

    @NonNull
    public Float weight;

}
