package com.yjtc.cbg.yjsapp.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.util.ManifestUtil;

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.smssdk.SMSSDK;

/**
 * Created by chenboge on 16/4/29.
 */
public class MyApplication extends Application {

    private User user;
    private volatile static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        SMSSDK.initSDK(this,  ManifestUtil.getMetaDataValue(this, "mob_sms_appKey"),  ManifestUtil.getMetaDataValue(this, "mob_sms_appSecrect"));
    }



    public User getUser() {
        return user;
    }

    public void clearUser() {
        this.user=null;
       // UserLocalData.clearUser(this);
        //UserLocalData.clearToken(this);
    }

    public void putUser(User user) {
        this.user = user;
       // UserLocalData.putUser(this, user);
        //UserLocalData.putToken(this, token);
    }

    public static synchronized MyApplication getInstanse() {
        if (mApplication == null) {
            synchronized (MyApplication.class) {
                if (mApplication == null) {
                    mApplication = new MyApplication();
                }
            }
        }
        return mApplication;
    }


    private Intent intent;
    public void putIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }

    public void jumpToIntent(Context context){
        context.startActivity(intent);
        this.intent = null;
    }
}
