package com.strudelauxpommes.androidcomponents.demo.view_team;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;

import com.strudelauxpommes.androidcomponents.demo.R;

public class MainActivity extends AppCompatActivity {

    private FormViewModel viewModel;
    Button blueButton;
    Button orangeButton;
    Button purpleButton;
    View container;
    Toolbar toolbar;
    NumberPicker buttonTextSizePicker;

    Button weightButton;
    Button alcoolButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReferences();

        setSupportActionBar(toolbar);

        // Step 2: Initialize the views if needed. This initialization should be data independant.
        // Initialize spinner
        buttonTextSizePicker.setMinValue(FormViewModel.minFontSize);
        buttonTextSizePicker.setMaxValue(FormViewModel.maxFontSize);

        // Step 3: Get and initialize the ViewModel for this View with the data repository
        viewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        viewModel.init(DemoApplication.application.getUIDataRepository());

        // Step 4: Bind the ViewModel values to the UI
        // Register to the changes of the models to update the UI automatically when needed

        // When the backgroundColor change, we should change the background color of our container
        viewModel.getBackgroundColor().observe(this, backgroundColor -> {
            if (backgroundColor != null) {
                // Get the color value from the color resource
                @ColorInt int color = ContextCompat.getColor(this, backgroundColor.getColor());
                container.setBackgroundColor(color);
            }
        });

        // When the fontSize change, we should change the font size of our 3 buttons and make sure
        // that our NumberPicker show the right value.
        viewModel.getFontSize().observe(this, fontSize -> {
            if (fontSize != null) {
                blueButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
                orangeButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
                purpleButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
                buttonTextSizePicker.setValue(fontSize);
            }
        });

        bindButtons();

    }

    void initReferences() {
        blueButton = findViewById(R.id.blueButton);
        orangeButton = findViewById(R.id.orangeButton);
        purpleButton = findViewById(R.id.purpleButton);
        container = findViewById(R.id.container);
        toolbar = findViewById(R.id.toolbar);

        alcoolButton = findViewById(R.id.mainAlcoolButtonId);
        weightButton = findViewById(R.id.mainWeightButton);

        buttonTextSizePicker = findViewById(R.id.buttonTextSizePicker);
    }

    void bindButtons() {

        // Step 5: Bind the UI events to the ViewModel
        // Initialize the actions of the UI. These actions should only modify the viewModel.
        // The viewModel contains the logic for the update and the view will be refreshed automatically.
        blueButton.setOnClickListener(button -> viewModel.setBackgroundColor(FormViewModel.BackgroundColor.blue));
        orangeButton.setOnClickListener(button -> viewModel.setBackgroundColor(FormViewModel.BackgroundColor.orange));
        purpleButton.setOnClickListener(button -> viewModel.setBackgroundColor(FormViewModel.BackgroundColor.purple));
        buttonTextSizePicker.setOnValueChangedListener((numberPicker, oldFontSize, newFontSize) -> viewModel.setFontSize(newFontSize));



        weightButton.setOnClickListener(button -> viewModel.onWeightButton(button));
        alcoolButton.setOnClickListener(button -> viewModel.onAlcoolButton(button));




    }








}
