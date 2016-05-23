package com.yjtc.cbg.yjsapp.View.inter;

/**
 * Created by chen on 2016/5/18.
 */
public interface IMessageAuth {
    //获取短信验证码成功
    void getMessageCodeSuccess();
    //获取短信验证码失败
    void getMessageCodeFailed();
    //提交短信验证码成功
    void submitMessageCodeSuccess();
    //提交短信验证码失败
    void submitMessageCodeFailed();
}
