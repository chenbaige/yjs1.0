package com.yjtc.cbg.yjsapp.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.Constans;
import com.yjtc.cbg.yjsapp.Presenter.LoginPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IMessageAuth;
import com.yjtc.cbg.yjsapp.Widget.ClearEditText;
import com.yjtc.cbg.yjsapp.util.ManifestUtil;
import com.yjtc.cbg.yjsapp.util.StringCheckedUtil;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

/**
 * Created by chenboge on 16/5/8.
 */
@ContentView(R.layout.message_authentication)
public class MessageAuthenticationActivity extends BaseActivity implements IMessageAuth {
    private Intent PreIntent;

    private boolean IS_FORGET_PASSWORD = false;
    @ViewInject(R.id.id_phone_num)
    private ClearEditText mPhoneNum;

    @ViewInject(R.id.id_tv_get_message)
    private TextView mTime;

    @ViewInject(R.id.id_message_auth)
    private ClearEditText mMessageAuth;

    private LoginPresenter mPresenter;

    private MyTimeCount mTimer;

    @Override
    void initData() {
        mTimer = new MyTimeCount(60000, 1000);
        mPresenter = new LoginPresenter(this, this);
        PreIntent = getIntent();
        if (PreIntent.getIntExtra("Flag", 0) == LoginActivity.FORGET_PASSWORD) {
            IS_FORGET_PASSWORD = true;
        }
    }

    //点击下一步
    @Event(value = R.id.id_next_step)
    private void next(View view) {
        if (IS_FORGET_PASSWORD) {
            startActivity(new Intent(MessageAuthenticationActivity.this, ChangePasswordActivity.class));
        } else {
            String phone = mPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
            mPresenter.submitMessageAuth(mMessageAuth.getText().toString(), phone, this);
        }
    }

    //点击获取验证码
    @Event(value = R.id.id_tv_get_message)
    private void getAuthor(View view) {
        // getCode();
        String phone = mPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
        mPresenter.SendMessageAuth(phone, this);
        mTimer.start();
    }

    //点击登录
    @Event(value = R.id.id_tv_login)
    private void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.DestroyMessage();
    }

    @Override
    public void getMessageCodeSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMessageAuth.setEnabled(true);
                ToastUtil.showToast(MessageAuthenticationActivity.this, "请求验证码成功");
            }
        });

    }

    @Override
    public void getMessageCodeFailed() {

    }

    @Override
    public void submitMessageCodeSuccess() {
        startActivity(new Intent(MessageAuthenticationActivity.this, RegisterActivity.class));
    }

    @Override
    public void submitMessageCodeFailed() {
        ToastUtil.showToast(this, "提交验证码失败");
    }



    //获取验证码倒计时
    class MyTimeCount extends CountDownTimer {

        public MyTimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            mTime.setClickable(false);
            mTime.setText("剩余"+l/1000+"秒");
        }

        @Override
        public void onFinish() {
            mTime.setText(R.string.to_get_message);
            mTime.setClickable(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTimer.cancel();
    }
}


