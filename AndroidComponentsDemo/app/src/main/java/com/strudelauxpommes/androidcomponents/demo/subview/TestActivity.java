package com.strudelauxpommes.androidcomponents.demo.subview;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.strudelauxpommes.androidcomponents.demo.DemoApplication;
import com.strudelauxpommes.androidcomponents.demo.R;
import com.strudelauxpommes.androidcomponents.demo.subview.BaseSubActivity;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;
import com.strudelauxpommes.androidcomponents.demo.view_team.FormViewModel;


public class TestActivity extends BaseSubActivity {
    // une activité pour tester/expérimenter.

    Button button;
    TextView textView;
    public FormViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initEverything();
    }

    @Override
    public void initReferences() {
        button = findViewById(R.id.fooTestButtonId);
        textView = findViewById(R.id.fooTestTextEditId);
    }

    @Override
    public void initActivity() {

        viewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        viewModel.init(DemoApplication.application.getMainRepository());

        button.setOnClickListener(button -> onButton());

    }


    void onButton() {

        BaseModelObject.print("foo!");
        viewModel.mainRepo.onButton();

    }













}



















