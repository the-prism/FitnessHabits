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

    void onSaveButton() {
        float weight = Float.parseFloat(weightInput.getText().toString());
        viewModel.saveWeight(weight);
    }


    void initReferences() {
        weightInput = findViewById(R.id.weightInputId);
        saveButton = findViewById(R.id.weightSaveButtonId);


        viewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        viewModel.init(DemoApplication.application.getUIDataRepository());


        saveButton.setOnClickListener(button -> onSaveButton());


        // je crois que c'est mieux de ne pas stocker en temps réel...
        weightInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

    }





}
