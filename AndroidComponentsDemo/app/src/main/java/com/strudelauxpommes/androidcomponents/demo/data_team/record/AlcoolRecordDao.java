package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;

import java.util.List;


@Dao
public interface AlcoolRecordDao {

    @Query("SELECT * FROM AlcoolRecord WHERE date == :date AND kind == :kind")
    LiveData<AlcoolRecord> getAlcoolRecord(CalendarDate date, int kind);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceAlcoolRecord(AlcoolRecord alcoolRecord);

}
