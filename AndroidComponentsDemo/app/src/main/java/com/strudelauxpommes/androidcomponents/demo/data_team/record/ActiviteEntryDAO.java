package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

@Dao
public interface ActiviteEntryDAO {
    @Query("SELECT * FROM ActiviteEntry WHERE date == :date")
    LiveData<List<ActiviteEntry>> getActivite(String date);

    @Query("select ActiviteEntry.*, ActiviteCategory.name as activite FROM ActiviteEntry LEFT JOIN ActiviteCategory ON ActiviteEntry.categoryId = ActiviteCategory.id")
    LiveData<List<ActiviteEntry>> getAllActivite();

    @Query("select * from ActiviteEntry where date == :date and categoryId == :id")
    LiveData<ActiviteEntry> getTodayDetails(String date, int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceActiviteData(ActiviteEntry activiteEntry);
}
