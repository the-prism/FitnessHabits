package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.view_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;


/**
 * A Repository is used to combine one or several data source. The Repository is agnostic of it's
 * data source implementation. That means that the caller class does not know where the data is
 * coming from. In this case the only data source is the database, but we could have a network data
 * source, a disk cache, or any other kind of data source. This class have the goal of combining the
 * data sources and provide the most fresh data available. It should also know how to save the data
 * and propagate it to all the data sources.
 *
 * Created by Marc-Antoine Sauvé on 11/11/17.
 */
public class UIDataRepository extends BaseModelObject {

    private UIDataDao uiDataDao;
    private WeightRecordDao weightRecordDao;
    private PrefRecordDao prefRecordDao;

    PreferenceManager prefManager;



    public UIDataRepository(UIDataDao uiDataDao, WeightRecordDao weightRecordDa, PrefRecordDao prefRecordDao) {
        this.uiDataDao = uiDataDao;
        this.weightRecordDao = weightRecordDao;
        this.prefRecordDao = prefRecordDao;

        this.prefManager = new PreferenceManager();


        print((String)prefManager.getPref("pref.user.name"));

    }






    public LiveData<UIData> loadUIData() {
        UIData defaultUIData = new UIData();
        defaultUIData.setBackgroundColor(FormViewModel.BackgroundColor.blue);
        defaultUIData.setFontSize(24);
        return new DatabaseResource<UIData>(defaultUIData) {
            @NonNull
            @Override
            protected LiveData<UIData> loadFromDb() {
                return uiDataDao.getUIData();
            }
        }.getAsLiveData();
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveUIData(UIData uiData) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                uiDataDao.insertOrReplaceUIData(uiData);
                return null;
            }
        }.execute();
    }




    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void savePrefRecord(PrefRecord record) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                prefRecordDao.insertOrReplacePrefRecord(record);
                return null;
            }
        }.execute();


    }








    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveWeightRecord(WeightRecord record) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                weightRecordDao.insertOrReplaceWeightRecord(record);
                return null;
            }
        }.execute();
    }


    // ====================================================================================


    public Object getPref(String name) {
        return prefManager.getPref(name);
    }

    public void setPref(String name, Object value) {
        prefManager.setPref(name, value);
    }





    public LiveData<PrefRecord> loadPrefRecordLiveData(String name) {

        PrefRecord defaultPrefRecord = new PrefRecord();
        defaultPrefRecord.name = name;
        defaultPrefRecord.setValue("");

        return new DatabaseResource<PrefRecord>(defaultPrefRecord) {
            @NonNull
            @Override
            protected LiveData<PrefRecord> loadFromDb() {
                return prefRecordDao.getPrefRecord(name);
            }
        }.getAsLiveData();

    }


    public LiveData<PrefsData> loadPrefsLiveData() {
        return null;
    }



    public PreferenceInstance getPreferenceInstance(String name) {
        LiveData<PrefRecord> userNamePrefRecord;
        userNamePrefRecord = this.loadPrefRecordLiveData(name);

        return new PreferenceInstance<>(this, prefManager.prefByName.get(name), userNamePrefRecord);
    }






























}
