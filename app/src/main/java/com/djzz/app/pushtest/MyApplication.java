package com.djzz.app.pushtest;

import android.app.Application;
import android.content.Context;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by d on 2017/9/13.
 */

public class MyApplication extends Application {

    private MainView mainView;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initPush();
    }

    private void initPush(){

        final PushAgent mPushAgent = PushAgent.getInstance(context);

        new Thread(new Runnable() {
            @Override
            public void run() {

                mPushAgent.register(new IUmengRegisterCallback() {
                    @Override
                    public void onSuccess(String s) {
                        mainView.showToken(s);
                    }

                    @Override
                    public void onFailure(String s, String s1) {
                        mainView.showError(s, s1);
                    }
                });
            }
        }).start();
    }

    public void setMainView(MainView mainView){
        this.mainView= mainView;
    }
}
