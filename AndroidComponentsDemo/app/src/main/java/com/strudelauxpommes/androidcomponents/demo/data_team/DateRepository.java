package com.strudelauxpommes.androidcomponents.demo.data_team;


import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.WeightRecord;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.BaseModelObject;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.CalendarDate;

public class DateRepository extends BaseModelObject {

    UIDataRepository parent;
    CalendarDate date;
    LiveData<WeightRecord> weightRecordLiveData;

    public DateRepository(UIDataRepository parent, CalendarDate date) {
        this.parent = parent;
        this.date = date;
        print("INIT DateRepository");

    }


    public LiveData<WeightRecord> loadWeightRecordLiveData() {

        if(weightRecordLiveData == null) {

            WeightRecord defaultRecord = new WeightRecord();
            defaultRecord.date = this.date;
            defaultRecord.weight = null;
            defaultRecord.fat = null;

            weightRecordLiveData = new DatabaseResource<WeightRecord>(defaultRecord) {
                @NonNull
                @Override
                protected LiveData<WeightRecord> loadFromDb() {
                    return parent.weightRecordDao.searchWeightRecord(date);
                }
            }.getAsLiveData();

            print("weightRecordLiveData == null");

        }

        print("return weightRecordLiveData");
        return weightRecordLiveData;

    }




}
