package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.MineActivity;
import com.yjtc.cbg.yjsapp.View.PicturePreviewActivity;
import com.yjtc.cbg.yjsapp.Widget.MyPopupWindow;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chen on 2016/5/13.
 */
public class AuctionAdapter extends BaseAdapter<Banner,BaseViewHolder> implements View.OnClickListener {

    private MyAdapter mAdapter = null;

    public AuctionAdapter(Context mContext, List<Banner> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
    }

    @Override
    void bindData(BaseViewHolder holder, int position) {
        ((CircleImageView) holder.getView(R.id.id_user_head)).setOnClickListener(this);
        holder.getTextView(R.id.id_private_chat).setOnClickListener(this);
        holder.getTextView(R.id.id_support).setOnClickListener(this);
        holder.getTextView(R.id.id_popular).setOnClickListener(this);
        holder.getTextView(R.id.id_remind_offer).setOnClickListener(this);
        NineGridlayout mLayout = (NineGridlayout) holder.getView(R.id.id_art_image);
        final List<Banner> banners = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            banners.add(new Banner("shop", "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1462346059&di=44d1d336abaab39bb6bd08a53d80b9d9&src=http://imgditan.cang.com/201408/29/201408291227561098199.JPG"));
        }
        mAdapter = new MyAdapter(mContext, banners);
        mLayout.setAdapter(mAdapter);
        mLayout.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(mContext, PicturePreviewActivity.class);
                intent.putExtra("url", banners.get(position).getImgUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击右侧价格事件
            case R.id.id_right_price:
//                int[] items={R.id.id_one,R.id.id_two};
//                MyPopupWindow mWindow = new MyPopupWindow(activity, R.layout.home_popup, items);
//                //mWindow.setmListener(mContext);
//                mWindow.showPopupWindow(mIV);
                break;

            //点击头像事件
            case R.id.id_user_head:
                mContext.startActivity(new Intent(mContext, MineActivity.class));
                break;

            //点击私聊按钮事件
            case R.id.id_private_chat:
                ToastUtil.showToast(mContext, "私聊");
                break;

            //点击收藏按钮事件
            case R.id.id_popular:
                ToastUtil.showToast(mContext, "收藏");
                break;

            //点击点赞按钮事件
            case R.id.id_support:
                ToastUtil.showToast(mContext, "点赞");
                break;

            //点击出价按钮事件
            case R.id.id_remind_offer:
                ToastUtil.showToast(mContext, "出价");
                break;
        }

    }
    class MyAdapter extends NineGridAdapter {


        private List<Banner> banners;

        public MyAdapter(Context context, List<Banner> list) {
            super(context, list);
            this.banners = list;
        }

        @Override
        public int getCount() {
            return (banners == null) ? 0 : banners.size();
        }

        @Override
        public String getUrl(int position) {
            return banners.get(position).getImgUrl();
            //return getItem(position) == null ? null : ((Image) getItem(position)).getUrl();
        }

        @Override
        public Object getItem(int position) {
            return (banners == null) ? null : banners.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setBackgroundColor(Color.parseColor("#f5f5f5"));
            Picasso.with(context).load(getUrl(i)).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(iv);
            return iv;
        }
    }
}


