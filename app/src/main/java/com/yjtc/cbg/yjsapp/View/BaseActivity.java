package com.yjtc.cbg.yjsapp.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yjtc.cbg.yjsapp.app.MyApplication;
import com.yjtc.cbg.yjsapp.bean.User;

import org.xutils.x;

/**
 * Created by chenboge on 16/4/29.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
    }

    abstract void initData();


    public void startActivity(Intent intent,boolean isNeedLogin){


        if(isNeedLogin){

            User user = MyApplication.getInstanse().getUser();
            if(user !=null){
                super.startActivity(intent);
            }
            else{
                MyApplication.getInstanse().putIntent(intent);
                Intent loginIntent = new Intent(this, LoginActivity.class);
                super.startActivity(loginIntent);
            }

        }
        else{
            super.startActivity(intent);
        }

    }
}