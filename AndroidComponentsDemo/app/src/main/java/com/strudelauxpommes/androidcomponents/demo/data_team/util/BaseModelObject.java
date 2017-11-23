package com.strudelauxpommes.androidcomponents.demo.data_team.util;


import android.util.Log;

public class BaseModelObject {


    public void assertThat(boolean condition) {
        if(!condition) {
            throw new RuntimeException("assertion error");
        }
    }

    public void print(String message) {
        Log.d("print", message);
    }
}
