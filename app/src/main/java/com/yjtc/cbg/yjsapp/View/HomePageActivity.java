package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.yjtc.cbg.mainnavigatetabbar.widget.MainNavigateTabBar;
import com.yjtc.cbg.yjsapp.Presenter.HomeActivityPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IHomePage;
import com.yjtc.cbg.yjsapp.fragment.ChatFragment;
import com.yjtc.cbg.yjsapp.fragment.HomeFragment;
import com.yjtc.cbg.yjsapp.fragment.MineFragment;
import com.yjtc.cbg.yjsapp.fragment.SchoolFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by chenboge on 16/4/29.
 */
@ContentView(R.layout.homepage)
public class HomePageActivity extends FragmentActivity implements IHomePage, View.OnClickListener {


    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "校内";
    private static final String TAG_PAGE_PUBLISH = "拍卖";
    private static final String TAG_PAGE_MESSAGE = "消息";
    private static final String TAG_PAGE_PERSON = "我的";
    //private YJSToolBar mToolBar;
    private HomeActivityPresenter mPresenter;
    private MainNavigateTabBar mNavigateTabBar;

    private ImageView ivPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData(savedInstanceState);
    }


    public void initData(Bundle savedInstanceState) {
        mNavigateTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);
        ivPost = (ImageView) findViewById(R.id.tab_post_icon);
        ivPost.setOnClickListener(this);
        mNavigateTabBar.setDefaultSelectedTab(3);
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.home_27, R.mipmap.home_13, TAG_PAGE_HOME));
        mNavigateTabBar.addTab(SchoolFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.school_25, R.mipmap.school_16, TAG_PAGE_CITY));
        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(ChatFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.news_29, R.mipmap.news_10, TAG_PAGE_MESSAGE));
        mNavigateTabBar.addTab(MineFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.my_33, R.mipmap.my_19, TAG_PAGE_PERSON));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "拍卖", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, AuctionActivity.class));
    }

}
