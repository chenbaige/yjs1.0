package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chen on 2016/5/16.
 */
public class AuctionNotPayAdapter extends BaseAdapter<Banner,BaseViewHolder>{

    public AuctionNotPayAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {
        holder.getTextView(R.id.id_auction_shop_state).setText("拍品状态：未付款");
//        holder.getButton(R.id.id_continue_post).setText("付款");
    }
}
