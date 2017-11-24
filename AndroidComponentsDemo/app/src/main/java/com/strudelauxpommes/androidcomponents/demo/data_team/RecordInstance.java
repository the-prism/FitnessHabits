package com.strudelauxpommes.androidcomponents.demo.data_team;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.PrefRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.WeightRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.BaseModelObject;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.CalendarDate;

public class RecordInstance extends BaseModelObject {

    CalendarDate date;
    UIDataRepository repository;
    LiveData<Float> liveData;
    LiveData<WeightRecord> weightRecord;
    BaseField field;

    public RecordInstance(UIDataRepository repository, CalendarDate date, BaseField field, LiveData<WeightRecord> weightRecord ) {
        this.repository = repository;
        this.date = date;
        this.weightRecord = weightRecord;
        this.field = field;

        this.liveData = Transformations.map(this.weightRecord, x -> transform(x));
    }

    public Float transform(WeightRecord weightRecord) {
        Float value = (Float)field.getRecordValue(weightRecord);

        if(value == null) {
            return 0F;
        } else {
            return value;
        }

    }

    public void setValue(float value) {

        WeightRecord record = weightRecord.getValue();
        record.date = this.date;
        field.setRecordValue(record, value);

        repository.saveWeightRecord(record);

        Log.d("foo", "save w " + value);


    }


    public LiveData<Float> liveData() {
        return liveData;
    }


}

