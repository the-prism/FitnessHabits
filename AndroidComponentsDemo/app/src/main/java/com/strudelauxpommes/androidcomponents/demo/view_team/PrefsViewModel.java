package com.strudelauxpommes.androidcomponents.demo.view_team;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;


public class PrefsViewModel extends ViewModel {

    UIDataRepository repository;

    public void init(UIDataRepository repository) {
        this.repository = repository;
    }

    public PreferenceInstance<String> userName() {
        return this.repository.getPreferenceInstance("pref.user.name");
    }

    public PreferenceInstance<Float> userHeight() {
        return this.repository.getPreferenceInstance("pref.user.height");
    }

    public PreferenceInstance<CalendarDate> userBirthDate() {
        return this.repository.getPreferenceInstance("pref.user.birth_date");
    }

    public PreferenceInstance<Gender> userGender() {
        return this.repository.getPreferenceInstance("pref.user.gender");
    }


}
