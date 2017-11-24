package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


@Dao
public interface WeightRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceWeightRecord(WeightRecord record);

    @Query("SELECT * FROM WeightRecord WHERE date == :date LIMIT 1")
    LiveData<WeightRecord> searchWeightRecord(CalendarDate date);

}
