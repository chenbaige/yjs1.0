package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.yjtc.cbg.yjsapp.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2016/5/5/005.
 */
@ContentView(R.layout.guide_login)
public class GuideLogin extends BaseActivity {

    @ViewInject(R.id.id_register)
    private Button mRegister;
    @ViewInject(R.id.id_login)
    private Button mLogin;


    @Event(value =R.id.id_login )
    private void login(View view){
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    @Event(value =R.id.id_register )
    private void register(View view){
        Intent intent=new Intent(this, MessageAuthenticationActivity.class);
        intent.putExtra("Flag", LoginActivity.NEW_USER_REGISTER);
        startActivity(intent);
        finish();
    }

    @Override
    void initData() {

    }
}
