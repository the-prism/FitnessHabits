package com.strudelauxpommes.androidcomponents.demo.subview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.ActiviteData;
import com.strudelauxpommes.androidcomponents.demo.view_team.ActiviteViewModel;
import com.strudelauxpommes.androidcomponents.demo.view_team.PrefsViewModel;

import java.util.List;


public class AlcoolActivity extends BaseSubActivity {

    ListView listView;
    ActiviteViewModel viewModel;
    LiveData<String> listActi;
    String[] values = new String[] { "BOB" };
    ArrayAdapter<String> adapter;

    LiveData<String> getListOfActivites() {
        return listActi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool);
        initReferences();
    }


    void initReferences() {
        viewModel = ViewModelProviders.of(this).get(ActiviteViewModel.class);
        viewModel.init(DemoApplication.application.getActiviteDataRepository());
        listView = findViewById(R.id.alcoolListViewId);

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
            }
        });

        populateDb();

        subscribeUiLoans();
    }

    private void subscribeUiLoans() {
        viewModel.getListOfActivites().observe(this, fruitlist -> {
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
