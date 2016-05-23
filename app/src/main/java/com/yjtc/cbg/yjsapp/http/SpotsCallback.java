package com.yjtc.cbg.yjsapp.http;

import android.content.Context;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.List;

import dmax.dialog.SpotsDialog;

/**
 * Created by chenboge on 16/2/3.
 */
public abstract class SpotsCallback<T> extends BaseCallback<T> {

    private Context mContext;

    public SpotsCallback(Context mContext) {
        this.mContext = mContext;
        //mDialog = new SpotsDialog(mContext);
        initSpotsDialog();
    }
    private SpotsDialog mDialog;


    public void showDialog() {
        mDialog.show();
    }


    private void initSpotsDialog() {

        mDialog = new SpotsDialog(mContext, "拼命加载中...");

    }


    public void setLoadMessage(int resId){
        mDialog.setMessage(mContext.getString(resId));
    }

    public void dismissDialog() {
        mDialog.dismiss();
    }

    @Override
    public void onBeforeRequest(Request request) {
        showDialog();
    }

    @Override
    public void onFailure(Request request, Exception e) {
        dismissDialog();
    }

    @Override
    public void onResponse(Response response) {
        dismissDialog();
    }

}
