package com.strudelauxpommes.androidcomponents.demo;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.MainThread;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;

/**
 * Application class used as a singleton to create the Data layer classes (Repository and Database)
 *
 * Created by Marc-Antoine Sauvé on 11/11/17.
 */
public class DemoApplication extends Application {

    public static DemoApplication application;

    private AppDatabase database;
    private UIDataRepository uiDataRepository;
    private ActiviteDataRepository activiteDataRepository;

    @MainThread
    public AppDatabase getDatabase() {
        if (database == null) {
            database = Room.databaseBuilder(this, AppDatabase.class, "demo-database").fallbackToDestructiveMigration().build();
        }
        return database;
    }

    @MainThread
    public UIDataRepository getUIDataRepository() {
        if (uiDataRepository == null) {
            uiDataRepository = new UIDataRepository(getDatabase().userDao(), getDatabase().weightDao(), getDatabase().prefRecordDao());
        }
        return uiDataRepository;
    }

    @MainThread
    public ActiviteDataRepository getActiviteDataRepository() {
        if (activiteDataRepository == null) {
            activiteDataRepository = new ActiviteDataRepository(getDatabase().activiteDAO(), getDatabase().activiteCategoryDAO());
        }
        return activiteDataRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DemoApplication.application = this;

    }

}
