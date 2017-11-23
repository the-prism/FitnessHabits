package com.strudelauxpommes.androidcomponents.demo.data_team.pref;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;



public class PreferenceInstance<PrefType> extends BaseModelObject {
    UIDataRepository repository;
    LiveData<PrefRecord> prefRecord;
    private LiveData<PrefType> liveData;

    @NonNull
    BasePreference pref;

    public PreferenceInstance(UIDataRepository repository, BasePreference pref, LiveData<PrefRecord> prefRecord) {
        this.repository = repository;
        this.prefRecord = prefRecord;
        this.pref = pref;

        this.liveData = Transformations.map(this.prefRecord, x -> transform(x));
    }

    public PrefType transform(PrefRecord prefRecord) {
        if(prefRecord.value == null) {
            print("get default value for " + this.pref.name());
            return (PrefType)pref.getDefaultValue();
        } else {
            return (PrefType)pref.parseFromString(prefRecord.value);
        }
    }

    public LiveData<PrefType> liveData() {
        return this.liveData;
    }

    public void setValue(PrefType value) {

        PrefRecord record = prefRecord.getValue();

        if (record != null) {
            record.name = pref.name();
            record.setValue(pref.encodeToString(value));
            repository.savePrefRecord(record);
        }

    }





}




















