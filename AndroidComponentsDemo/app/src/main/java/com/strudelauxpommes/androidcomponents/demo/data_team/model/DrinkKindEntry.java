package com.strudelauxpommes.androidcomponents.demo.data_team.model;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.annotation.MainThread;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


public class DrinkKindEntry extends BaseModelObject {

    DrinkRepository repo;
    DrinkKindRecord record;

    public DrinkKindEntry(DrinkRepository repo, DrinkKindRecord record) {
        this.repo = repo;
        this.record = record;
    }

    public void setName(String name) {
        this.record.name = name;
    }


    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void save() {

        //DrinkKindRecord record = new DrinkKindRecord();
        //record.name = name;
        //record.topic = repo.topic;

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                repo.drinkKindRecordDao.insertOrReplaceDrinkKindRecord(record);
                return null;
            }
        }.execute();

    }





}
