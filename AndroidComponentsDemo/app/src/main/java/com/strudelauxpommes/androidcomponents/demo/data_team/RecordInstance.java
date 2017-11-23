package com.strudelauxpommes.androidcomponents.demo.data_team;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.PrefRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.WeightRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.CalendarDate;

public class RecordInstance {

    @NonNull
    CalendarDate date;

    @NonNull
    UIDataRepository repository;

    @NonNull
    LiveData<Float> liveData;

    @NonNull
    LiveData<WeightRecord> weightRecord;


    public RecordInstance(UIDataRepository repository, CalendarDate date, LiveData<WeightRecord> weightRecord ) {
        this.repository = repository;
        this.date = date;
        this.weightRecord = weightRecord;

        this.liveData = Transformations.map(this.weightRecord, x -> transform(x));
    }

    public Float transform(WeightRecord weightRecord) {
        if(weightRecord.weight == null) {
            return 0F;
        } else {
            return weightRecord.weight;
        }
    }

    public void setValue(float value) {

        WeightRecord record = new WeightRecord();
        record.date = this.date;
        record.weight = value;

        repository.saveWeightRecord(record);

        Log.d("foo", "save w " + value);


    }


    public LiveData<Float> liveData() {
        return liveData;
    }


}

