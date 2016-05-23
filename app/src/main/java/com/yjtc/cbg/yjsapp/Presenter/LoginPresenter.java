package com.yjtc.cbg.yjsapp.Presenter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.View.inter.ILoginRegisterActivity;
import com.yjtc.cbg.yjsapp.View.inter.IMessageAuth;
import com.yjtc.cbg.yjsapp.model.MessageAuthenticationModel;
import com.yjtc.cbg.yjsapp.model.inter.IMessageAuthentication;
import com.yjtc.cbg.yjsapp.model.inter.IUserLogin;
import com.yjtc.cbg.yjsapp.model.UserLoginAndRegister;

/**
 * Created by chenboge on 16/5/4.
 */
public class LoginPresenter {

    private IUserLogin mLogin =null;
    private ILoginRegisterActivity mLoginActivity;


    private IMessageAuthentication MessageAuthenModel =null;
    private IMessageAuth MessageAuthen;


    public LoginPresenter(IMessageAuth MessageAuthen, Context context) {
        this.MessageAuthen = MessageAuthen;
        MessageAuthenModel = new MessageAuthenticationModel(context);
    }

    public LoginPresenter(ILoginRegisterActivity mLoginActivity, Context context) {
        this.mLoginActivity = mLoginActivity;
        mLogin = new UserLoginAndRegister(context);
    }

    public void HnadleUserLogin(ILoginRegisterActivity loginInter){
        mLogin.Login(loginInter);
    }

    public void HnadleUserRegister(ILoginRegisterActivity RegisterInter){
        mLogin.Register(RegisterInter);
    }

    public void SendMessageAuth(String phone,IMessageAuth iMessageAuth){
        MessageAuthenModel.getMessageCode(phone,iMessageAuth);
    }

    public void DestroyMessage(){
        MessageAuthenModel.unRegisterMessage();
    }

    public void submitMessageAuth(String code,String phone,IMessageAuth iMessageAuth){
        MessageAuthenModel.submitMessageCode(code,phone,iMessageAuth);
    }
}
