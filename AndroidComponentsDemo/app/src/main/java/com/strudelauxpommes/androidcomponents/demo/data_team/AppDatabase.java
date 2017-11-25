package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;

/**
 * Define which entities should be stored in the database and define converters to transform some
 * data before storing it.
 *
 * Created by Marc-Antoine Sauvé on 11/11/17.
 */

@Database(entities = {
        UIData.class,
        ActiviteEntry.class,
        WeightRecord.class,
        PrefRecord.class,
        ActiviteCategory.class,
        DrinkKindRecord.class,
        AlcoolRecord.class
}, version = 16)
@TypeConverters({
        BackgroundColorConverter.class,
        CalendarDateConverter.class,
        GeneralCategoryConverter.class
})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UIDataDao userDao();
    public abstract ActiviteEntryDAO activiteDAO();
    public abstract WeightRecordDao weightDao();
    public abstract PrefRecordDao prefRecordDao();
    public abstract ActiviteDatDAO activiteCategoryDAO();
    public abstract DrinkKindRecordDao drinkKindDao();
    public abstract AlcoolRecordDao alcoolDao();

}







