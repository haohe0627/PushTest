package com.djzz.app.pushtest;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by d on 2017/9/13.
 */

public class BaseActivity extends AppCompatActivity {

    protected MyApplication getMyApp(){
        return (MyApplication) getApplication();
    }
}
