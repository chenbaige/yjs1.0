package com.yjtc.cbg.yjsapp.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IMessageAuth;
import com.yjtc.cbg.yjsapp.model.inter.IMessageAuthentication;
import com.yjtc.cbg.yjsapp.util.ManifestUtil;
import com.yjtc.cbg.yjsapp.util.StringCheckedUtil;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

/**
 * Created by chen on 2016/5/18.
 */
public class MessageAuthenticationModel implements IMessageAuthentication {

    private Context mContext;

    private static final String DEFAULT_COUNTRY_ID = "42";

    private SMSEvenHanlder evenHanlder;

    private String countryCode;

    private IMessageAuth mMessageAuth;

    public MessageAuthenticationModel(Context context) {
        this.mContext = context;
        SMSSDK.initSDK(mContext, ManifestUtil.getMetaDataValue(mContext, "mob_sms_appKey"),
                ManifestUtil.getMetaDataValue(mContext, "mob_sms_appSecrect"));
        evenHanlder = new SMSEvenHanlder();
        SMSSDK.registerEventHandler(evenHanlder);
        String[] country = SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
        if (country != null) {
            countryCode = "+" + country[1];
        }
    }

    @Override
    public void getMessageCode(String phone, IMessageAuth iMessageAuth) {
        this.mMessageAuth = iMessageAuth;
        StringCheckedUtil.checkPhoneNum(mContext, phone, countryCode);
        System.out.println("countryCode:" + countryCode + "phone" + phone);
        //not 86   +86
        //向服务器请求发送验证码,验证成功就会回调callback接口
        SMSSDK.getVerificationCode(countryCode, phone);
    }

    @Override
    public void submitMessageCode(String code, String phone, IMessageAuth iMessageAuth) {
        if (TextUtils.isEmpty(code)) {
            ToastUtil.showToast(mContext, R.string.smssdk_write_identify_code);
            return;
        }
        SMSSDK.submitVerificationCode(countryCode, phone, code);
    }

    @Override
    public void unRegisterMessage() {
        SMSSDK.unregisterEventHandler(evenHanlder);
    }

    private String[] getCurrentCountry() {
        String mcc = getMCC();
        String[] country = null;
        if (!TextUtils.isEmpty(mcc)) {
            country = SMSSDK.getCountryByMCC(mcc);
        }
        if (country == null) {
            Log.w("SMSSDK", "no country found by MCC: " + mcc);
            country = SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
        }
        return country;
    }

    private String getMCC() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        // 返回当前手机注册的网络运营商所在国家的MCC+MNC. 如果没注册到网络就为空.
        String networkOperator = tm.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return networkOperator;
        }

        // 返回SIM卡运营商所在国家的MCC+MNC. 5位或6位. 如果没有SIM卡返回空
        return tm.getSimOperator();
    }

    class SMSEvenHanlder extends EventHandler {

        @Override
        public void afterEvent(final int event, final int result,
                               final Object data) {
            //回调完成
            if (result == SMSSDK.RESULT_COMPLETE) {
                if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    //返回支持发送验证码的国家列表
                    onCountryListGot((ArrayList<HashMap<String, Object>>) data);

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    // 请求验证码后，填写验证码
                    //afterVerificationCodeRequested((Boolean) data);
                    if ((Boolean) data) {
                        mMessageAuth.getMessageCodeSuccess();
                    } else {
                        mMessageAuth.getMessageCodeFailed();
                    }
                } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //提交验证码成功
                    mMessageAuth.submitMessageCodeSuccess();
                }
            } else {
                // 根据服务器返回的网络错误，给toast提示
                try {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;

                    JSONObject object = new JSONObject(
                            throwable.getMessage());
                    String des = object.optString("detail");
                    if (!TextUtils.isEmpty(des)) {
                        ToastUtil.showToast(mContext, des);
                        return;
                    }
                } catch (Exception e) {
                    SMSLog.getInstance().w(e);
                }

            }
        }
    }

    private void onCountryListGot(ArrayList<HashMap<String, Object>> countries) {
        // 解析国家列表
        for (HashMap<String, Object> country : countries) {
            String code = (String) country.get("zone");
            String rule = (String) country.get("rule");
            if (TextUtils.isEmpty(code) || TextUtils.isEmpty(rule)) {
                continue;
            }
            Log.d("tag", "code=" + code + "rule=" + rule);
        }
    }
}
