package com.strudelauxpommes.androidcomponents.demo.subview;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.view_team.*;


public class PrefActivity extends BaseSubActivity {

    EditText nameInput;
    EditText heightInput;
    Button nameButSave;
    Button tailleButSave;
    public PrefsViewModel viewModel;
    TextView textShowName;
    TextView textShowTaille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        initReferences();
    }



    void initReferences() {
        nameInput = findViewById(R.id.prefNameTextId);
        heightInput = findViewById(R.id.prefTailleTextId);
        nameButSave = findViewById(R.id.prefNameSaveButId);
        tailleButSave = findViewById(R.id.prefHeightSaveButId);

        viewModel = ViewModelProviders.of(this).get(PrefsViewModel.class);
        viewModel.init(DemoApplication.application.getUIDataRepository());

        textShowName = findViewById(R.id.showNameTextId);
        textShowTaille = findViewById(R.id.showTailleTextId);

        viewModel.userName().liveData().observe(this, name -> textShowName.setText(name));
        viewModel.userName().liveData().observe(this, name -> nameInput.setText(name));
        nameButSave.setOnClickListener(button -> viewModel.userName().setValue(nameInput.getText().toString()));

        viewModel.userHeight().liveData().observe(this, value -> textShowTaille.setText("" + value));
        viewModel.userHeight().liveData().observe(this, value -> heightInput.setText("" + value));
        tailleButSave.setOnClickListener(button -> viewModel.userHeight().setValue(Float.parseFloat(heightInput.getText().toString())));

    }



















}
