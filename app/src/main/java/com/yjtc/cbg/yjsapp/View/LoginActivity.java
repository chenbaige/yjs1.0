package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yjtc.cbg.yjsapp.Presenter.LoginPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.ILoginRegisterActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by chenboge on 16/4/29.
 */
@ContentView(R.layout.login)
public class LoginActivity extends BaseActivity implements ILoginRegisterActivity {

    public static final int FORGET_PASSWORD=1000;
    public static final int NEW_USER_REGISTER=1001;

    @ViewInject(R.id.id_login_loginbtn)
    private Button mLogin;

    private LoginPresenter mPresenter;

    @Override
    void initData() {
        mPresenter = new LoginPresenter(this, this);
    }


    //注解方法时必须要进行私有方法限定  private
    @Event(value = R.id.id_login_loginbtn, type = View.OnClickListener.class)
    private void login(View view) {
        Toast.makeText(this, "开始登录", Toast.LENGTH_SHORT).show();
        mPresenter.HnadleUserLogin(this);
    }

    //忘记密码
    @Event(value = R.id.id_tv_login_forget, type = View.OnClickListener.class)
    private void Forget_Password(View view) {
        Intent intent=new Intent(this, MessageAuthenticationActivity.class);
        intent.putExtra("Flag", FORGET_PASSWORD);
        startActivity(intent);
    }

    //新用户注册
    @Event(value = R.id.id_tv_login_register, type = View.OnClickListener.class)
    private void New_User_Register(View view) {
        Intent intent=new Intent(this, MessageAuthenticationActivity.class);
        intent.putExtra("Flag", NEW_USER_REGISTER);
        startActivity(intent);
    }
    @Override
    public void Success(String s) {
        startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
    }

    @Override
    public void Faild(String s) {

    }
}
