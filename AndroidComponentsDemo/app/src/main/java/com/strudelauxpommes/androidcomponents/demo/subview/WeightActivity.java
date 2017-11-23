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
    Button saveButton;
    public FormViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        initReferences();
    }


    void initReferences() {
        weightInput = findViewById(R.id.weightInputId);
        saveButton = findViewById(R.id.weightSaveButtonId);

        viewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        viewModel.init(DemoApplication.application.getUIDataRepository());

        saveButton.setOnClickListener(button -> onSaveButton());
        viewModel.weightForCurrentDate().liveData().observe(this, weight -> weightInput.setText(weight.toString()));

    }


    void onSaveButton() {
        float weight = Float.parseFloat(weightInput.getText().toString());
        viewModel.weightForCurrentDate().setValue(weight);
    }



























}

