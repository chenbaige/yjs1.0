package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.view.View;

import com.yjtc.cbg.yjsapp.Presenter.LoginPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.ILoginRegisterActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * Created by chenboge on 16/4/29.
 */
@ContentView(R.layout.register)
public class RegisterActivity extends BaseActivity implements ILoginRegisterActivity {

    private LoginPresenter mPresenter;

    @Override
    void initData() {
        mPresenter = new LoginPresenter(this,this);
    }

    //用户注册
    @Event(value = R.id.id_register)
    private void Register(View view){
        mPresenter.HnadleUserLogin(this);
    }

    //已有账号，直接登录
    @Event(value = R.id.id_has_acount_login)
    private void Has_Acount_Goto_Login(View view){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }

    @Override
    public void Success(String s) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }

    @Override
    public void Faild(String s) {

    }
}
