package com.strudelauxpommes.androidcomponents.demo.data_team.pref;


import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePreference extends BaseModelObject {

    PreferenceManager manager;

    void initPreference(PreferenceManager manager) {
        // pour ne pas avoir à écrire un constructeur pour chaque préférence,
        // car les constructeurs ne sont pas héritable. va chier java.
        this.manager = manager;
    }

    public static List<BasePreference> getAllInstances() {
        return new ArrayList<BasePreference>(Arrays.asList(
                new BasePreference.PrefUserName(),
                new BasePreference.PrefUserWeight(),
                new BasePreference.PrefUserBirthDate(),
                new BasePreference.PrefUserGender(),
                new BasePreference.PrefHeightUnit(),
                new BasePreference.PrefWeightUnit(),
                new BasePreference.PrefAutoDateIncrementTime()
        ));
    }

    public Object getValue() {
        return "myvalue";
    }


    public void setValue(Object value) {

    }

    public abstract String name();



    // =======================================================



    public static class PrefUserName extends BasePreference {

        public String name() {
            return "pref.user.name";
        }

    }

    public static class PrefUserWeight extends BasePreference {

        public String name() {
            return "pref.user.weight";
        }

    }

    public static class PrefUserBirthDate extends BasePreference {

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









}




