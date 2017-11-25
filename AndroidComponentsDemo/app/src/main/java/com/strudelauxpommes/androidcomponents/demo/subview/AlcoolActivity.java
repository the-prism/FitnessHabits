package com.strudelauxpommes.androidcomponents.demo.subview;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.DrinkKindEntry;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.DrinkKindRecord;
import com.strudelauxpommes.androidcomponents.demo.view_team.AlcoolViewModel;
import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;


public class AlcoolActivity extends BaseSubActivity {

    ListView listView;

    Button nameButton;
    Button starButton;
    Button quantityButton;
    Button newButton;

    AlcoolViewModel viewModel;

    TextView nameText;
    TextView starText;
    TextView quantityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool);
        initEverything();
    }

    void initReferences() {
        listView = findViewById(R.id.alcoolListViewId);

        nameButton = findViewById(R.id.alcoolNameButtonId);
        starButton = findViewById(R.id.alcoolStarButtonId);
        quantityButton = findViewById(R.id.alcoolQuantityButtonId);
        newButton = findViewById(R.id.alcoolNewButtonId);

        nameText     = findViewById(R.id.alcoolNameTextId);
        starText     = findViewById(R.id.alcoolStarTextId);
        quantityText = findViewById(R.id.alcoolQuantityTextId);

        viewModel = ViewModelProviders.of(this).get(AlcoolViewModel.class);
        viewModel.init(DemoApplication.application.getMainRepository());
    }



    @Override
    void initActivity() {

        nameButton.setOnClickListener(button -> onNameButton());
        starButton.setOnClickListener(button -> onStarButton());
        quantityButton.setOnClickListener(button -> onQuantityButton());
        newButton.setOnClickListener(button -> onNewButton());

        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
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


    }

    void onNameButton() {

    }

    void onStarButton() {

    }

    void onQuantityButton() {

    }



    void onNewButton() {
        DrinkKindEntry record = viewModel.mainRepo.alcoolRepo.newDrinkKindEntry();
        record.setName(nameText.getText().toString());
        record.save();
    }









}