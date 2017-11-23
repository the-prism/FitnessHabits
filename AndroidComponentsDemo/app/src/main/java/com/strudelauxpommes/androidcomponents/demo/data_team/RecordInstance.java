package com.strudelauxpommes.androidcomponents.demo.data_team;


import android.util.Log;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.WeightRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.CalendarDate;

public class RecordInstance {

    CalendarDate date;
    UIDataRepository repository;

    public RecordInstance(UIDataRepository repository, CalendarDate date) {
        this.repository = repository;

    }


    public void setValue(float value) {

        WeightRecord record = new WeightRecord();
        record.date = CalendarDate.now();
        record.weight = value;

        repository.saveWeightRecord(record);

        Log.d("foo", "save w " + value);


    }


}
