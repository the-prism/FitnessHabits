package com.strudelauxpommes.androidcomponents.demo.subview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteCategory;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteData;
import com.strudelauxpommes.androidcomponents.demo.view_team.ActiviteViewModel;

/**
 * Created by Thomas on 2017-11-24.
 */

public class ActiviteActivity extends BaseSubActivity {

    ListView listView;
    Button newItem;
    EditText categoryId;
    EditText amount;
    EditText date;

    ActiviteViewModel viewModel;
    LiveData<String> listActi;
    String[] values = new String[]{"BOB"};
    ArrayAdapter<String> adapter;

    LiveData<String> getListOfActivites() {
        return listActi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activites);
        initReferences();
    }


    void initReferences() {
        viewModel = ViewModelProviders.of(this).get(ActiviteViewModel.class);
        viewModel.init(DemoApplication.application.getActiviteDataRepository());
        listView = findViewById(R.id.alcoolListViewId);
        newItem = findViewById(R.id.newActivityButton);
        categoryId = findViewById(R.id.categoryId);
        amount = findViewById(R.id.amount);
        date = findViewById(R.id.date);

        newItem.setOnClickListener(view -> {
            ActiviteData fromUI = new ActiviteData();
            int id = Integer.parseInt(categoryId.getText().toString());
            int inten = Integer.parseInt(amount.getText().toString());
            fromUI.setCategoryId(id);
            fromUI.setDate(date.getText().toString());
            fromUI.setIntensite(inten);
            viewModel.insertItem(fromUI);
        });

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setSelector(android.R.color.holo_blue_light);

        // https://stackoverflow.com/questions/16189651/android-listview-selected-item-stay-highlighted
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                view.setSelected(true);
                ActiviteData newObjt = new ActiviteData();
                newObjt.setCategoryId(2);
                newObjt.setDate("TODAY");
                newObjt.setIntensite(2);
                viewModel.insertItem(newObjt);
                ActiviteCategory mewCat = new ActiviteCategory();
                mewCat.setId(3); //For tests, else we get a new 1 each time (desired behaviour from ui)
                mewCat.setName("Test 3");
                viewModel.insertNewCategory(mewCat);
            }
        });

        populateDb();

        subscribeUiLoans();
    }

    private void subscribeUiLoans() {
        viewModel.getListOfCategories().observe(this, fruitlist -> {
            // update UI
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist);
            // Assign adapter to ListView
            listView.setAdapter(adapter);
        });
    }

    private void populateDb() {
        viewModel.createDb();
    }
}
