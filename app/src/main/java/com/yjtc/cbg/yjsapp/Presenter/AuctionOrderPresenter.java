package com.yjtc.cbg.yjsapp.Presenter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.View.inter.IOrderActivity;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

/**
 * Created by chen on 2016/5/16.
 */
public class AuctionOrderPresenter {

    private IHome home = new HomeModel();
    private IOrderActivity orderActivity;

    private Context mContext;

    public AuctionOrderPresenter(IOrderActivity orderActivity, Context mContext) {
        this.orderActivity = orderActivity;
        this.mContext = mContext;
    }

    public void LoadData(){
      orderActivity.initUIData(home.getBanners());
    }

}
