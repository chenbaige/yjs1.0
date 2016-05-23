package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.IdentityHashMap;

/**
 * Created by chenboge on 16/2/10.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private View mHeaderView;

    private SparseArray<View> mViews;
    private Context mContext;
    private BaseAdapter.onItemClickListener monItemClickListener;

    public BaseViewHolder(View itemView,View mHeaderView, BaseAdapter.onItemClickListener onItemClickListener) {
        super(itemView);
        this.mHeaderView=mHeaderView;
        if(itemView==mHeaderView) return;
        mViews = new SparseArray<>();
        this.monItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);
    }

    private <T extends View> T findView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }

    public View getView(int id) {
        return findView(id);
    }

    public TextView getTextView(int id) {
        return findView(id);
    }

    public ImageView getImageView(int id) {
        return findView(id);
    }

    public Button getButton(int id) {
        return findView(id);
    }

    @Override
    public void onClick(View v) {
        if(monItemClickListener!=null) {
            monItemClickListener.onClick(v, getLayoutPosition());
        }
    }
}
