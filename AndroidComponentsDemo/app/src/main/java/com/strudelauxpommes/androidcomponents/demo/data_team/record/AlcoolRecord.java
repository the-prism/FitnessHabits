package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



@Entity(foreignKeys = @ForeignKey(
        entity = DrinkKindRecord.class,
        parentColumns = "id",
        childColumns = "kind"))
public class AlcoolRecord extends BaseRecord {

    @PrimaryKey
    public CalendarDate date;

    @PrimaryKey
    public int kind;

}
