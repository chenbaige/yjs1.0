package com.yjtc.cbg.yjsapp.bean;

/**
 * Created by chenboge on 16/1/30.
 */
public class Tab {
    private int title;
    private int resId;

    public Tab(int title, int resId, Class fragment) {
        this.title = title;
        this.resId = resId;
        this.fragment = fragment;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    private Class fragment;
}
