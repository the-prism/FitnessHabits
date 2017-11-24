package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteCategory;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteCategoryDAO;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteData;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteDataDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

public class ActiviteDataRepository {
    LiveData<List<ActiviteData>> activitesData;
    LiveData<List<ActiviteCategory>> activiteCategory;
    private ActiviteDataDAO activiteDataDAO;
    private ActiviteCategoryDAO activiteCategoryDAO;

    public ActiviteDataRepository(ActiviteDataDAO activiteDataDAO, ActiviteCategoryDAO activiteCategoryDAO) {
        this.activiteDataDAO = activiteDataDAO;
        this.activiteCategoryDAO = activiteCategoryDAO;
    }

    public LiveData<List<ActiviteData>> loadActiviteData() {
        if (activitesData == null) {
            ActiviteData defaultActiviteData = new ActiviteData();
            defaultActiviteData.setDate("Fuckoff");
            defaultActiviteData.setActivite("Fuck");
            defaultActiviteData.setIntensite(1);
            List<ActiviteData> list = new ArrayList<ActiviteData>();
            list.add(defaultActiviteData);
            activitesData = new DatabaseResource<List<ActiviteData>>(list) {
                @NonNull
                @Override
                protected LiveData<List<ActiviteData>> loadFromDb() {
                    return activiteDataDAO.getAllActivite();
                }
            }.getAsLiveData();
        }
        return activitesData;
    }

    public LiveData<List<ActiviteCategory>> loadCategories() {
        if (activiteCategory == null) {
            ActiviteCategory defaultCategory = new ActiviteCategory();
            defaultCategory.setName("Tester");
            List<ActiviteCategory> list = new ArrayList<ActiviteCategory>();
            list.add(defaultCategory);
            activiteCategory = new DatabaseResource<List<ActiviteCategory>>(list) {
                @NonNull
                @Override
                protected LiveData<List<ActiviteCategory>> loadFromDb() {
                    return activiteCategoryDAO.getAllCategories();
                }
            }.getAsLiveData();
        }
        return activiteCategory;
    }

    public LiveData<ActiviteData> debugLoadCategories(String date, int id) {
        return activiteDataDAO.getTodayDetails(date, id);
    }

    public LiveData<ActiviteCategory> getCategory(int id) {
        return activiteCategoryDAO.getCategory(id);
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    public void saveActiviteData(ActiviteData activite) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                System.out.println("Insert new DATA                   !");
                activiteDataDAO.insertOrReplaceActiviteData(activite);
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
                activiteCategoryDAO.insertOrReplaceActiviteData(category);
                return null;
            }
        }.execute();
    }
}
