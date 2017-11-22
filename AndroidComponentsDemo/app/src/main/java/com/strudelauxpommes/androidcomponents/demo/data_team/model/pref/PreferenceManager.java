package com.strudelauxpommes.androidcomponents.demo.data_team.model.pref;


import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PreferenceManager extends BaseModelObject {

    List<BasePreference> prefs;
    Map<String, BasePreference> prefByName;

    public PreferenceManager() {
        initAllInstances();
    }

    void initAllInstances() {
        assertThat(prefs == null);
        assertThat(prefByName == null);
        List<BasePreference> instances = BasePreference.getAllInstances();
        Map<String, BasePreference> mapping = new HashMap<>();
        for(BasePreference instance: instances) {
            instance.initPreference(this);
            mapping.put(instance.name(), instance);
        }
        this.prefs = instances;
        this.prefByName = mapping;
    }

    public Object getPref(String name) {
        return prefByName.get(name).getValue();
    }


    public void setPref(String name, Object value) {
        prefByName.get(name).setValue(value);
    }


}
