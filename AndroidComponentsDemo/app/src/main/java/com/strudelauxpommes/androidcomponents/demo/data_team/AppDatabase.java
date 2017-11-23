package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.record.*;

/**
 * Define which entities should be stored in the database and define converters to transform some
 * data before storing it.
 *
 * Created by Marc-Antoine Sauvé on 11/11/17.
 */

@Database(entities = {UIData.class, ActiviteData.class, WeightRecord.class, PrefRecord.class}, version = 4)
@TypeConverters({BackgroundColorConverter.class, CalendarDateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UIDataDao userDao();
    public abstract ActiviteDAO activiteDAO();
    public abstract WeightRecordDao weightDao();
    public abstract PrefRecordDao prefRecordDao();
}
