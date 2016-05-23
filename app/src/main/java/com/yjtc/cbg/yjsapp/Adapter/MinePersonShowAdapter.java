package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/5/6.
 */
public class MinePersonShowAdapter extends BaseAdapter<Banner, BaseViewHolder> {


    public MinePersonShowAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {
        Picasso.with(mContext).load(mDatas.get(position).getImgUrl()).into(holder.getImageView(R.id.id_image));
    }
}

