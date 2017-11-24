package com.strudelauxpommes.androidcomponents.demo.data_team.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteCategory;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteDatDAO;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteData;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteEntry;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteEntryDAO;
import com.strudelauxpommes.androidcomponents.demo.data_team.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

public class ActiviteDataRepository extends BaseRepository {
    LiveData<List<ActiviteEntry>> activitesData;
    LiveData<List<ActiviteData>> activiteCategory;
    private ActiviteEntryDAO activiteEntryDAO;
    private ActiviteDatDAO activiteDatDAO;

    public ActiviteDataRepository(ActiviteEntryDAO activiteEntryDAO, ActiviteDatDAO activiteDatDAO) {
        this.activiteEntryDAO = activiteEntryDAO;
        this.activiteDatDAO = activiteDatDAO;
    }

    public LiveData<List<ActiviteEntry>> loadActiviteData() {
        if (activitesData == null) {
            ActiviteEntry defaultActiviteEntry = new ActiviteEntry();
            defaultActiviteEntry.setDate("Fuckoff");
            defaultActiviteEntry.setIntensite(1);
            List<ActiviteEntry> list = new ArrayList<ActiviteEntry>();
            list.add(defaultActiviteEntry);
            activitesData = new DatabaseResource<List<ActiviteEntry>>(list) {
                @NonNull
                @Override
                protected LiveData<List<ActiviteEntry>> loadFromDb() {
                    return activiteEntryDAO.getAllActivite();
                }
            }.getAsLiveData();
        }
        return activitesData;
    }

    public LiveData<List<ActiviteData>> loadCategories() {
        if (activiteCategory == null) {
            ActiviteData defaultCategory = new ActiviteData();
            defaultCategory.setName("Tester");
            List<ActiviteData> list = new ArrayList<ActiviteData>();
            list.add(defaultCategory);
            activiteCategory = new DatabaseResource<List<ActiviteData>>(list) {
                @NonNull
                @Override
                protected LiveData<List<ActiviteData>> loadFromDb() {
                    return activiteDatDAO.getAllCategories();
                }
            }.getAsLiveData();
        }
        return activiteCategory;
    }

    public LiveData<ActiviteEntry> debugLoadCategories(String date, int id) {
        return activiteEntryDAO.getTodayDetails(date, id);
    }

    public LiveData<ActiviteCategory> getCategory(int id) {
        return activiteDatDAO.getCategory(id);
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveActiviteData(ActiviteEntry activite) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                System.out.println("Insert new DATA                   !");
                activiteEntryDAO.insertOrReplaceActiviteData(activite);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveActiviteCategory(ActiviteCategory category) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                System.out.println("Insert new DATA                   !");
                activiteDatDAO.insertOrReplaceActiviteData(category);
                return null;
            }
        }.execute();
    }
}
