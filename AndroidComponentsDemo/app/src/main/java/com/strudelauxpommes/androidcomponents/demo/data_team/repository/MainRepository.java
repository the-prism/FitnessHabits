package com.strudelauxpommes.androidcomponents.demo.data_team.repository;


import com.strudelauxpommes.androidcomponents.demo.data_team.AppDatabase;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.BaseModelObject;

public class MainRepository extends BaseModelObject {

    public AppDatabase database;
    public UIDataRepository uiDataRepo;
    public DrinkRepository alcoolRepo;

    public MainRepository(AppDatabase database) {
        this.database = database;

        this.uiDataRepo = new UIDataRepository(database.userDao(), database.weightDao(), database.prefRecordDao());
        this.alcoolRepo = new DrinkRepository(database.drinkKindDao(), database.alcoolDao());
    }


    public void onButton() {


        int sum = this.alcoolRepo.loadDrinkKindRecords().getValue().size();
        print("" + sum);

    }


}
