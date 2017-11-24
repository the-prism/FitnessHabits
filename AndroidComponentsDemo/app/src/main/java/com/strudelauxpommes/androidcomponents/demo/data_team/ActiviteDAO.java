package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.ActiviteData;

import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

@Dao
public interface ActiviteDAO {
    @Query("SELECT * FROM ActiviteData")
    LiveData<List<ActiviteData>> getActivite();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceUIData(ActiviteData activiteData);
}
