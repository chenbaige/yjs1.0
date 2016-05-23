package com.yjtc.cbg.yjsapp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.HomePageActivity;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by chenboge on 16/4/30.
 */
public abstract class BaseFragment extends Fragment {

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

    abstract void initData();

    //abstract void initToolBar();

    public void initToolBar(){
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

    //toolbar左侧点击事件处理
    abstract void leftClick();
    //toolbar右侧点击事件处理
    abstract void rightClick();

}
