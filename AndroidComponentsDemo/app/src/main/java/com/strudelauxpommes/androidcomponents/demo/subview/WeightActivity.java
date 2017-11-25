package com.strudelauxpommes.androidcomponents.demo.subview;



import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.view_team.*;





public class WeightActivity extends BaseSubActivity {

    EditText weightInput;
    EditText fatInput;
    Button saveWeightButton;
    Button saveFatButton;
    public FormViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        initEverything();
    }


    void initReferences() {
        viewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        viewModel.init(DemoApplication.application.getMainRepository());
    }

    @Override
    void initActivity() {

        // weight
        weightInput = findViewById(R.id.weightInputId);
        saveWeightButton = findViewById(R.id.weightSaveButtonId);
        saveWeightButton.setOnClickListener(button -> onSaveWeightButton());
        viewModel.weightForCurrentDate().liveData().observe(this, weight -> weightInput.setText(weight.toString()));

        // fat
        fatInput = findViewById(R.id.grasInputId);
        saveFatButton = findViewById(R.id.grasSaveButtonId);
        saveFatButton.setOnClickListener(button -> onSaveFatButton());
        viewModel.fatForCurrentDate().liveData().observe(this, fat -> fatInput.setText(fat.toString()));

    }

    void onSaveWeightButton() {
        float weight = Float.parseFloat(weightInput.getText().toString());
        viewModel.weightForCurrentDate().setValue(weight);
    }

    void onSaveFatButton() {
        float fat = Float.parseFloat(fatInput.getText().toString());
        viewModel.fatForCurrentDate().setValue(fat);
    }








}

