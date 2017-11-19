package com.strudelauxpommes.androidcomponents.demo.data_team;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.ActiviteData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 2017-11-19.
 */

public class ActiviteDataRepository {
    private ActiviteDAO activiteDAO;

    public ActiviteDataRepository(ActiviteDAO activiteDAO){
        this.activiteDAO = activiteDAO;
    }

    public LiveData<List<ActiviteData>> loadActiviteData() {
        ActiviteData defaultActiviteData = new ActiviteData();
        Date temp = new Date();
        defaultActiviteData.setDate(new Date(temp.getYear(),temp.getMonth(),temp.getDay()));
        defaultActiviteData.setActivite("Rien");
        defaultActiviteData.setIntensite(1);
        ArrayList<ActiviteData> list = new ArrayList<ActiviteData>();
        list.add(defaultActiviteData);
        return new DatabaseResource<List<ActiviteData>>(list) {
            @NonNull
            @Override
            protected LiveData<List<ActiviteData>> loadFromDb(){
                return activiteDAO.getActivite(new Date().getTime());
            }
        }.getAsLiveData();
    }
}
