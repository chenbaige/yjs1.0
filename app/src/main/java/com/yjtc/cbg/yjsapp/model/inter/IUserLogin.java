package com.yjtc.cbg.yjsapp.model.inter;

import com.yjtc.cbg.yjsapp.View.inter.ILoginRegisterActivity;

/**
 * Created by chenboge on 16/5/4.
 */
public interface IUserLogin {
    //用户注册
    void Register(ILoginRegisterActivity Inter);

    //用户登录
    void Login(ILoginRegisterActivity Inter);

    //获取短信验证码
    String getMessageAuthentication(String phone);
}
