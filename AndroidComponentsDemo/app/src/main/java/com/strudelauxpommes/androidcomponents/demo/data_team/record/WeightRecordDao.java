package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;


@Dao
public interface WeightRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceWeightRecord(WeightRecord record);

}
