package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/5/12.
 */
public class AuctioningHeaderViewAdapter extends BaseAdapter<Banner, BaseViewHolder> {

    public AuctioningHeaderViewAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {

    }
}
