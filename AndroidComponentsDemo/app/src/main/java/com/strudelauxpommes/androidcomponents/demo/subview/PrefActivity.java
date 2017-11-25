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
import com.strudelauxpommes.androidcomponents.demo.data_team.model.SerializableToString;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.CalendarDate;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.Gender;
import com.strudelauxpommes.androidcomponents.demo.view_team.*;


public class PrefActivity extends BaseSubActivity {

    EditText nameInput;
    EditText heightInput;
    EditText birthDateInput;
    EditText genderInput;

    Button nameButSave;
    Button tailleButSave;
    Button birthDateSave;
    Button genderButton;

    public PrefsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        initEverything();
    }



    void initReferences() {
        nameInput = findViewById(R.id.prefNameTextId);
        heightInput = findViewById(R.id.prefTailleTextId);
        nameButSave = findViewById(R.id.prefNameSaveButId);
        tailleButSave = findViewById(R.id.prefHeightSaveButId);
        birthDateInput = findViewById(R.id.prefBirthDateTextId);
        birthDateSave = findViewById(R.id.prefBirthDateSaveButId);

        genderInput = findViewById(R.id.prefGenderTextId);
        genderButton = findViewById(R.id.prefGenderSaveButId);

        viewModel = ViewModelProviders.of(this).get(PrefsViewModel.class);
        viewModel.init(DemoApplication.application.getMainRepository());
    }

    @Override
    void initActivity() {
        viewModel.userName().liveData().observe(this, name -> nameButSave.setText(name));
        viewModel.userName().liveData().observe(this, name -> nameInput.setText(name));
        nameButSave.setOnClickListener(button -> viewModel.userName().setValue(nameInput.getText().toString()));

        viewModel.userHeight().liveData().observe(this, value -> tailleButSave.setText("" + value));
        viewModel.userHeight().liveData().observe(this, value -> heightInput.setText("" + value));
        tailleButSave.setOnClickListener(button -> viewModel.userHeight().setValue(Float.parseFloat(heightInput.getText().toString())));

        // pour le moment, seulement la date de naissance peut être null... (j'ai pas eu le temps d'implémenter les autres)
        viewModel.userBirthDate().liveData().observe(this, value -> birthDateSave.setText(encodeObjectOrNull(value)));
        viewModel.userBirthDate().liveData().observe(this, value -> birthDateInput.setText(encodeObjectOrNull(value)));
        birthDateSave.setOnClickListener(button -> viewModel.userBirthDate().setValue(getBirthDateFromString(birthDateInput.getText().toString())));

        viewModel.userGender().liveData().observe(this, value -> genderButton.setText(value.encodeToString()));
        viewModel.userGender().liveData().observe(this, value -> genderInput.setText(value.encodeToString()));
        genderButton.setOnClickListener(button -> viewModel.userGender().setValue(Gender.decodeFromString(genderInput.getText().toString())));

    }

    public String encodeObjectOrNull(SerializableToString object) {
        if(object == null) {
            return null;
        } else {
            return object.encodeToString();
        }
    }

    public CalendarDate getBirthDateFromString(String string) {
        if(string.length() == 0) {
            return null;
        } else {
            return CalendarDate.fromDatabaseString(string);
        }
    }











}
