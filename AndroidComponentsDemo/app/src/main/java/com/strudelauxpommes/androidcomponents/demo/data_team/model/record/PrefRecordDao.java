package com.strudelauxpommes.androidcomponents.demo.data_team.model.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;

import java.util.List;


@Dao
public interface PrefRecordDao {

    @Query("SELECT * FROM PrefRecord WHERE name == :key")
    LiveData<PrefRecord> getPrefRecord(String key);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplacePrefRecord(PrefRecord prefRecord);

}
