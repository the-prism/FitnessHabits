package com.strudelauxpommes.androidcomponents.demo.view_team;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.strudelauxpommes.androidcomponents.demo.data_team.ActiviteDataRepository;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteCategory;
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
    LiveData<List<String>> listCategory;

    private LiveData<List<ActiviteData>> activiteList;
    private LiveData<List<ActiviteCategory>> activiteCategory;

    public void init(ActiviteDataRepository repository) {
        this.repository = repository;
        activiteList = this.repository.loadActiviteData();
        activiteCategory = this.repository.loadCategories();
        subscribeToDbChanges();
    }

    private void subscribeToDbChanges() {

        listCategory = Transformations.map(activiteCategory,
                new Function<List<ActiviteCategory>, List<String>>() {
                    @Override
                    public List<String> apply(List<ActiviteCategory> listOfActivities) {
                        ArrayList<String> list = new ArrayList<>();
                        for (ActiviteCategory act : listOfActivities) {
                            list.add(act.getName());
                        }
                        return list;
                    }
                });
        // Instead of exposing the list of Loans, we can apply a transformation and expose Strings.
        listActi = Transformations.map(activiteList,
                new Function<List<ActiviteData>, List<String>>() {
                    @Override
                    public List<String> apply(List<ActiviteData> listOfActivities) {
                        ArrayList<String> list = new ArrayList<>();
                        for (ActiviteData act : listOfActivities) {
                            list.add(act.getDate() + "  " + act.getActivite() + " " + act.getCategoryId());
                        }
                        return list;
                    }
                });
    }

    private String getCategory(int id){
        System.out.println("ARE YOU EVEN CALLED???????????????????????????");
        List<ActiviteCategory> test = activiteCategory.getValue();
        return "";
    }

    public LiveData<List<ActiviteData>> getAllActiviteData() {
        return activiteList;
    }

    public LiveData<List<String>> getListOfActivites() {
        return listActi;
    }

    public LiveData<List<String>> getListOfCategories() {
        return listCategory;
    }

    public void insertItem(ActiviteData activite) {
        repository.saveActiviteData(activite);
    }

    public void createDb() {
        ActiviteCategory cat1 = new ActiviteCategory();
        cat1.setName("Test1");
        cat1.setId(1);// So we dont create more each run
        repository.saveActiviteCategory(cat1);
        ActiviteCategory cat2 = new ActiviteCategory();
        cat2.setName("Test2");
        cat2.setId(2); // So we dont create more each run
        repository.saveActiviteCategory(cat2);
        ActiviteData test = new ActiviteData();
        test.setDate("Say my name");
        test.setActivite("BOB");
        test.setIntensite(10);
        test.setCategoryId(2);
        repository.saveActiviteData(test);
        ActiviteData test2 = new ActiviteData();
        test2.setDate("And you ???");
        test2.setActivite("BOB");
        test2.setIntensite(10);
        test2.setCategoryId(1);
        repository.saveActiviteData(test2);
    }
}
