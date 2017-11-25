package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.BaseRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



@Entity(primaryKeys = {"date", "kind"},
        foreignKeys = @ForeignKey(
        entity = DrinkKindRecord.class,
        parentColumns = "id",
        childColumns = "kind"))
public class AlcoolRecord extends BaseRecord {

    @NonNull
    public CalendarDate date;

    @NonNull
    public int kind;

}
