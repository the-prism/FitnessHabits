package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.ActiviteData;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.UIData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

public class ActiviteDataRepository {
    private ActiviteDAO activiteDAO;

    public ActiviteDataRepository(ActiviteDAO activiteDAO){
        this.activiteDAO = activiteDAO;
    }

    public LiveData<List<ActiviteData>> loadActiviteData() {
        ActiviteData defaultActiviteData = new ActiviteData();
        LocalDateTime date = LocalDateTime.now();
        defaultActiviteData.setDate(LocalDateTime.of(date.getYear(),date.getMonth(),date.getDayOfMonth(),0,0));
        defaultActiviteData.setActivite("Rien");
        defaultActiviteData.setIntensite(1);
        ArrayList<ActiviteData> list = new ArrayList<ActiviteData>();
        list.add(defaultActiviteData);
        return new DatabaseResource<List<ActiviteData>>(list) {
            @NonNull
            @Override
            protected LiveData<List<ActiviteData>> loadFromDb(){
                return activiteDAO.getActivite();
            }
        }.getAsLiveData();
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveUIData(ActiviteData uiData) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                activiteDAO.insertOrReplaceUIData(uiData);
                return null;
            }
        }.execute();
    }
}
