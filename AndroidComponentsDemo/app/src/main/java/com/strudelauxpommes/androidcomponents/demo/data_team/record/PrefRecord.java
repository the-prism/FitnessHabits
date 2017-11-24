package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.view_team.*;



@Entity(primaryKeys = {"name"})
public class PrefRecord extends BaseRecord {

    @NonNull
    public String name;
    public String value;

    public void setValue(String value) {
        this.value = value;
    }

}
