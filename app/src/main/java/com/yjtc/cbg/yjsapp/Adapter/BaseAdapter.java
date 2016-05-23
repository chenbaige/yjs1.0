package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.text.Normalizer;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenboge on 16/2/10.
 */
public abstract class  BaseAdapter<T, H extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {

    //header布局标志
    private static final int TYPE_HEADER=0;
    //普通布局标志
    public static final int TYPE_NORMAL=1;
    //headerview的布局
    private View mHeaderView;

    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);
    }

    protected Context mContext;
    protected List<T> mDatas;
    public LayoutInflater mInflater;
    public onItemClickListener monItemClickListener;
    public int itemViewID;

    public BaseAdapter(Context mContext, List<T> mDatas, int itemViewID) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.itemViewID = itemViewID;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView==null) return TYPE_NORMAL;
        if(position==0)return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    public interface onItemClickListener {
        void onClick(View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener itemClickListener) {
        this.monItemClickListener = itemClickListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView!=null&&viewType==TYPE_HEADER) return new BaseViewHolder(mHeaderView,mHeaderView,null);
        View mView = null;
        mView = mInflater.inflate(itemViewID, null, false);
        return new BaseViewHolder(mView, mHeaderView,monItemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_HEADER) return;
        bindData(holder, position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public List<T> getDatas() {
        return mDatas;
    }


    public void AddData(List<T> datas) {

        AddData(0, datas);
    }

    public void AddData(int position, List<T> list) {

        if (list != null && list.size() > 0) {

            for (T t : list) {
                mDatas.add(position, t);
                notifyItemInserted(position);
            }

        }

    }


    public void removeItem(T t) {
        int position = mDatas.indexOf(t);
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public void ClearData() {

        if (mDatas == null || mDatas.size() <= 0)
            return;

        for (Iterator it = mDatas.iterator(); it.hasNext(); ) {

            T t = (T) it.next();
            int position = mDatas.indexOf(t);
            it.remove();
            notifyItemRemoved(position);
        }
    }


    public void refreshData(List<T> data) {
        ClearData();
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                mDatas.add(i, data.get(i));
                notifyItemInserted(i);
            }
        }
    }

    public void loadMoreData(List<T> data) {
        if (data != null && data.size() > 0) {
            //ClearData();
            int begin = mDatas.size();
            for (int i = 0; i < data.size(); i++) {
                mDatas.add(data.get(i));
                notifyItemInserted(begin + i);
            }
        }
    }

    abstract void bindData(BaseViewHolder holder, int position);
}
