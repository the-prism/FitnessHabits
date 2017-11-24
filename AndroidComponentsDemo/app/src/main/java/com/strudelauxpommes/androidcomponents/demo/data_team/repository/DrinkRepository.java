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
    DrinkKindRecordDao drinkKindRecordDao;
    AlcoolRecordDao alcoolRecordDao;
    GeneralCategory catAlcool;

    public DrinkRepository(DrinkKindRecordDao drinkKindRecordDao, AlcoolRecordDao alcoolRecordDao) {
        this.drinkKindRecordDao = drinkKindRecordDao;
        this.alcoolRecordDao = alcoolRecordDao;

        this.catAlcool = new GeneralCategory.Alcool();
    }


    public LiveData<List<DrinkKindRecord>> loadDrinkKindRecords() {


        if (drinkKindRecords == null) {

            // default data
            // DrinkKindRecord defaultValue = new DrinkKindRecord();
            List<DrinkKindRecord> defaultValue = new ArrayList<>();

            drinkKindRecords = new DatabaseResource<List<DrinkKindRecord>>(defaultValue) {
                @NonNull
                @Override
                protected LiveData<List<DrinkKindRecord>> loadFromDb() {
                    return drinkKindRecordDao.getDrinkKindRecords(catAlcool);
                }
            }.getAsLiveData();

        }

        return drinkKindRecords;
    }




}















