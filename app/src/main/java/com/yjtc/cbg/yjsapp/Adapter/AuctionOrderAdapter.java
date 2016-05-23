package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chen on 2016/5/16.
 */
public class AuctionOrderAdapter extends BaseAdapter<Banner,BaseViewHolder>{

    public AuctionOrderAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {

    }
}
