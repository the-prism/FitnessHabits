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

    EditText nameText;
    Button nameButSave;
    public PrefsViewModel viewModel;
    TextView textShowName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        initReferences();
    }


    void initReferences() {
        nameText = findViewById(R.id.prefNameTextId);
        nameButSave = findViewById(R.id.prefNameSaveButId);

        viewModel = ViewModelProviders.of(this).get(PrefsViewModel.class);
        viewModel.init(DemoApplication.application.getUIDataRepository());

        textShowName = findViewById(R.id.showNameTextId);

        nameButSave.setOnClickListener(button -> onNameSave());

        viewModel.getUserName().observe(this, name -> textShowName.setText(name));
        viewModel.getUserName().observe(this, name -> nameText.setText(name));



    }
    void onNameSave() {

        String name = nameText.getText().toString();
        viewModel.setUserName(name);





    }



}
