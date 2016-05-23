package com.yjtc.cbg.yjsapp.model;

import android.content.Context;

import com.squareup.okhttp.Response;
import com.yjtc.cbg.yjsapp.View.inter.ILoginRegisterActivity;
import com.yjtc.cbg.yjsapp.http.OkHttpHelper;
import com.yjtc.cbg.yjsapp.http.SpotsCallback;
import com.yjtc.cbg.yjsapp.model.inter.IUserLogin;

/**
 * Created by chenboge on 16/4/29.
 */
public class UserLoginAndRegister implements IUserLogin {

    private OkHttpHelper mHelper=OkHttpHelper.getInstance();
    private Context mContext;

    public UserLoginAndRegister(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void Register(final ILoginRegisterActivity Inter) {
        mHelper.get("http://112.124.22.238:8081/course_api/campaign/recommend",null , new SpotsCallback<String>(mContext) {

            @Override
            public void onSuccess(Response response, String s) {
                Inter.Success(s);
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                //  Toast.makeText(mContext,"error",Toast.LENGTH_SHORT).show();
                Inter.Faild(e.getMessage());
            }

            @Override
            public void onTokenError(Response response, int code) {

            }
        });
    }

    @Override
    public void Login(final ILoginRegisterActivity Inter) {
        mHelper.get("http://112.124.22.238:8081/course_api/campaign/recommend",null , new SpotsCallback<String>(mContext) {

            @Override
            public void onSuccess(Response response, String s) {
                Inter.Success(s);
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                //  Toast.makeText(mContext,"error",Toast.LENGTH_SHORT).show();
                Inter.Faild(e.getMessage());
            }

            @Override
            public void onTokenError(Response response, int code) {

            }
        });
    }

    @Override
    public String getMessageAuthentication(String phone) {
        return null;
    }
}
