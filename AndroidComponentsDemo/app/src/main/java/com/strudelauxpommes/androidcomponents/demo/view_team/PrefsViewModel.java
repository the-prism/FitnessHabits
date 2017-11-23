package com.strudelauxpommes.androidcomponents.demo.view_team;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



public class PrefsViewModel extends ViewModel {

    UIDataRepository repository;
    LiveData<PrefsData> prefsLiveData;
    LiveData<String> userName;
    LiveData<PrefRecord> userNamePrefRecord;


    public LiveData<String> getUserName() {
        return this.userName;
    }



    public void init(UIDataRepository repository) {
        this.repository = repository;
        this.prefsLiveData = repository.loadPrefsLiveData();
        this.userNamePrefRecord = repository.loadUserNamePrefRecordLiveData();

        this.userName = Transformations.map(this.userNamePrefRecord, x -> x.value);
    }



    public void setUserName(String name) {

        PrefRecord record = userNamePrefRecord.getValue();

        if (record != null) {
            record.name = "pref.user.name";
            record.setValue(name);
            repository.savePrefRecord(record);
        }

    }
}
