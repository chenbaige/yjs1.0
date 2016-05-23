package com.yjtc.cbg.yjsapp.Presenter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.View.inter.IpubMsg;
import com.yjtc.cbg.yjsapp.model.PublishMessageModel;
import com.yjtc.cbg.yjsapp.model.inter.IpublishMessage;

/**
 * Created by chen on 2016/5/18.
 */
public class PublishMessagePresenter {

    private IpublishMessage mMsgModel;

    private IpubMsg mMsg;

    private Context mContext;

    public PublishMessagePresenter(IpubMsg mMsg,Context context) {
        this.mMsg = mMsg;
        this.mContext=context;
        mMsgModel = new PublishMessageModel(context,mMsg);
    }

    public void startLocation(){
        mMsgModel.getCurrentLocation();
    }
}
