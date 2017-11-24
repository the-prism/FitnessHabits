package com.strudelauxpommes.androidcomponents.demo.view_team;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.strudelauxpommes.androidcomponents.demo.data_team.ActiviteDataRepository;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Thomas on 2017-11-24.
 */

public class ActiviteViewModel extends ViewModel {
    ActiviteDataRepository repository;

    LiveData<List<String>> listActi;

    private LiveData<List<ActiviteData>> activiteList;

    public void init(ActiviteDataRepository repository) {
        this.repository = repository;
        activiteList = this.repository.loadActiviteData();

        subscribeToDbChanges();
    }

    private void subscribeToDbChanges() {
        LiveData<List<ActiviteData>> loans
                = repository.loadActiviteData();

        // Instead of exposing the list of Loans, we can apply a transformation and expose Strings.
        listActi = Transformations.map(loans,
                new Function<List<ActiviteData>, List<String>>() {
                    @Override
                    public List<String> apply(List<ActiviteData> listOfActivities) {
                        ArrayList<String> list = new ArrayList<>();
                        for (ActiviteData act : listOfActivities) {
                            list.add(act.getActivite() + "  " + act.getDate() + " " + act.getIntensite());
                        }
                        return list;
                    }
                });
    }

    public LiveData<List<ActiviteData>> getAllActiviteData() {
        return activiteList;
    }

    public LiveData<List<String>> getListOfActivites() {
        return listActi;
    }

    public void insertItem(ActiviteData activite) {
        repository.saveActiviteData(activite);
    }

    public void createDb() {
        ActiviteData test = new ActiviteData();
        test.setDate("FU");
        test.setActivite("BOB");
        test.setIntensite(10);
        repository.saveActiviteData(test);
    }
}
