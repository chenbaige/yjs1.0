package com.yjtc.cbg.yjsapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.AuctionActivity;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by chenboge on 16/5/11.
 */
public abstract class BaseV4Fragment extends Fragment {

    @ViewInject(R.id.id_toolbar)
    public YJSToolBar mToolbar;

    private boolean injected = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            x.view().inject(this, this.getView());
        }
        initToolBar();
        initData();
    }


    public void initToolBar() {
        mToolbar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftClick();
            }
        });
        mToolbar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightClick();
            }
        });
    }

    abstract void initData();

    //toolbar左侧点击事件处理
    abstract void leftClick();

    //toolbar右侧点击事件处理
    abstract void rightClick();

}
