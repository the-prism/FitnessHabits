package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Thomas on 2017-11-24.
 */

@Dao
public interface ActiviteCategoryDAO {
    @Query("select * from ActiviteCategory")
    LiveData<List<ActiviteCategory>> getAllCategories();

    @Query("select * from ActiviteCategory where id == :id limit 1")
    LiveData<ActiviteCategory> getCategory(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceActiviteData(ActiviteCategory activiteCategory);
}
