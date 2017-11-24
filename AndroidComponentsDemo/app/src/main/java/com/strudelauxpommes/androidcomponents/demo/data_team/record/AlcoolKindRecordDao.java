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
public interface AlcoolKindRecordDao {

    //@Query("SELECT * FROM AlcoolKindRecord WHERE date == :date AND kind == :kind")
    //List<AlcoolKindRecord> getAlcoolKindRecords();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceAlcoolKindRecord(AlcoolKindRecord alcoolKindRecord);

}
