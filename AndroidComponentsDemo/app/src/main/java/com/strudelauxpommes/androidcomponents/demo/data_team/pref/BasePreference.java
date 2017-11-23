package com.strudelauxpommes.androidcomponents.demo.data_team.pref;


import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePreference extends BaseModelObject {

    PreferenceManager manager;
    PreferenceInstance prefInstance = null;

    void initPreference(PreferenceManager manager) {
        // pour ne pas avoir à écrire un constructeur pour chaque préférence,
        // car les constructeurs ne sont pas héritable. va chier java.
        this.manager = manager;
    }

    public static List<BasePreference> getAllInstances() {
        return new ArrayList<BasePreference>(Arrays.asList(
                new BasePreference.PrefUserName(),
                new BasePreference.PrefUserHeight(),
                new BasePreference.PrefUserBirthDate(),
                new BasePreference.PrefUserGender(),
                new BasePreference.PrefHeightUnit(),
                new BasePreference.PrefWeightUnit(),
                new BasePreference.PrefAutoDateIncrementTime(),
                new BasePreference.PrefCurrentViewDate()
        ));
    }

    public Object getValue() {
        return "myvalue";
    }


    public void setValue(Object value) {

    }

    public abstract String name(); // todo: peut-être utiliser un enum pour stocker le nom.
    // public abstract Object parseFromString(String value);

    public Object parseFromString(String string) {
       return string;
    }

    public String encodeToString(Object value) {
        return value.toString();
    }

    public Object getDefaultValue() {
        assertThat(false);
        return null;
    }

    public PreferenceInstance getPreferenceInstance() {
        if(prefInstance == null) {
            LiveData<PrefRecord> userNamePrefRecord;
            userNamePrefRecord = this.loadPrefRecordLiveData(name());
            prefInstance = new PreferenceInstance<>(manager.repository, this, userNamePrefRecord);
        }
        return prefInstance;
    }


    public LiveData<PrefRecord> loadPrefRecordLiveData(String name) {

        PrefRecord defaultPrefRecord = new PrefRecord();
        defaultPrefRecord.name = name;
        defaultPrefRecord.setValue(null);

        return new DatabaseResource<PrefRecord>(defaultPrefRecord) {
            @NonNull
            @Override
            protected LiveData<PrefRecord> loadFromDb() {
                return manager.repository.prefRecordDao.getPrefRecord(name);
            }
        }.getAsLiveData();

    }


    // =======================================================
    // =======================================================
    // =======================================================

    public static class PrefUserName extends BasePreference {

        public String name() {
            return "pref.user.name";
        }

        public String parseFromString(String string) {
            return string;
        }

        @Override
        public Object getDefaultValue() {
            return "";
        }

    }

    public static class PrefUserHeight extends BasePreference {

        public String name() {
            return "pref.user.height";
        }

        public Object parseFromString(String value) {
            if(value.equals("")) {
                return 0F;
            }
            return Float.parseFloat(value);
        }

        @Override
        public Object getDefaultValue() {
            return 0F;
        }

    }

    public static class PrefUserBirthDate extends BasePreference {

        @Override
        public String name() {
            return "pref.user.birth_date";
        }



    }

    public static class PrefUserGender extends BasePreference {

        public String name() {
            return "pref.user.gender";
        }

    }

    public static class PrefHeightUnit extends BasePreference {

        public String name() {
            return "pref.height.unit";
        }

    }

    public static class PrefWeightUnit extends BasePreference {

        public String name() {
            return "pref.weight.unit";
        }

    }


    public static class PrefAutoDateIncrementTime extends BasePreference {

        public String name() {
            return "pref.auto_date_increment_time";
        }

    }



    public static class PrefCurrentViewDate extends BasePreference {

        public String name() {
            return "pref.tmp.current_view_date";
        }

        @Override
        public Object parseFromString(String value) {
            return CalendarDate.fromDatabaseString(value);
        }

        @Override
        public String encodeToString(Object date) {
            return ((CalendarDate)date).toDatabaseString();
        }

        @Override
        public Object getDefaultValue() {
            return CalendarDate.now();
        }

    }



























}




