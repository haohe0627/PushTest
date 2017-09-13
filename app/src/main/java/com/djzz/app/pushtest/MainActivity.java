package com.djzz.app.pushtest;

import android.os.Bundle;
import android.widget.TextView;

import com.umeng.message.PushAgent;

public class MainActivity extends BaseActivity implements MainView{

    private TextView main_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_txt = (TextView) findViewById(R.id.main_txt);

        getMyApp().setMainView(this);

        PushAgent.getInstance(getMyApp()).onAppStart();
    }

    @Override
    public void showToken(final String token) {
        runOnUiThread(new Runnable() {
        @Override
        public void run() {
            main_txt.setText(token);
        }
        });
    }

    @Override
    public void showError(final String s, final String s1) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                main_txt.setText(s+"  "+s1);
            }
        });
    }
}
