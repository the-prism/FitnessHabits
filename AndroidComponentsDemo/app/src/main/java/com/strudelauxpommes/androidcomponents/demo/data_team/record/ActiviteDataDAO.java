package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

@Dao
public interface ActiviteDataDAO {
    @Query("SELECT * FROM ActiviteData WHERE date == :date")
    LiveData<List<ActiviteData>> getActivite(String date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceActiviteDataData(ActiviteData activiteData);
}
