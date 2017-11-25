package com.strudelauxpommes.androidcomponents.demo.data_team.repository;


import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



import java.util.ArrayList;
import java.util.List;

public class DrinkRepository extends BaseRepository {

    LiveData<List<DrinkKindRecord>> drinkKindRecords;
    public DrinkKindRecordDao drinkKindRecordDao;
    AlcoolRecordDao alcoolRecordDao;
    public GeneralCategory topic;

    public DrinkRepository(DrinkKindRecordDao drinkKindRecordDao, AlcoolRecordDao alcoolRecordDao) {
        this.drinkKindRecordDao = drinkKindRecordDao;
        this.alcoolRecordDao = alcoolRecordDao;

        this.topic = new GeneralCategory.Alcool();
    }

    public LiveData<DrinkKind>
            getDrinkKindRecords XXXXX

    public LiveData<List<DrinkKindRecord>> loadDrinkKindRecords() {


        if (drinkKindRecords == null) {

            // default data
            // DrinkKindRecord defaultValue = new DrinkKindRecord();
            List<DrinkKindRecord> defaultValue = new ArrayList<>();

            drinkKindRecords = new DatabaseResource<List<DrinkKindRecord>>(defaultValue) {
                @NonNull
                @Override
                protected LiveData<List<DrinkKindRecord>> loadFromDb() {
                    return drinkKindRecordDao.getDrinkKindRecords(topic);
                }
            }.getAsLiveData();

        }

        return drinkKindRecords;
    }


    public DrinkKindEntry newDrinkKindEntry() {
        DrinkKindRecord record = new DrinkKindRecord();
        record.topic = topic;
        return new DrinkKindEntry(this, record );
    }



}















