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
    /* THIS IS GOOD
    @Query("select ActiviteCategory.id, ActiviteCategory.name, ActiviteData.intensite " +
            "from ActiviteCategory " +
            "left join ActiviteData on ActiviteCategory.id = ActiviteData.categoryId")
    LiveData<List<ActiviteCategory>> getAllCategories();
    */

    /**
     * PROPER WAY TO HANDLE THE DATE (appart from NOW being hard coded)
     */
    // Join the 2 tables and add the total for each category
    @Query("select ActiviteCategory.id, ActiviteCategory.name, sum(ActiviteTemp.intensite) as intensite " +
            "from ActiviteCategory " +
            "left join (" +
            "select * from ActiviteData where ActiviteData.date = 'NOW' ) as ActiviteTemp on ActiviteCategory.id = ActiviteTemp.categoryId " +
            "group by ActiviteCategory.id")
    LiveData<List<ActiviteCategory>> getAllCategories();

    /*
    // Join the 2 tables and add the total for each category
    @Query("select ActiviteCategory.id, ActiviteCategory.name, sum(ActiviteData.intensite) as intensite " +
            "from ActiviteCategory " +
            "left join ActiviteData on ActiviteCategory.id = ActiviteData.categoryId " +
            "group by ActiviteCategory.id")
    LiveData<List<ActiviteCategory>> getAllCategories();
    */

    @Query("select * from ActiviteCategory where id == :id limit 1")
    LiveData<ActiviteCategory> getCategory(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceActiviteData(ActiviteCategory activiteCategory);
}
