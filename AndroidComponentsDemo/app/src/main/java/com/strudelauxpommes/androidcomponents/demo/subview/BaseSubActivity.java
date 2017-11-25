package com.strudelauxpommes.androidcomponents.demo.subview;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseSubActivity extends AppCompatActivity {

    void initEverything() {
        initReferences();
        initActivity();
    }

    abstract void initReferences();
    abstract void initActivity();

}
