package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenboge on 16/5/9.
 */
public class ChatNewsAdapter extends BaseAdapter<User, BaseViewHolder> {

    public ChatNewsAdapter(Context mContext, List<User> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {
        ((CircleImageView) holder.getView(R.id.id_chat_user_head)).setImageResource(R.mipmap.myhead);
        holder.getTextView(R.id.id_chat_news_username).setText(mDatas.get(position).getUserName());
        //holder.getTextView(R.id.id_chat_news_time).setText();

    }
}
