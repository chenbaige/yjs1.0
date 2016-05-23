package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.User;

import java.util.List;

/**
 * Created by chenboge on 16/5/9.
 */
public class FriendListAdapter extends android.widget.BaseAdapter {

    private Context context;
    private List<User> list;
    private ViewHolder viewHolder;

    public FriendListAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = list.get(position).getUserName();
        viewHolder = new ViewHolder();
        if (item.length() == 1) {
            convertView = LayoutInflater.from(context).inflate(R.layout.index,
                    null);
            viewHolder.indexTv = (TextView) convertView
                    .findViewById(R.id.Tv);
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item,
                    null);
            viewHolder.itemTv = (TextView) convertView
                    .findViewById(R.id.Tv);
        }
        if (item.length() == 1) {
            viewHolder.indexTv.setText(list.get(position).getUserName());
        } else {
            viewHolder.itemTv.setText(list.get(position).getUserName());
        }
        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        // TODO Auto-generated method stub
        if (list.get(position).getUserName().length() == 1)// 如果是字母索引
            return false;// 表示不能点击
        return super.isEnabled(position);
    }


    class ViewHolder {
        private TextView indexTv;
        private TextView itemTv;
    }
}
