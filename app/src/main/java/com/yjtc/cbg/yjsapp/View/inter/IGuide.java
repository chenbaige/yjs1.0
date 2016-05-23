package com.yjtc.cbg.yjsapp.View.inter;

import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

/**
 * Created by chenboge on 16/4/29.
 */
public interface IGuide {

   ViewPager getViewpager();

    LinearLayout getLayout();

    void showLiveButton();

    void fideLiveButton();
}
