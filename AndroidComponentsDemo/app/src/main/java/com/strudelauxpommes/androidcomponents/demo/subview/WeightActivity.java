package com.strudelauxpommes.androidcomponents.demo.com.strudelauxpommes.androidcomponents.demo.subview;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.strudelauxpommes.androidcomponents.demo.R;

public class WeightActivity extends BaseSubActivity {

    EditText weightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        initReferences();
    }



    void initReferences() {
        weightInput = findViewById(R.id.weightInputId);


        weightInput.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.d("foo", "bar");

                // you can call or do what you want with your EditText here
                //yourEditText. ...

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

    }





}
