package com.yjtc.cbg.yjsapp.model.inter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.View.inter.IMessageAuth;

/**
 * Created by chen on 2016/5/18.
 */
public interface IMessageAuthentication {
    void getMessageCode(String phone,IMessageAuth iMessageAuth);

    void submitMessageCode(String code,String phone,IMessageAuth iMessageAuth);

    //取消短信验证码注册
    void unRegisterMessage();

}
