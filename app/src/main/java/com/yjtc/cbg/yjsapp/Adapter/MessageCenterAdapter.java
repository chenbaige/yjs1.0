package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2016/5/23.
 */
public class MessageCenterAdapter extends BaseAdapter<Banner, BaseViewHolder> {

    public MessageCenterAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {
        holder.getTextView(R.id.id_chat_news_username).setText("艺匠客服");
        holder.getTextView(R.id.id_chat_news_message).setText("卧槽，访问量突破100亿啦！！");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        holder.getTextView(R.id.id_chat_news_time).setText(str);
    }
}
