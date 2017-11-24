package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

public class ActiviteDataRepository {
    private ActiviteDataDAO activiteDataDAO;
    LiveData<List<ActiviteData>> activitesData;

    public ActiviteDataRepository(ActiviteDataDAO activiteDataDAO){
        this.activiteDataDAO = activiteDataDAO;
    }

    public LiveData<List<ActiviteData>> loadActiviteData(String arg) {
        if (activitesData == null){
            ActiviteData defaultActiviteData = new ActiviteData();
            LocalDateTime date = LocalDateTime.now();
            defaultActiviteData.setDate("Fuckoff");
            defaultActiviteData.setActivite("Fuck");
            defaultActiviteData.setIntensite(1);
            List<ActiviteData> list = new ArrayList<ActiviteData>();
            list.add(defaultActiviteData);
            activitesData = new DatabaseResource<List<ActiviteData>>(list) {
                @NonNull
                @Override
                protected LiveData<List<ActiviteData>> loadFromDb(){
                    return activiteDataDAO.getActivite(arg);
                }
            }.getAsLiveData();
        }
        return activitesData;
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveUIData(ActiviteData activite) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                System.out.println("Insert new DATA                   !");
                activiteDataDAO.insertOrReplaceActiviteDataData(activite);
                return null;
            }
        }.execute();
    }
}
